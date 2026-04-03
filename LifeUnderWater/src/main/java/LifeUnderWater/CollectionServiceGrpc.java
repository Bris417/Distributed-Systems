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
 * CollectionService shows the two streaming styles used in this project.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: CollectionService.proto")
public final class CollectionServiceGrpc {

  private CollectionServiceGrpc() {}

  public static final String SERVICE_NAME = "LifeUnderWater.CollectionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<LifeUnderWater.CollectionServiceOuterClass.RecordPathPoint,
      LifeUnderWater.CollectionServiceOuterClass.CollectionSummary> getRecordCollectionPathMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RecordCollectionPath",
      requestType = LifeUnderWater.CollectionServiceOuterClass.RecordPathPoint.class,
      responseType = LifeUnderWater.CollectionServiceOuterClass.CollectionSummary.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<LifeUnderWater.CollectionServiceOuterClass.RecordPathPoint,
      LifeUnderWater.CollectionServiceOuterClass.CollectionSummary> getRecordCollectionPathMethod() {
    io.grpc.MethodDescriptor<LifeUnderWater.CollectionServiceOuterClass.RecordPathPoint, LifeUnderWater.CollectionServiceOuterClass.CollectionSummary> getRecordCollectionPathMethod;
    if ((getRecordCollectionPathMethod = CollectionServiceGrpc.getRecordCollectionPathMethod) == null) {
      synchronized (CollectionServiceGrpc.class) {
        if ((getRecordCollectionPathMethod = CollectionServiceGrpc.getRecordCollectionPathMethod) == null) {
          CollectionServiceGrpc.getRecordCollectionPathMethod = getRecordCollectionPathMethod = 
              io.grpc.MethodDescriptor.<LifeUnderWater.CollectionServiceOuterClass.RecordPathPoint, LifeUnderWater.CollectionServiceOuterClass.CollectionSummary>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "LifeUnderWater.CollectionService", "RecordCollectionPath"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LifeUnderWater.CollectionServiceOuterClass.RecordPathPoint.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LifeUnderWater.CollectionServiceOuterClass.CollectionSummary.getDefaultInstance()))
                  .setSchemaDescriptor(new CollectionServiceMethodDescriptorSupplier("RecordCollectionPath"))
                  .build();
          }
        }
     }
     return getRecordCollectionPathMethod;
  }

  private static volatile io.grpc.MethodDescriptor<LifeUnderWater.CollectionServiceOuterClass.RobotStatus,
      LifeUnderWater.CollectionServiceOuterClass.Command> getStartTargetedCollectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StartTargetedCollection",
      requestType = LifeUnderWater.CollectionServiceOuterClass.RobotStatus.class,
      responseType = LifeUnderWater.CollectionServiceOuterClass.Command.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<LifeUnderWater.CollectionServiceOuterClass.RobotStatus,
      LifeUnderWater.CollectionServiceOuterClass.Command> getStartTargetedCollectionMethod() {
    io.grpc.MethodDescriptor<LifeUnderWater.CollectionServiceOuterClass.RobotStatus, LifeUnderWater.CollectionServiceOuterClass.Command> getStartTargetedCollectionMethod;
    if ((getStartTargetedCollectionMethod = CollectionServiceGrpc.getStartTargetedCollectionMethod) == null) {
      synchronized (CollectionServiceGrpc.class) {
        if ((getStartTargetedCollectionMethod = CollectionServiceGrpc.getStartTargetedCollectionMethod) == null) {
          CollectionServiceGrpc.getStartTargetedCollectionMethod = getStartTargetedCollectionMethod = 
              io.grpc.MethodDescriptor.<LifeUnderWater.CollectionServiceOuterClass.RobotStatus, LifeUnderWater.CollectionServiceOuterClass.Command>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "LifeUnderWater.CollectionService", "StartTargetedCollection"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LifeUnderWater.CollectionServiceOuterClass.RobotStatus.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  LifeUnderWater.CollectionServiceOuterClass.Command.getDefaultInstance()))
                  .setSchemaDescriptor(new CollectionServiceMethodDescriptorSupplier("StartTargetedCollection"))
                  .build();
          }
        }
     }
     return getStartTargetedCollectionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CollectionServiceStub newStub(io.grpc.Channel channel) {
    return new CollectionServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CollectionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new CollectionServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CollectionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new CollectionServiceFutureStub(channel);
  }

  /**
   * <pre>
   * CollectionService shows the two streaming styles used in this project.
   * </pre>
   */
  public static abstract class CollectionServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Client streaming:
     * the client sends many path points, then the server returns one summary.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<LifeUnderWater.CollectionServiceOuterClass.RecordPathPoint> recordCollectionPath(
        io.grpc.stub.StreamObserver<LifeUnderWater.CollectionServiceOuterClass.CollectionSummary> responseObserver) {
      return asyncUnimplementedStreamingCall(getRecordCollectionPathMethod(), responseObserver);
    }

    /**
     * <pre>
     * Bidirectional streaming:
     * the client sends robot status values, and the server answers with commands.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<LifeUnderWater.CollectionServiceOuterClass.RobotStatus> startTargetedCollection(
        io.grpc.stub.StreamObserver<LifeUnderWater.CollectionServiceOuterClass.Command> responseObserver) {
      return asyncUnimplementedStreamingCall(getStartTargetedCollectionMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getRecordCollectionPathMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                LifeUnderWater.CollectionServiceOuterClass.RecordPathPoint,
                LifeUnderWater.CollectionServiceOuterClass.CollectionSummary>(
                  this, METHODID_RECORD_COLLECTION_PATH)))
          .addMethod(
            getStartTargetedCollectionMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                LifeUnderWater.CollectionServiceOuterClass.RobotStatus,
                LifeUnderWater.CollectionServiceOuterClass.Command>(
                  this, METHODID_START_TARGETED_COLLECTION)))
          .build();
    }
  }

  /**
   * <pre>
   * CollectionService shows the two streaming styles used in this project.
   * </pre>
   */
  public static final class CollectionServiceStub extends io.grpc.stub.AbstractStub<CollectionServiceStub> {
    private CollectionServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CollectionServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CollectionServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CollectionServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Client streaming:
     * the client sends many path points, then the server returns one summary.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<LifeUnderWater.CollectionServiceOuterClass.RecordPathPoint> recordCollectionPath(
        io.grpc.stub.StreamObserver<LifeUnderWater.CollectionServiceOuterClass.CollectionSummary> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getRecordCollectionPathMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * Bidirectional streaming:
     * the client sends robot status values, and the server answers with commands.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<LifeUnderWater.CollectionServiceOuterClass.RobotStatus> startTargetedCollection(
        io.grpc.stub.StreamObserver<LifeUnderWater.CollectionServiceOuterClass.Command> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getStartTargetedCollectionMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * CollectionService shows the two streaming styles used in this project.
   * </pre>
   */
  public static final class CollectionServiceBlockingStub extends io.grpc.stub.AbstractStub<CollectionServiceBlockingStub> {
    private CollectionServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CollectionServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CollectionServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CollectionServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * CollectionService shows the two streaming styles used in this project.
   * </pre>
   */
  public static final class CollectionServiceFutureStub extends io.grpc.stub.AbstractStub<CollectionServiceFutureStub> {
    private CollectionServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private CollectionServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CollectionServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new CollectionServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_RECORD_COLLECTION_PATH = 0;
  private static final int METHODID_START_TARGETED_COLLECTION = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CollectionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CollectionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_RECORD_COLLECTION_PATH:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.recordCollectionPath(
              (io.grpc.stub.StreamObserver<LifeUnderWater.CollectionServiceOuterClass.CollectionSummary>) responseObserver);
        case METHODID_START_TARGETED_COLLECTION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.startTargetedCollection(
              (io.grpc.stub.StreamObserver<LifeUnderWater.CollectionServiceOuterClass.Command>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CollectionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CollectionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return LifeUnderWater.CollectionServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CollectionService");
    }
  }

  private static final class CollectionServiceFileDescriptorSupplier
      extends CollectionServiceBaseDescriptorSupplier {
    CollectionServiceFileDescriptorSupplier() {}
  }

  private static final class CollectionServiceMethodDescriptorSupplier
      extends CollectionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CollectionServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (CollectionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CollectionServiceFileDescriptorSupplier())
              .addMethod(getRecordCollectionPathMethod())
              .addMethod(getStartTargetedCollectionMethod())
              .build();
        }
      }
    }
    return result;
  }
}
