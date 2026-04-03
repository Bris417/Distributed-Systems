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
 * PositionService is a simple unary RPC.
 * The client sends one request and gets one response back.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: PositionServer.proto")
public final class PositionServiceGrpc {

  private PositionServiceGrpc() {}

  public static final String SERVICE_NAME = "LifeUnderWater.PositionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<LifeUnderWater.PositionServer.PositionAsk,
      LifeUnderWater.PositionServer.PositionRet> getGetPositionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPosition",
      requestType = LifeUnderWater.PositionServer.PositionAsk.class,
      responseType = LifeUnderWater.PositionServer.PositionRet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<LifeUnderWater.PositionServer.PositionAsk,
      LifeUnderWater.PositionServer.PositionRet> getGetPositionMethod() {
    io.grpc.MethodDescriptor<LifeUnderWater.PositionServer.PositionAsk, LifeUnderWater.PositionServer.PositionRet> getGetPositionMethod;
    if ((getGetPositionMethod = PositionServiceGrpc.getGetPositionMethod) == null) {
      synchronized (PositionServiceGrpc.class) {
        if ((getGetPositionMethod = PositionServiceGrpc.getGetPositionMethod) == null) {
          PositionServiceGrpc.getGetPositionMethod = getGetPositionMethod = 
              io.grpc.MethodDescriptor.<LifeUnderWater.PositionServer.PositionAsk, LifeUnderWater.PositionServer.PositionRet>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "LifeUnderWater.PositionService", "GetPosition"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LifeUnderWater.PositionServer.PositionAsk.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LifeUnderWater.PositionServer.PositionRet.getDefaultInstance()))
                  .setSchemaDescriptor(new PositionServiceMethodDescriptorSupplier("GetPosition"))
                  .build();
          }
        }
     }
     return getGetPositionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PositionServiceStub newStub(io.grpc.Channel channel) {
    return new PositionServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PositionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PositionServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PositionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PositionServiceFutureStub(channel);
  }

  /**
   * <pre>
   * PositionService is a simple unary RPC.
   * The client sends one request and gets one response back.
   * </pre>
   */
  public static abstract class PositionServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getPosition(LifeUnderWater.PositionServer.PositionAsk request,
        io.grpc.stub.StreamObserver<LifeUnderWater.PositionServer.PositionRet> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPositionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPositionMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                LifeUnderWater.PositionServer.PositionAsk,
                LifeUnderWater.PositionServer.PositionRet>(
                  this, METHODID_GET_POSITION)))
          .build();
    }
  }

  /**
   * <pre>
   * PositionService is a simple unary RPC.
   * The client sends one request and gets one response back.
   * </pre>
   */
  public static final class PositionServiceStub extends io.grpc.stub.AbstractStub<PositionServiceStub> {
    private PositionServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PositionServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PositionServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PositionServiceStub(channel, callOptions);
    }

    /**
     */
    public void getPosition(LifeUnderWater.PositionServer.PositionAsk request,
        io.grpc.stub.StreamObserver<LifeUnderWater.PositionServer.PositionRet> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetPositionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * PositionService is a simple unary RPC.
   * The client sends one request and gets one response back.
   * </pre>
   */
  public static final class PositionServiceBlockingStub extends io.grpc.stub.AbstractStub<PositionServiceBlockingStub> {
    private PositionServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PositionServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PositionServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PositionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public LifeUnderWater.PositionServer.PositionRet getPosition(LifeUnderWater.PositionServer.PositionAsk request) {
      return blockingUnaryCall(
          getChannel(), getGetPositionMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * PositionService is a simple unary RPC.
   * The client sends one request and gets one response back.
   * </pre>
   */
  public static final class PositionServiceFutureStub extends io.grpc.stub.AbstractStub<PositionServiceFutureStub> {
    private PositionServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PositionServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PositionServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PositionServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<LifeUnderWater.PositionServer.PositionRet> getPosition(
        LifeUnderWater.PositionServer.PositionAsk request) {
      return futureUnaryCall(
          getChannel().newCall(getGetPositionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_POSITION = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PositionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PositionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_POSITION:
          serviceImpl.getPosition((LifeUnderWater.PositionServer.PositionAsk) request,
              (io.grpc.stub.StreamObserver<LifeUnderWater.PositionServer.PositionRet>) responseObserver);
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

  private static abstract class PositionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PositionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return LifeUnderWater.PositionServer.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PositionService");
    }
  }

  private static final class PositionServiceFileDescriptorSupplier
      extends PositionServiceBaseDescriptorSupplier {
    PositionServiceFileDescriptorSupplier() {}
  }

  private static final class PositionServiceMethodDescriptorSupplier
      extends PositionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PositionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PositionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PositionServiceFileDescriptorSupplier())
              .addMethod(getGetPositionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
