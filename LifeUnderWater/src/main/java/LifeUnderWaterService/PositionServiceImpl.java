package LifeUnderWaterService;

import LifeUnderWater.PositionServer.Coordinate;
import LifeUnderWater.PositionServer.PositionAsk;
import LifeUnderWater.PositionServer.PositionRet;
import LifeUnderWater.PositionServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;

public class PositionServiceImpl extends PositionServiceGrpc.PositionServiceImplBase {

    private static final int DEFAULT_PORT = 50051;

    @Override
    public void getPosition(PositionAsk request, StreamObserver<PositionRet> responseObserver) {
        System.out.println("Received request for position near: "
                + request.getLatitudeE7() + ", " + request.getLongitudeE7());

        // For this coursework demo, we return one fixed coordinate.
        // The point is to show the RPC flow, not real GPS logic.
        Coordinate c1 = Coordinate.newBuilder()
                .setLatitudeE7(123456789)
                .setLongitudeE7(987654321)
                .build();

        PositionRet response = PositionRet.newBuilder()
                .addPositions(c1)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        Server server = ServerBuilder.forPort(port)
                .addService(new PositionServiceImpl())
                .build()
                .start();

        System.out.println("PositionService started on port " + port);
        server.awaitTermination();
    }
}
