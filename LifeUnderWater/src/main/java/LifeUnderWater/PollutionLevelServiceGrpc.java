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
 * PollutionLevelService uses server streaming.
 * One client request can produce many pollution level messages.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: PollutionLevelService.proto")
public final class PollutionLevelServiceGrpc {

  private PollutionLevelServiceGrpc() {}

  public static final String SERVICE_NAME = "LifeUnderWater.PollutionLevelService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelAsk,
      LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelRet> getGetPollutionLevelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPollutionLevel",
      requestType = LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelAsk.class,
      responseType = LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelRet.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelAsk,
      LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelRet> getGetPollutionLevelMethod() {
    io.grpc.MethodDescriptor<LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelAsk, LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelRet> getGetPollutionLevelMethod;
    if ((getGetPollutionLevelMethod = PollutionLevelServiceGrpc.getGetPollutionLevelMethod) == null) {
      synchronized (PollutionLevelServiceGrpc.class) {
        if ((getGetPollutionLevelMethod = PollutionLevelServiceGrpc.getGetPollutionLevelMethod) == null) {
          PollutionLevelServiceGrpc.getGetPollutionLevelMethod = getGetPollutionLevelMethod = 
              io.grpc.MethodDescriptor.<LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelAsk, LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelRet>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "LifeUnderWater.PollutionLevelService", "GetPollutionLevel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelAsk.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelRet.getDefaultInstance()))
                  .setSchemaDescriptor(new PollutionLevelServiceMethodDescriptorSupplier("GetPollutionLevel"))
                  .build();
          }
        }
     }
     return getGetPollutionLevelMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PollutionLevelServiceStub newStub(io.grpc.Channel channel) {
    return new PollutionLevelServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PollutionLevelServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PollutionLevelServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PollutionLevelServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PollutionLevelServiceFutureStub(channel);
  }

  /**
   * <pre>
   * PollutionLevelService uses server streaming.
   * One client request can produce many pollution level messages.
   * </pre>
   */
  public static abstract class PollutionLevelServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getPollutionLevel(LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelAsk request,
        io.grpc.stub.StreamObserver<LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelRet> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPollutionLevelMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPollutionLevelMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelAsk,
                LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelRet>(
                  this, METHODID_GET_POLLUTION_LEVEL)))
          .build();
    }
  }

  /**
   * <pre>
   * PollutionLevelService uses server streaming.
   * One client request can produce many pollution level messages.
   * </pre>
   */
  public static final class PollutionLevelServiceStub extends io.grpc.stub.AbstractStub<PollutionLevelServiceStub> {
    private PollutionLevelServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PollutionLevelServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PollutionLevelServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PollutionLevelServiceStub(channel, callOptions);
    }

    /**
     */
    public void getPollutionLevel(LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelAsk request,
        io.grpc.stub.StreamObserver<LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelRet> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetPollutionLevelMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * PollutionLevelService uses server streaming.
   * One client request can produce many pollution level messages.
   * </pre>
   */
  public static final class PollutionLevelServiceBlockingStub extends io.grpc.stub.AbstractStub<PollutionLevelServiceBlockingStub> {
    private PollutionLevelServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PollutionLevelServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PollutionLevelServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PollutionLevelServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelRet> getPollutionLevel(
        LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelAsk request) {
      return blockingServerStreamingCall(
          getChannel(), getGetPollutionLevelMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * PollutionLevelService uses server streaming.
   * One client request can produce many pollution level messages.
   * </pre>
   */
  public static final class PollutionLevelServiceFutureStub extends io.grpc.stub.AbstractStub<PollutionLevelServiceFutureStub> {
    private PollutionLevelServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PollutionLevelServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PollutionLevelServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PollutionLevelServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_POLLUTION_LEVEL = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PollutionLevelServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PollutionLevelServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_POLLUTION_LEVEL:
          serviceImpl.getPollutionLevel((LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelAsk) request,
              (io.grpc.stub.StreamObserver<LifeUnderWater.PollutionLevelServiceOuterClass.PollutionLevelRet>) responseObserver);
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

  private static abstract class PollutionLevelServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PollutionLevelServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return LifeUnderWater.PollutionLevelServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PollutionLevelService");
    }
  }

  private static final class PollutionLevelServiceFileDescriptorSupplier
      extends PollutionLevelServiceBaseDescriptorSupplier {
    PollutionLevelServiceFileDescriptorSupplier() {}
  }

  private static final class PollutionLevelServiceMethodDescriptorSupplier
      extends PollutionLevelServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PollutionLevelServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PollutionLevelServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PollutionLevelServiceFileDescriptorSupplier())
              .addMethod(getGetPollutionLevelMethod())
              .build();
        }
      }
    }
    return result;
  }
}
