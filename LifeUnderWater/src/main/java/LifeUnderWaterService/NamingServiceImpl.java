package LifeUnderWaterService;

import LifeUnderWater.NamingServiceGrpc;
import LifeUnderWater.NamingServiceOuterClass.RegisterResponse;
import LifeUnderWater.NamingServiceOuterClass.ServiceInfo;
import LifeUnderWater.NamingServiceOuterClass.ServiceRequest;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class NamingServiceImpl extends NamingServiceGrpc.NamingServiceImplBase {

    private static final int DEFAULT_PORT = 50050;

    // This map is our small in-memory registry.
    // It is enough for demo use because we only need simple service discovery.
    private final Map<String, ServiceInfo> registry = new HashMap<>();

    @Override
    public void registerService(ServiceInfo request,
                                StreamObserver<RegisterResponse> responseObserver) {
        // Save the latest host and port for this service name.
        registry.put(request.getName(), request);

        RegisterResponse response = RegisterResponse.newBuilder()
                .setStatus("Registered")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void discoverService(ServiceRequest request,
                                StreamObserver<ServiceInfo> responseObserver) {
        // The client only sends a name, and we return the saved service info if it exists.
        ServiceInfo service = registry.get(request.getName());

        if (service != null) {
            responseObserver.onNext(service);
        }

        responseObserver.onCompleted();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;

        // This service can run by itself.
        // No extra launcher is needed now.
        Server server = ServerBuilder.forPort(port)
                .addService(new NamingServiceImpl())
                .build()
                .start();

        System.out.println("NamingService started on port " + port);
        server.awaitTermination();
    }
}
