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
public final class ConfigServiceGrpc {

  private ConfigServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.configserver.protoController.ConfigService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.Config,
      com.example.configserver.protoController.Protofile.ResponseConfig> getAddConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addConfig",
      requestType = com.example.configserver.protoController.Protofile.Config.class,
      responseType = com.example.configserver.protoController.Protofile.ResponseConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.Config,
      com.example.configserver.protoController.Protofile.ResponseConfig> getAddConfigMethod() {
    io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.Config, com.example.configserver.protoController.Protofile.ResponseConfig> getAddConfigMethod;
    if ((getAddConfigMethod = ConfigServiceGrpc.getAddConfigMethod) == null) {
      synchronized (ConfigServiceGrpc.class) {
        if ((getAddConfigMethod = ConfigServiceGrpc.getAddConfigMethod) == null) {
          ConfigServiceGrpc.getAddConfigMethod = getAddConfigMethod =
              io.grpc.MethodDescriptor.<com.example.configserver.protoController.Protofile.Config, com.example.configserver.protoController.Protofile.ResponseConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.configserver.protoController.Protofile.Config.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.configserver.protoController.Protofile.ResponseConfig.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigServiceMethodDescriptorSupplier("addConfig"))
              .build();
        }
      }
    }
    return getAddConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.NameConfig,
      com.example.configserver.protoController.Protofile.ResponseConfig> getGetConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getConfig",
      requestType = com.example.configserver.protoController.Protofile.NameConfig.class,
      responseType = com.example.configserver.protoController.Protofile.ResponseConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.NameConfig,
      com.example.configserver.protoController.Protofile.ResponseConfig> getGetConfigMethod() {
    io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.NameConfig, com.example.configserver.protoController.Protofile.ResponseConfig> getGetConfigMethod;
    if ((getGetConfigMethod = ConfigServiceGrpc.getGetConfigMethod) == null) {
      synchronized (ConfigServiceGrpc.class) {
        if ((getGetConfigMethod = ConfigServiceGrpc.getGetConfigMethod) == null) {
          ConfigServiceGrpc.getGetConfigMethod = getGetConfigMethod =
              io.grpc.MethodDescriptor.<com.example.configserver.protoController.Protofile.NameConfig, com.example.configserver.protoController.Protofile.ResponseConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.configserver.protoController.Protofile.NameConfig.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.configserver.protoController.Protofile.ResponseConfig.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigServiceMethodDescriptorSupplier("getConfig"))
              .build();
        }
      }
    }
    return getGetConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.Config,
      com.example.configserver.protoController.Protofile.ResponseConfig> getUpdateConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateConfig",
      requestType = com.example.configserver.protoController.Protofile.Config.class,
      responseType = com.example.configserver.protoController.Protofile.ResponseConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.Config,
      com.example.configserver.protoController.Protofile.ResponseConfig> getUpdateConfigMethod() {
    io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.Config, com.example.configserver.protoController.Protofile.ResponseConfig> getUpdateConfigMethod;
    if ((getUpdateConfigMethod = ConfigServiceGrpc.getUpdateConfigMethod) == null) {
      synchronized (ConfigServiceGrpc.class) {
        if ((getUpdateConfigMethod = ConfigServiceGrpc.getUpdateConfigMethod) == null) {
          ConfigServiceGrpc.getUpdateConfigMethod = getUpdateConfigMethod =
              io.grpc.MethodDescriptor.<com.example.configserver.protoController.Protofile.Config, com.example.configserver.protoController.Protofile.ResponseConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.configserver.protoController.Protofile.Config.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.configserver.protoController.Protofile.ResponseConfig.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigServiceMethodDescriptorSupplier("updateConfig"))
              .build();
        }
      }
    }
    return getUpdateConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.NameAndVersion,
      com.example.configserver.protoController.Protofile.ResponseConfig> getDeleteConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteConfig",
      requestType = com.example.configserver.protoController.Protofile.NameAndVersion.class,
      responseType = com.example.configserver.protoController.Protofile.ResponseConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.NameAndVersion,
      com.example.configserver.protoController.Protofile.ResponseConfig> getDeleteConfigMethod() {
    io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.NameAndVersion, com.example.configserver.protoController.Protofile.ResponseConfig> getDeleteConfigMethod;
    if ((getDeleteConfigMethod = ConfigServiceGrpc.getDeleteConfigMethod) == null) {
      synchronized (ConfigServiceGrpc.class) {
        if ((getDeleteConfigMethod = ConfigServiceGrpc.getDeleteConfigMethod) == null) {
          ConfigServiceGrpc.getDeleteConfigMethod = getDeleteConfigMethod =
              io.grpc.MethodDescriptor.<com.example.configserver.protoController.Protofile.NameAndVersion, com.example.configserver.protoController.Protofile.ResponseConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.configserver.protoController.Protofile.NameAndVersion.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.configserver.protoController.Protofile.ResponseConfig.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigServiceMethodDescriptorSupplier("deleteConfig"))
              .build();
        }
      }
    }
    return getDeleteConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.configserver.protoController.Protofile.ArrayConfig> getGetAllConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllConfig",
      requestType = com.google.protobuf.Empty.class,
      responseType = com.example.configserver.protoController.Protofile.ArrayConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      com.example.configserver.protoController.Protofile.ArrayConfig> getGetAllConfigMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.example.configserver.protoController.Protofile.ArrayConfig> getGetAllConfigMethod;
    if ((getGetAllConfigMethod = ConfigServiceGrpc.getGetAllConfigMethod) == null) {
      synchronized (ConfigServiceGrpc.class) {
        if ((getGetAllConfigMethod = ConfigServiceGrpc.getGetAllConfigMethod) == null) {
          ConfigServiceGrpc.getGetAllConfigMethod = getGetAllConfigMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.example.configserver.protoController.Protofile.ArrayConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.configserver.protoController.Protofile.ArrayConfig.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigServiceMethodDescriptorSupplier("getAllConfig"))
              .build();
        }
      }
    }
    return getGetAllConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.NameAndVersion,
      com.example.configserver.protoController.Protofile.ResponseConfig> getGetVersionConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getVersionConfig",
      requestType = com.example.configserver.protoController.Protofile.NameAndVersion.class,
      responseType = com.example.configserver.protoController.Protofile.ResponseConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.NameAndVersion,
      com.example.configserver.protoController.Protofile.ResponseConfig> getGetVersionConfigMethod() {
    io.grpc.MethodDescriptor<com.example.configserver.protoController.Protofile.NameAndVersion, com.example.configserver.protoController.Protofile.ResponseConfig> getGetVersionConfigMethod;
    if ((getGetVersionConfigMethod = ConfigServiceGrpc.getGetVersionConfigMethod) == null) {
      synchronized (ConfigServiceGrpc.class) {
        if ((getGetVersionConfigMethod = ConfigServiceGrpc.getGetVersionConfigMethod) == null) {
          ConfigServiceGrpc.getGetVersionConfigMethod = getGetVersionConfigMethod =
              io.grpc.MethodDescriptor.<com.example.configserver.protoController.Protofile.NameAndVersion, com.example.configserver.protoController.Protofile.ResponseConfig>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getVersionConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.configserver.protoController.Protofile.NameAndVersion.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.configserver.protoController.Protofile.ResponseConfig.getDefaultInstance()))
              .setSchemaDescriptor(new ConfigServiceMethodDescriptorSupplier("getVersionConfig"))
              .build();
        }
      }
    }
    return getGetVersionConfigMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ConfigServiceStub newStub(io.grpc.Channel channel) {
    return new ConfigServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ConfigServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ConfigServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ConfigServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ConfigServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ConfigServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void addConfig(com.example.configserver.protoController.Protofile.Config request,
        io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseConfig> responseObserver) {
      asyncUnimplementedUnaryCall(getAddConfigMethod(), responseObserver);
    }

    /**
     */
    public void getConfig(com.example.configserver.protoController.Protofile.NameConfig request,
        io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseConfig> responseObserver) {
      asyncUnimplementedUnaryCall(getGetConfigMethod(), responseObserver);
    }

    /**
     */
    public void updateConfig(com.example.configserver.protoController.Protofile.Config request,
        io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseConfig> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateConfigMethod(), responseObserver);
    }

    /**
     */
    public void deleteConfig(com.example.configserver.protoController.Protofile.NameAndVersion request,
        io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseConfig> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteConfigMethod(), responseObserver);
    }

    /**
     */
    public void getAllConfig(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ArrayConfig> responseObserver) {
      asyncUnimplementedUnaryCall(getGetAllConfigMethod(), responseObserver);
    }

    /**
     */
    public void getVersionConfig(com.example.configserver.protoController.Protofile.NameAndVersion request,
        io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseConfig> responseObserver) {
      asyncUnimplementedUnaryCall(getGetVersionConfigMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAddConfigMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.configserver.protoController.Protofile.Config,
                com.example.configserver.protoController.Protofile.ResponseConfig>(
                  this, METHODID_ADD_CONFIG)))
          .addMethod(
            getGetConfigMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.configserver.protoController.Protofile.NameConfig,
                com.example.configserver.protoController.Protofile.ResponseConfig>(
                  this, METHODID_GET_CONFIG)))
          .addMethod(
            getUpdateConfigMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.configserver.protoController.Protofile.Config,
                com.example.configserver.protoController.Protofile.ResponseConfig>(
                  this, METHODID_UPDATE_CONFIG)))
          .addMethod(
            getDeleteConfigMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.configserver.protoController.Protofile.NameAndVersion,
                com.example.configserver.protoController.Protofile.ResponseConfig>(
                  this, METHODID_DELETE_CONFIG)))
          .addMethod(
            getGetAllConfigMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.google.protobuf.Empty,
                com.example.configserver.protoController.Protofile.ArrayConfig>(
                  this, METHODID_GET_ALL_CONFIG)))
          .addMethod(
            getGetVersionConfigMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.example.configserver.protoController.Protofile.NameAndVersion,
                com.example.configserver.protoController.Protofile.ResponseConfig>(
                  this, METHODID_GET_VERSION_CONFIG)))
          .build();
    }
  }

  /**
   */
  public static final class ConfigServiceStub extends io.grpc.stub.AbstractStub<ConfigServiceStub> {
    private ConfigServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConfigServiceStub(channel, callOptions);
    }

    /**
     */
    public void addConfig(com.example.configserver.protoController.Protofile.Config request,
        io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getConfig(com.example.configserver.protoController.Protofile.NameConfig request,
        io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateConfig(com.example.configserver.protoController.Protofile.Config request,
        io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteConfig(com.example.configserver.protoController.Protofile.NameAndVersion request,
        io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllConfig(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ArrayConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetAllConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getVersionConfig(com.example.configserver.protoController.Protofile.NameAndVersion request,
        io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseConfig> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetVersionConfigMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ConfigServiceBlockingStub extends io.grpc.stub.AbstractStub<ConfigServiceBlockingStub> {
    private ConfigServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConfigServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.configserver.protoController.Protofile.ResponseConfig addConfig(com.example.configserver.protoController.Protofile.Config request) {
      return blockingUnaryCall(
          getChannel(), getAddConfigMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.configserver.protoController.Protofile.ResponseConfig getConfig(com.example.configserver.protoController.Protofile.NameConfig request) {
      return blockingUnaryCall(
          getChannel(), getGetConfigMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.configserver.protoController.Protofile.ResponseConfig updateConfig(com.example.configserver.protoController.Protofile.Config request) {
      return blockingUnaryCall(
          getChannel(), getUpdateConfigMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.configserver.protoController.Protofile.ResponseConfig deleteConfig(com.example.configserver.protoController.Protofile.NameAndVersion request) {
      return blockingUnaryCall(
          getChannel(), getDeleteConfigMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.configserver.protoController.Protofile.ArrayConfig getAllConfig(com.google.protobuf.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetAllConfigMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.configserver.protoController.Protofile.ResponseConfig getVersionConfig(com.example.configserver.protoController.Protofile.NameAndVersion request) {
      return blockingUnaryCall(
          getChannel(), getGetVersionConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ConfigServiceFutureStub extends io.grpc.stub.AbstractStub<ConfigServiceFutureStub> {
    private ConfigServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ConfigServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ConfigServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ConfigServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.configserver.protoController.Protofile.ResponseConfig> addConfig(
        com.example.configserver.protoController.Protofile.Config request) {
      return futureUnaryCall(
          getChannel().newCall(getAddConfigMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.configserver.protoController.Protofile.ResponseConfig> getConfig(
        com.example.configserver.protoController.Protofile.NameConfig request) {
      return futureUnaryCall(
          getChannel().newCall(getGetConfigMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.configserver.protoController.Protofile.ResponseConfig> updateConfig(
        com.example.configserver.protoController.Protofile.Config request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateConfigMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.configserver.protoController.Protofile.ResponseConfig> deleteConfig(
        com.example.configserver.protoController.Protofile.NameAndVersion request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteConfigMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.configserver.protoController.Protofile.ArrayConfig> getAllConfig(
        com.google.protobuf.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetAllConfigMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.configserver.protoController.Protofile.ResponseConfig> getVersionConfig(
        com.example.configserver.protoController.Protofile.NameAndVersion request) {
      return futureUnaryCall(
          getChannel().newCall(getGetVersionConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_CONFIG = 0;
  private static final int METHODID_GET_CONFIG = 1;
  private static final int METHODID_UPDATE_CONFIG = 2;
  private static final int METHODID_DELETE_CONFIG = 3;
  private static final int METHODID_GET_ALL_CONFIG = 4;
  private static final int METHODID_GET_VERSION_CONFIG = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ConfigServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ConfigServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_CONFIG:
          serviceImpl.addConfig((com.example.configserver.protoController.Protofile.Config) request,
              (io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseConfig>) responseObserver);
          break;
        case METHODID_GET_CONFIG:
          serviceImpl.getConfig((com.example.configserver.protoController.Protofile.NameConfig) request,
              (io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseConfig>) responseObserver);
          break;
        case METHODID_UPDATE_CONFIG:
          serviceImpl.updateConfig((com.example.configserver.protoController.Protofile.Config) request,
              (io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseConfig>) responseObserver);
          break;
        case METHODID_DELETE_CONFIG:
          serviceImpl.deleteConfig((com.example.configserver.protoController.Protofile.NameAndVersion) request,
              (io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseConfig>) responseObserver);
          break;
        case METHODID_GET_ALL_CONFIG:
          serviceImpl.getAllConfig((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ArrayConfig>) responseObserver);
          break;
        case METHODID_GET_VERSION_CONFIG:
          serviceImpl.getVersionConfig((com.example.configserver.protoController.Protofile.NameAndVersion) request,
              (io.grpc.stub.StreamObserver<com.example.configserver.protoController.Protofile.ResponseConfig>) responseObserver);
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

  private static abstract class ConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ConfigServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.configserver.protoController.Protofile.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ConfigService");
    }
  }

  private static final class ConfigServiceFileDescriptorSupplier
      extends ConfigServiceBaseDescriptorSupplier {
    ConfigServiceFileDescriptorSupplier() {}
  }

  private static final class ConfigServiceMethodDescriptorSupplier
      extends ConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ConfigServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ConfigServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ConfigServiceFileDescriptorSupplier())
              .addMethod(getAddConfigMethod())
              .addMethod(getGetConfigMethod())
              .addMethod(getUpdateConfigMethod())
              .addMethod(getDeleteConfigMethod())
              .addMethod(getGetAllConfigMethod())
              .addMethod(getGetVersionConfigMethod())
              .build();
        }
      }
    }
    return result;
  }
}
