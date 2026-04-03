package LifeUnderWaterService;

import LifeUnderWater.CollectionServiceGrpc;
import LifeUnderWater.CollectionServiceOuterClass.CollectionSummary;
import LifeUnderWater.CollectionServiceOuterClass.Command;
import LifeUnderWater.CollectionServiceOuterClass.RecordPathPoint;
import LifeUnderWater.CollectionServiceOuterClass.RobotStatus;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;

public class CollectionServiceImpl extends CollectionServiceGrpc.CollectionServiceImplBase {

    private static final int DEFAULT_PORT = 50053;

    @Override
    public StreamObserver<RecordPathPoint> recordCollectionPath(
            StreamObserver<CollectionSummary> responseObserver) {

        // In client streaming, the server waits until the client finishes sending all points.
        return new StreamObserver<RecordPathPoint>() {

            int count = 0;

            @Override
            public void onNext(RecordPathPoint value) {
                count++;
                System.out.println("Received point: " + value.getLatitudeE7());
            }

            @Override
            public void onError(Throwable t) {}

            @Override
            public void onCompleted() {
                // The final summary is sent once, after all path points are received.
                CollectionSummary summary = CollectionSummary.newBuilder()
                        .setResult("Collected points: " + count)
                        .build();

                responseObserver.onNext(summary);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<RobotStatus> startTargetedCollection(
            StreamObserver<Command> responseObserver) {

        // In bidirectional streaming, each incoming robot status can trigger a reply command.
        return new StreamObserver<RobotStatus>() {

            @Override
            public void onNext(RobotStatus status) {
                // The rule is simple on purpose so it is easy to follow in the client output.
                if (status.getBatteryPercentage() < 20) {
                    responseObserver.onNext(
                            Command.newBuilder().setAction("RETURN").build());
                } else {
                    responseObserver.onNext(
                            Command.newBuilder().setAction("CONTINUE").build());
                }
            }

            @Override
            public void onError(Throwable t) {}

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        Server server = ServerBuilder.forPort(port)
                .addService(new CollectionServiceImpl())
                .build()
                .start();

        System.out.println("CollectionService started on port " + port);
        server.awaitTermination();
    }
}
