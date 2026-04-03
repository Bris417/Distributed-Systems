package LifeUnderWater;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * NamingService works like a very small phone book.
 * Other services can register themselves here, and the client can ask where a service is.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: NamingService.proto")
public final class NamingServiceGrpc {

  private NamingServiceGrpc() {}

  public static final String SERVICE_NAME = "LifeUnderWater.NamingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<LifeUnderWater.NamingServiceOuterClass.ServiceInfo,
      LifeUnderWater.NamingServiceOuterClass.RegisterResponse> getRegisterServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterService",
      requestType = LifeUnderWater.NamingServiceOuterClass.ServiceInfo.class,
      responseType = LifeUnderWater.NamingServiceOuterClass.RegisterResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<LifeUnderWater.NamingServiceOuterClass.ServiceInfo,
      LifeUnderWater.NamingServiceOuterClass.RegisterResponse> getRegisterServiceMethod() {
    io.grpc.MethodDescriptor<LifeUnderWater.NamingServiceOuterClass.ServiceInfo, LifeUnderWater.NamingServiceOuterClass.RegisterResponse> getRegisterServiceMethod;
    if ((getRegisterServiceMethod = NamingServiceGrpc.getRegisterServiceMethod) == null) {
      synchronized (NamingServiceGrpc.class) {
        if ((getRegisterServiceMethod = NamingServiceGrpc.getRegisterServiceMethod) == null) {
          NamingServiceGrpc.getRegisterServiceMethod = getRegisterServiceMethod = 
              io.grpc.MethodDescriptor.<LifeUnderWater.NamingServiceOuterClass.ServiceInfo, LifeUnderWater.NamingServiceOuterClass.RegisterResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "LifeUnderWater.NamingService", "RegisterService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LifeUnderWater.NamingServiceOuterClass.ServiceInfo.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LifeUnderWater.NamingServiceOuterClass.RegisterResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new NamingServiceMethodDescriptorSupplier("RegisterService"))
                  .build();
          }
        }
     }
     return getRegisterServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<LifeUnderWater.NamingServiceOuterClass.ServiceRequest,
      LifeUnderWater.NamingServiceOuterClass.ServiceInfo> getDiscoverServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DiscoverService",
      requestType = LifeUnderWater.NamingServiceOuterClass.ServiceRequest.class,
      responseType = LifeUnderWater.NamingServiceOuterClass.ServiceInfo.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<LifeUnderWater.NamingServiceOuterClass.ServiceRequest,
      LifeUnderWater.NamingServiceOuterClass.ServiceInfo> getDiscoverServiceMethod() {
    io.grpc.MethodDescriptor<LifeUnderWater.NamingServiceOuterClass.ServiceRequest, LifeUnderWater.NamingServiceOuterClass.ServiceInfo> getDiscoverServiceMethod;
    if ((getDiscoverServiceMethod = NamingServiceGrpc.getDiscoverServiceMethod) == null) {
      synchronized (NamingServiceGrpc.class) {
        if ((getDiscoverServiceMethod = NamingServiceGrpc.getDiscoverServiceMethod) == null) {
          NamingServiceGrpc.getDiscoverServiceMethod = getDiscoverServiceMethod = 
              io.grpc.MethodDescriptor.<LifeUnderWater.NamingServiceOuterClass.ServiceRequest, LifeUnderWater.NamingServiceOuterClass.ServiceInfo>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "LifeUnderWater.NamingService", "DiscoverService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LifeUnderWater.NamingServiceOuterClass.ServiceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LifeUnderWater.NamingServiceOuterClass.ServiceInfo.getDefaultInstance()))
                  .setSchemaDescriptor(new NamingServiceMethodDescriptorSupplier("DiscoverService"))
                  .build();
          }
        }
     }
     return getDiscoverServiceMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static NamingServiceStub newStub(io.grpc.Channel channel) {
    return new NamingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static NamingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new NamingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static NamingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new NamingServiceFutureStub(channel);
  }

  /**
   * <pre>
   * NamingService works like a very small phone book.
   * Other services can register themselves here, and the client can ask where a service is.
   * </pre>
   */
  public static abstract class NamingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void registerService(LifeUnderWater.NamingServiceOuterClass.ServiceInfo request,
        io.grpc.stub.StreamObserver<LifeUnderWater.NamingServiceOuterClass.RegisterResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegisterServiceMethod(), responseObserver);
    }

    /**
     */
    public void discoverService(LifeUnderWater.NamingServiceOuterClass.ServiceRequest request,
        io.grpc.stub.StreamObserver<LifeUnderWater.NamingServiceOuterClass.ServiceInfo> responseObserver) {
      asyncUnimplementedUnaryCall(getDiscoverServiceMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRegisterServiceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                LifeUnderWater.NamingServiceOuterClass.ServiceInfo,
                LifeUnderWater.NamingServiceOuterClass.RegisterResponse>(
                  this, METHODID_REGISTER_SERVICE)))
          .addMethod(
            getDiscoverServiceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                LifeUnderWater.NamingServiceOuterClass.ServiceRequest,
                LifeUnderWater.NamingServiceOuterClass.ServiceInfo>(
                  this, METHODID_DISCOVER_SERVICE)))
          .build();
    }
  }

  /**
   * <pre>
   * NamingService works like a very small phone book.
   * Other services can register themselves here, and the client can ask where a service is.
   * </pre>
   */
  public static final class NamingServiceStub extends io.grpc.stub.AbstractStub<NamingServiceStub> {
    private NamingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NamingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NamingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NamingServiceStub(channel, callOptions);
    }

    /**
     */
    public void registerService(LifeUnderWater.NamingServiceOuterClass.ServiceInfo request,
        io.grpc.stub.StreamObserver<LifeUnderWater.NamingServiceOuterClass.RegisterResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegisterServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void discoverService(LifeUnderWater.NamingServiceOuterClass.ServiceRequest request,
        io.grpc.stub.StreamObserver<LifeUnderWater.NamingServiceOuterClass.ServiceInfo> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDiscoverServiceMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * NamingService works like a very small phone book.
   * Other services can register themselves here, and the client can ask where a service is.
   * </pre>
   */
  public static final class NamingServiceBlockingStub extends io.grpc.stub.AbstractStub<NamingServiceBlockingStub> {
    private NamingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NamingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NamingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NamingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public LifeUnderWater.NamingServiceOuterClass.RegisterResponse registerService(LifeUnderWater.NamingServiceOuterClass.ServiceInfo request) {
      return blockingUnaryCall(
          getChannel(), getRegisterServiceMethod(), getCallOptions(), request);
    }

    /**
     */
    public LifeUnderWater.NamingServiceOuterClass.ServiceInfo discoverService(LifeUnderWater.NamingServiceOuterClass.ServiceRequest request) {
      return blockingUnaryCall(
          getChannel(), getDiscoverServiceMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * NamingService works like a very small phone book.
   * Other services can register themselves here, and the client can ask where a service is.
   * </pre>
   */
  public static final class NamingServiceFutureStub extends io.grpc.stub.AbstractStub<NamingServiceFutureStub> {
    private NamingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private NamingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected NamingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new NamingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<LifeUnderWater.NamingServiceOuterClass.RegisterResponse> registerService(
        LifeUnderWater.NamingServiceOuterClass.ServiceInfo request) {
      return futureUnaryCall(
          getChannel().newCall(getRegisterServiceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<LifeUnderWater.NamingServiceOuterClass.ServiceInfo> discoverService(
        LifeUnderWater.NamingServiceOuterClass.ServiceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDiscoverServiceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REGISTER_SERVICE = 0;
  private static final int METHODID_DISCOVER_SERVICE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final NamingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(NamingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REGISTER_SERVICE:
          serviceImpl.registerService((LifeUnderWater.NamingServiceOuterClass.ServiceInfo) request,
              (io.grpc.stub.StreamObserver<LifeUnderWater.NamingServiceOuterClass.RegisterResponse>) responseObserver);
          break;
        case METHODID_DISCOVER_SERVICE:
          serviceImpl.discoverService((LifeUnderWater.NamingServiceOuterClass.ServiceRequest) request,
              (io.grpc.stub.StreamObserver<LifeUnderWater.NamingServiceOuterClass.ServiceInfo>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class NamingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    NamingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return LifeUnderWater.NamingServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("NamingService");
    }
  }

  private static final class NamingServiceFileDescriptorSupplier
      extends NamingServiceBaseDescriptorSupplier {
    NamingServiceFileDescriptorSupplier() {}
  }

  private static final class NamingServiceMethodDescriptorSupplier
      extends NamingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    NamingServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (NamingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new NamingServiceFileDescriptorSupplier())
              .addMethod(getRegisterServiceMethod())
              .addMethod(getDiscoverServiceMethod())
              .build();
        }
      }
    }
    return result;
  }
}
