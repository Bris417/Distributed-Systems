package LifeUnderWaterService;

import LifeUnderWater.PollutionLevelServiceGrpc;
import LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelAsk;
import LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelRet;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;

public class PollutionLevelServiceImpl extends PollutionLevelServiceGrpc.PollutionLevelServiceImplBase {

    private static final int DEFAULT_PORT = 50052;

    @Override
    public void getPollutionLevel(PollutionLevelAsk request,
                                 StreamObserver<PollutionLevelRet> responseObserver) {

        int base = request.getPollutionLevel();

        // This service uses server streaming.
        // One request from the client creates many messages from the server.
        for (int i = 0; i < 5; i++) {
            PollutionLevelRet response = PollutionLevelRet.newBuilder()
                    .setLevel(base + i)
                    .build();

            responseObserver.onNext(response);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }

        responseObserver.onCompleted();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        Server server = ServerBuilder.forPort(port)
                .addService(new PollutionLevelServiceImpl())
                .build()
                .start();

        System.out.println("PollutionLevelService started on port " + port);
        server.awaitTermination();
    }
}
