package com.example.configserver.protoController;

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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.24.0)",
    comments = "Source: protofile.proto")
public final class ServiceServiceGrpc {

  private ServiceServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.configserver.protoController.ServiceService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.Service,
      com.example.configserver.protoController.Protofile.ResponseService> getAddServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addService",
      requestType = com.example.configserver.protoController.Protofile.Service.class,
      responseType = com.example.configserver.protoController.Protofile.ResponseService.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.Service,
      com.example.configserver.protoController.Protofile.ResponseService> getAddServiceMethod() {
    io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.Service, com.example.configserver.protoController.Protofile.ResponseService> getAddServiceMethod;
    if ((getAddServiceMethod = ServiceServiceGrpc.getAddServiceMethod) == null) {
      synchronized (ServiceServiceGrpc.class) {
        if ((getAddServiceMethod = ServiceServiceGrpc.getAddServiceMethod) == null) {
          ServiceServiceGrpc.getAddServiceMethod = getAddServiceMethod =
              io.grpc.MethodDescriptor.<com.example.configserver.protoController.Protofile.Service, com.example.configserver.protoController.Protofile.ResponseService>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.configserver.protoController.Protofile.Service.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.configserver.protoController.Protofile.ResponseService.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceServiceMethodDescriptorSupplier("addService"))
              .build();
        }
      }
    }
    return getAddServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.NameService,
      com.example.configserver.protoController.Protofile.ResponseService> getGetServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getService",
      requestType = com.example.configserver.protoController.Protofile.NameService.class,
      responseType = com.example.configserver.protoController.Protofile.ResponseService.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.NameService,
      com.example.configserver.protoController.Protofile.ResponseService> getGetServiceMethod() {
    io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.NameService, com.example.configserver.protoController.Protofile.ResponseService> getGetServiceMethod;
    if ((getGetServiceMethod = ServiceServiceGrpc.getGetServiceMethod) == null) {
      synchronized (ServiceServiceGrpc.class) {
        if ((getGetServiceMethod = ServiceServiceGrpc.getGetServiceMethod) == null) {
          ServiceServiceGrpc.getGetServiceMethod = getGetServiceMethod =
              io.grpc.MethodDescriptor.<com.example.configserver.protoController.Protofile.NameService, com.example.configserver.protoController.Protofile.ResponseService>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.configserver.protoController.Protofile.NameService.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.configserver.protoController.Protofile.ResponseService.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceServiceMethodDescriptorSupplier("getService"))
              .build();
        }
      }
    }
    return getGetServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.NameService,
      com.example.configserver.protoController.Protofile.ResponseService> getDeleteServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteService",
      requestType = com.example.configserver.protoController.Protofile.NameService.class,
      responseType = com.example.configserver.protoController.Protofile.ResponseService.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.NameService,
      com.example.configserver.protoController.Protofile.ResponseService> getDeleteServiceMethod() {
    io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.NameService, com.example.configserver.protoController.Protofile.ResponseService> getDeleteServiceMethod;
    if ((getDeleteServiceMethod = ServiceServiceGrpc.getDeleteServiceMethod) == null) {
      synchronized (ServiceServiceGrpc.class) {
        if ((getDeleteServiceMethod = ServiceServiceGrpc.getDeleteServiceMethod) == null) {
          ServiceServiceGrpc.getDeleteServiceMethod = getDeleteServiceMethod =
              io.grpc.MethodDescriptor.<com.example.configserver.protoController.Protofile.NameService, com.example.configserver.protoController.Protofile.ResponseService>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteService"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.configserver.protoController.Protofile.NameService.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.configserver.protoController.Protofile.ResponseService.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceServiceMethodDescriptorSupplier("deleteService"))
              .build();
        }
      }
    }
    return getDeleteServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.NameService,
      com.example.configserver.protoController.Protofile.ArrayConfig> getGetAllConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllConfigs",
      requestType = com.example.configserver.protoController.Protofile.NameService.class,
      responseType = com.example.configserver.protoController.Protofile.ArrayConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.NameService,
      com.example.configserver.protoController.Protofile.ArrayConfig> getGetAllConfigsMethod() {
    io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.NameService, com.example.configserver.protoController.Protofile.ArrayConfig> getGetAllConfigsMethod;
    if ((getGetAllConfigsMethod = ServiceServiceGrpc.getGetAllConfigsMethod) == null) {
      synchronized (ServiceServiceGrpc.class) {
        if ((getGetAllConfigsMethod = ServiceServiceGrpc.getGetAllConfigsMethod) == null) {
          ServiceServiceGrpc.getGetAllConfigsMethod = getGetAllConfigsMethod =
              io.grpc.MethodDescriptor.<com.example.configserver.protoController.Protofile.NameService, com.example.configserver.protoController.Protofile.ArrayConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllConfigs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.configserver.protoController.Protofile.NameService.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.configserver.protoController.Protofile.ArrayConfig.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceServiceMethodDescriptorSupplier("getAllConfigs"))
              .build();
        }
      }
    }
    return getGetAllConfigsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServiceServiceStub newStub(io.grpc.Channel channel) {
    return new ServiceServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServiceServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ServiceServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServiceServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ServiceServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ServiceServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addService(com.example.configserver.protoController.Protofile.Service request,
        io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseService> responseObserver) {
      asyncUnimplementedUnaryCall(getAddServiceMethod(), responseObserver);
    }

    /**
     */
    public void getService(com.example.configserver.protoController.Protofile.NameService request,
        io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseService> responseObserver) {
      asyncUnimplementedUnaryCall(getGetServiceMethod(), responseObserver);
    }

    /**
     */
    public void deleteService(com.example.configserver.protoController.Protofile.NameService request,
        io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseService> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteServiceMethod(), responseObserver);
    }

    /**
     */
    public void getAllConfigs(com.example.configserver.protoController.Protofile.NameService request,
        io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ArrayConfig> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllConfigsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddServiceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.configserver.protoController.Protofile.Service,
                com.example.configserver.protoController.Protofile.ResponseService>(
                  this, METHODID_ADD_SERVICE)))
          .addMethod(
            getGetServiceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.configserver.protoController.Protofile.NameService,
                com.example.configserver.protoController.Protofile.ResponseService>(
                  this, METHODID_GET_SERVICE)))
          .addMethod(
            getDeleteServiceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.configserver.protoController.Protofile.NameService,
                com.example.configserver.protoController.Protofile.ResponseService>(
                  this, METHODID_DELETE_SERVICE)))
          .addMethod(
            getGetAllConfigsMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.configserver.protoController.Protofile.NameService,
                com.example.configserver.protoController.Protofile.ArrayConfig>(
                  this, METHODID_GET_ALL_CONFIGS)))
          .build();
    }
  }

  /**
   */
  public static final class ServiceServiceStub extends io.grpc.stub.AbstractStub<ServiceServiceStub> {
    private ServiceServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServiceServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServiceServiceStub(channel, callOptions);
    }

    /**
     */
    public void addService(com.example.configserver.protoController.Protofile.Service request,
        io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseService> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getService(com.example.configserver.protoController.Protofile.NameService request,
        io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseService> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteService(com.example.configserver.protoController.Protofile.NameService request,
        io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseService> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteServiceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllConfigs(com.example.configserver.protoController.Protofile.NameService request,
        io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ArrayConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllConfigsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ServiceServiceBlockingStub extends io.grpc.stub.AbstractStub<ServiceServiceBlockingStub> {
    private ServiceServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServiceServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServiceServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.configserver.protoController.Protofile.ResponseService addService(com.example.configserver.protoController.Protofile.Service request) {
      return blockingUnaryCall(
          getChannel(), getAddServiceMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.configserver.protoController.Protofile.ResponseService getService(com.example.configserver.protoController.Protofile.NameService request) {
      return blockingUnaryCall(
          getChannel(), getGetServiceMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.configserver.protoController.Protofile.ResponseService deleteService(com.example.configserver.protoController.Protofile.NameService request) {
      return blockingUnaryCall(
          getChannel(), getDeleteServiceMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.configserver.protoController.Protofile.ArrayConfig getAllConfigs(com.example.configserver.protoController.Protofile.NameService request) {
      return blockingUnaryCall(
          getChannel(), getGetAllConfigsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ServiceServiceFutureStub extends io.grpc.stub.AbstractStub<ServiceServiceFutureStub> {
    private ServiceServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ServiceServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ServiceServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.configserver.protoController.Protofile.ResponseService> addService(
        com.example.configserver.protoController.Protofile.Service request) {
      return futureUnaryCall(
          getChannel().newCall(getAddServiceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.configserver.protoController.Protofile.ResponseService> getService(
        com.example.configserver.protoController.Protofile.NameService request) {
      return futureUnaryCall(
          getChannel().newCall(getGetServiceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.configserver.protoController.Protofile.ResponseService> deleteService(
        com.example.configserver.protoController.Protofile.NameService request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteServiceMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.configserver.protoController.Protofile.ArrayConfig> getAllConfigs(
        com.example.configserver.protoController.Protofile.NameService request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllConfigsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_SERVICE = 0;
  private static final int METHODID_GET_SERVICE = 1;
  private static final int METHODID_DELETE_SERVICE = 2;
  private static final int METHODID_GET_ALL_CONFIGS = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServiceServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServiceServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_SERVICE:
          serviceImpl.addService((com.example.configserver.protoController.Protofile.Service) request,
              (io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseService>) responseObserver);
          break;
        case METHODID_GET_SERVICE:
          serviceImpl.getService((com.example.configserver.protoController.Protofile.NameService) request,
              (io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseService>) responseObserver);
          break;
        case METHODID_DELETE_SERVICE:
          serviceImpl.deleteService((com.example.configserver.protoController.Protofile.NameService) request,
              (io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseService>) responseObserver);
          break;
        case METHODID_GET_ALL_CONFIGS:
          serviceImpl.getAllConfigs((com.example.configserver.protoController.Protofile.NameService) request,
              (io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ArrayConfig>) responseObserver);
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

  private static abstract class ServiceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServiceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.configserver.protoController.Protofile.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServiceService");
    }
  }

  private static final class ServiceServiceFileDescriptorSupplier
      extends ServiceServiceBaseDescriptorSupplier {
    ServiceServiceFileDescriptorSupplier() {}
  }

  private static final class ServiceServiceMethodDescriptorSupplier
      extends ServiceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServiceServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ServiceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServiceServiceFileDescriptorSupplier())
              .addMethod(getAddServiceMethod())
              .addMethod(getGetServiceMethod())
              .addMethod(getDeleteServiceMethod())
              .addMethod(getGetAllConfigsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
