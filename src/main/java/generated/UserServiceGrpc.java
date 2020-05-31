package generated;

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
    value = "by gRPC proto compiler (version 1.29.0)",
    comments = "Source: user.proto")
public final class UserServiceGrpc {

  private UserServiceGrpc() {}

  public static final String SERVICE_NAME = "generated.UserService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.User.ReverseRequest,
      generated.User.APIResponse> getReverseMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "reverse",
      requestType = generated.User.ReverseRequest.class,
      responseType = generated.User.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.User.ReverseRequest,
      generated.User.APIResponse> getReverseMethod() {
    io.grpc.MethodDescriptor<generated.User.ReverseRequest, generated.User.APIResponse> getReverseMethod;
    if ((getReverseMethod = UserServiceGrpc.getReverseMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getReverseMethod = UserServiceGrpc.getReverseMethod) == null) {
          UserServiceGrpc.getReverseMethod = getReverseMethod =
              io.grpc.MethodDescriptor.<generated.User.ReverseRequest, generated.User.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "reverse"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.ReverseRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.APIResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("reverse"))
              .build();
        }
      }
    }
    return getReverseMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.User.RegistrationRequest,
      generated.User.APIResponse> getRegistrationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "registration",
      requestType = generated.User.RegistrationRequest.class,
      responseType = generated.User.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.User.RegistrationRequest,
      generated.User.APIResponse> getRegistrationMethod() {
    io.grpc.MethodDescriptor<generated.User.RegistrationRequest, generated.User.APIResponse> getRegistrationMethod;
    if ((getRegistrationMethod = UserServiceGrpc.getRegistrationMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getRegistrationMethod = UserServiceGrpc.getRegistrationMethod) == null) {
          UserServiceGrpc.getRegistrationMethod = getRegistrationMethod =
              io.grpc.MethodDescriptor.<generated.User.RegistrationRequest, generated.User.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "registration"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.RegistrationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.APIResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("registration"))
              .build();
        }
      }
    }
    return getRegistrationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.User.LoginRequest,
      generated.User.LoginResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = generated.User.LoginRequest.class,
      responseType = generated.User.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.User.LoginRequest,
      generated.User.LoginResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<generated.User.LoginRequest, generated.User.LoginResponse> getLoginMethod;
    if ((getLoginMethod = UserServiceGrpc.getLoginMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getLoginMethod = UserServiceGrpc.getLoginMethod) == null) {
          UserServiceGrpc.getLoginMethod = getLoginMethod =
              io.grpc.MethodDescriptor.<generated.User.LoginRequest, generated.User.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.LoginResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("login"))
              .build();
        }
      }
    }
    return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.User.LogoutRequest,
      generated.User.APIResponse> getLogoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "logout",
      requestType = generated.User.LogoutRequest.class,
      responseType = generated.User.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.User.LogoutRequest,
      generated.User.APIResponse> getLogoutMethod() {
    io.grpc.MethodDescriptor<generated.User.LogoutRequest, generated.User.APIResponse> getLogoutMethod;
    if ((getLogoutMethod = UserServiceGrpc.getLogoutMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getLogoutMethod = UserServiceGrpc.getLogoutMethod) == null) {
          UserServiceGrpc.getLogoutMethod = getLogoutMethod =
              io.grpc.MethodDescriptor.<generated.User.LogoutRequest, generated.User.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "logout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.LogoutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.APIResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("logout"))
              .build();
        }
      }
    }
    return getLogoutMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.User.GetNoteListRequest,
      generated.User.GetNoteListResponse> getGetNoteListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getNoteList",
      requestType = generated.User.GetNoteListRequest.class,
      responseType = generated.User.GetNoteListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.User.GetNoteListRequest,
      generated.User.GetNoteListResponse> getGetNoteListMethod() {
    io.grpc.MethodDescriptor<generated.User.GetNoteListRequest, generated.User.GetNoteListResponse> getGetNoteListMethod;
    if ((getGetNoteListMethod = UserServiceGrpc.getGetNoteListMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetNoteListMethod = UserServiceGrpc.getGetNoteListMethod) == null) {
          UserServiceGrpc.getGetNoteListMethod = getGetNoteListMethod =
              io.grpc.MethodDescriptor.<generated.User.GetNoteListRequest, generated.User.GetNoteListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getNoteList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.GetNoteListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.GetNoteListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("getNoteList"))
              .build();
        }
      }
    }
    return getGetNoteListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.User.CreateNoteRequest,
      generated.User.APIResponse> getCreateNoteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createNote",
      requestType = generated.User.CreateNoteRequest.class,
      responseType = generated.User.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.User.CreateNoteRequest,
      generated.User.APIResponse> getCreateNoteMethod() {
    io.grpc.MethodDescriptor<generated.User.CreateNoteRequest, generated.User.APIResponse> getCreateNoteMethod;
    if ((getCreateNoteMethod = UserServiceGrpc.getCreateNoteMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getCreateNoteMethod = UserServiceGrpc.getCreateNoteMethod) == null) {
          UserServiceGrpc.getCreateNoteMethod = getCreateNoteMethod =
              io.grpc.MethodDescriptor.<generated.User.CreateNoteRequest, generated.User.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createNote"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.CreateNoteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.APIResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("createNote"))
              .build();
        }
      }
    }
    return getCreateNoteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.User.SetLikeRequest,
      generated.User.APIResponse> getSetLikeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "setLike",
      requestType = generated.User.SetLikeRequest.class,
      responseType = generated.User.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.User.SetLikeRequest,
      generated.User.APIResponse> getSetLikeMethod() {
    io.grpc.MethodDescriptor<generated.User.SetLikeRequest, generated.User.APIResponse> getSetLikeMethod;
    if ((getSetLikeMethod = UserServiceGrpc.getSetLikeMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getSetLikeMethod = UserServiceGrpc.getSetLikeMethod) == null) {
          UserServiceGrpc.getSetLikeMethod = getSetLikeMethod =
              io.grpc.MethodDescriptor.<generated.User.SetLikeRequest, generated.User.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "setLike"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.SetLikeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.APIResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("setLike"))
              .build();
        }
      }
    }
    return getSetLikeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.User.CreateCommentRequest,
      generated.User.APIResponse> getCreateCommentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createComment",
      requestType = generated.User.CreateCommentRequest.class,
      responseType = generated.User.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.User.CreateCommentRequest,
      generated.User.APIResponse> getCreateCommentMethod() {
    io.grpc.MethodDescriptor<generated.User.CreateCommentRequest, generated.User.APIResponse> getCreateCommentMethod;
    if ((getCreateCommentMethod = UserServiceGrpc.getCreateCommentMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getCreateCommentMethod = UserServiceGrpc.getCreateCommentMethod) == null) {
          UserServiceGrpc.getCreateCommentMethod = getCreateCommentMethod =
              io.grpc.MethodDescriptor.<generated.User.CreateCommentRequest, generated.User.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createComment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.CreateCommentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.APIResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("createComment"))
              .build();
        }
      }
    }
    return getCreateCommentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.User.GetCommentListRequest,
      generated.User.GetCommentListResponse> getGetCommentListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCommentList",
      requestType = generated.User.GetCommentListRequest.class,
      responseType = generated.User.GetCommentListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.User.GetCommentListRequest,
      generated.User.GetCommentListResponse> getGetCommentListMethod() {
    io.grpc.MethodDescriptor<generated.User.GetCommentListRequest, generated.User.GetCommentListResponse> getGetCommentListMethod;
    if ((getGetCommentListMethod = UserServiceGrpc.getGetCommentListMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetCommentListMethod = UserServiceGrpc.getGetCommentListMethod) == null) {
          UserServiceGrpc.getGetCommentListMethod = getGetCommentListMethod =
              io.grpc.MethodDescriptor.<generated.User.GetCommentListRequest, generated.User.GetCommentListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCommentList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.GetCommentListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.GetCommentListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("getCommentList"))
              .build();
        }
      }
    }
    return getGetCommentListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.User.SendMessageRequest,
      generated.User.APIResponse> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sendMessage",
      requestType = generated.User.SendMessageRequest.class,
      responseType = generated.User.APIResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.User.SendMessageRequest,
      generated.User.APIResponse> getSendMessageMethod() {
    io.grpc.MethodDescriptor<generated.User.SendMessageRequest, generated.User.APIResponse> getSendMessageMethod;
    if ((getSendMessageMethod = UserServiceGrpc.getSendMessageMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getSendMessageMethod = UserServiceGrpc.getSendMessageMethod) == null) {
          UserServiceGrpc.getSendMessageMethod = getSendMessageMethod =
              io.grpc.MethodDescriptor.<generated.User.SendMessageRequest, generated.User.APIResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.SendMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.APIResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("sendMessage"))
              .build();
        }
      }
    }
    return getSendMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.User.EmptyRequest,
      generated.User.GetUserListResponse> getGetUserListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUserList",
      requestType = generated.User.EmptyRequest.class,
      responseType = generated.User.GetUserListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.User.EmptyRequest,
      generated.User.GetUserListResponse> getGetUserListMethod() {
    io.grpc.MethodDescriptor<generated.User.EmptyRequest, generated.User.GetUserListResponse> getGetUserListMethod;
    if ((getGetUserListMethod = UserServiceGrpc.getGetUserListMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetUserListMethod = UserServiceGrpc.getGetUserListMethod) == null) {
          UserServiceGrpc.getGetUserListMethod = getGetUserListMethod =
              io.grpc.MethodDescriptor.<generated.User.EmptyRequest, generated.User.GetUserListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getUserList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.EmptyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.GetUserListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("getUserList"))
              .build();
        }
      }
    }
    return getGetUserListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.User.GetCorrespListRequest,
      generated.User.GetCorrespListResponse> getGetCorrespListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCorrespList",
      requestType = generated.User.GetCorrespListRequest.class,
      responseType = generated.User.GetCorrespListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.User.GetCorrespListRequest,
      generated.User.GetCorrespListResponse> getGetCorrespListMethod() {
    io.grpc.MethodDescriptor<generated.User.GetCorrespListRequest, generated.User.GetCorrespListResponse> getGetCorrespListMethod;
    if ((getGetCorrespListMethod = UserServiceGrpc.getGetCorrespListMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetCorrespListMethod = UserServiceGrpc.getGetCorrespListMethod) == null) {
          UserServiceGrpc.getGetCorrespListMethod = getGetCorrespListMethod =
              io.grpc.MethodDescriptor.<generated.User.GetCorrespListRequest, generated.User.GetCorrespListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCorrespList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.GetCorrespListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.GetCorrespListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("getCorrespList"))
              .build();
        }
      }
    }
    return getGetCorrespListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.User.GetMessageListRequest,
      generated.User.GetMessageListResponse> getGetMessageListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getMessageList",
      requestType = generated.User.GetMessageListRequest.class,
      responseType = generated.User.GetMessageListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.User.GetMessageListRequest,
      generated.User.GetMessageListResponse> getGetMessageListMethod() {
    io.grpc.MethodDescriptor<generated.User.GetMessageListRequest, generated.User.GetMessageListResponse> getGetMessageListMethod;
    if ((getGetMessageListMethod = UserServiceGrpc.getGetMessageListMethod) == null) {
      synchronized (UserServiceGrpc.class) {
        if ((getGetMessageListMethod = UserServiceGrpc.getGetMessageListMethod) == null) {
          UserServiceGrpc.getGetMessageListMethod = getGetMessageListMethod =
              io.grpc.MethodDescriptor.<generated.User.GetMessageListRequest, generated.User.GetMessageListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getMessageList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.GetMessageListRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.User.GetMessageListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserServiceMethodDescriptorSupplier("getMessageList"))
              .build();
        }
      }
    }
    return getGetMessageListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceStub>() {
        @java.lang.Override
        public UserServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceStub(channel, callOptions);
        }
      };
    return UserServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceBlockingStub>() {
        @java.lang.Override
        public UserServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceBlockingStub(channel, callOptions);
        }
      };
    return UserServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserServiceFutureStub>() {
        @java.lang.Override
        public UserServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserServiceFutureStub(channel, callOptions);
        }
      };
    return UserServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class UserServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * получение реверсированной строки
     * </pre>
     */
    public void reverse(generated.User.ReverseRequest request,
        io.grpc.stub.StreamObserver<generated.User.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReverseMethod(), responseObserver);
    }

    /**
     * <pre>
     * регистрация
     * </pre>
     */
    public void registration(generated.User.RegistrationRequest request,
        io.grpc.stub.StreamObserver<generated.User.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getRegistrationMethod(), responseObserver);
    }

    /**
     * <pre>
     * авторизация
     * </pre>
     */
    public void login(generated.User.LoginRequest request,
        io.grpc.stub.StreamObserver<generated.User.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     * <pre>
     * выход
     * </pre>
     */
    public void logout(generated.User.LogoutRequest request,
        io.grpc.stub.StreamObserver<generated.User.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }

    /**
     * <pre>
     * получить список постов
     * </pre>
     */
    public void getNoteList(generated.User.GetNoteListRequest request,
        io.grpc.stub.StreamObserver<generated.User.GetNoteListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetNoteListMethod(), responseObserver);
    }

    /**
     * <pre>
     * создать пост
     * </pre>
     */
    public void createNote(generated.User.CreateNoteRequest request,
        io.grpc.stub.StreamObserver<generated.User.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateNoteMethod(), responseObserver);
    }

    /**
     * <pre>
     * убрать/поставить лайк
     * </pre>
     */
    public void setLike(generated.User.SetLikeRequest request,
        io.grpc.stub.StreamObserver<generated.User.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSetLikeMethod(), responseObserver);
    }

    /**
     * <pre>
     * создать комментарий
     * </pre>
     */
    public void createComment(generated.User.CreateCommentRequest request,
        io.grpc.stub.StreamObserver<generated.User.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateCommentMethod(), responseObserver);
    }

    /**
     * <pre>
     * получить список комментариев
     * </pre>
     */
    public void getCommentList(generated.User.GetCommentListRequest request,
        io.grpc.stub.StreamObserver<generated.User.GetCommentListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCommentListMethod(), responseObserver);
    }

    /**
     * <pre>
     * отправить сообщение
     * </pre>
     */
    public void sendMessage(generated.User.SendMessageRequest request,
        io.grpc.stub.StreamObserver<generated.User.APIResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSendMessageMethod(), responseObserver);
    }

    /**
     * <pre>
     * получить список пользователей
     * </pre>
     */
    public void getUserList(generated.User.EmptyRequest request,
        io.grpc.stub.StreamObserver<generated.User.GetUserListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUserListMethod(), responseObserver);
    }

    /**
     * <pre>
     * получить список переписок
     * </pre>
     */
    public void getCorrespList(generated.User.GetCorrespListRequest request,
        io.grpc.stub.StreamObserver<generated.User.GetCorrespListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCorrespListMethod(), responseObserver);
    }

    /**
     * <pre>
     * получить список сообщений
     * </pre>
     */
    public void getMessageList(generated.User.GetMessageListRequest request,
        io.grpc.stub.StreamObserver<generated.User.GetMessageListResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetMessageListMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getReverseMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.User.ReverseRequest,
                generated.User.APIResponse>(
                  this, METHODID_REVERSE)))
          .addMethod(
            getRegistrationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.User.RegistrationRequest,
                generated.User.APIResponse>(
                  this, METHODID_REGISTRATION)))
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.User.LoginRequest,
                generated.User.LoginResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getLogoutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.User.LogoutRequest,
                generated.User.APIResponse>(
                  this, METHODID_LOGOUT)))
          .addMethod(
            getGetNoteListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.User.GetNoteListRequest,
                generated.User.GetNoteListResponse>(
                  this, METHODID_GET_NOTE_LIST)))
          .addMethod(
            getCreateNoteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.User.CreateNoteRequest,
                generated.User.APIResponse>(
                  this, METHODID_CREATE_NOTE)))
          .addMethod(
            getSetLikeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.User.SetLikeRequest,
                generated.User.APIResponse>(
                  this, METHODID_SET_LIKE)))
          .addMethod(
            getCreateCommentMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.User.CreateCommentRequest,
                generated.User.APIResponse>(
                  this, METHODID_CREATE_COMMENT)))
          .addMethod(
            getGetCommentListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.User.GetCommentListRequest,
                generated.User.GetCommentListResponse>(
                  this, METHODID_GET_COMMENT_LIST)))
          .addMethod(
            getSendMessageMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.User.SendMessageRequest,
                generated.User.APIResponse>(
                  this, METHODID_SEND_MESSAGE)))
          .addMethod(
            getGetUserListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.User.EmptyRequest,
                generated.User.GetUserListResponse>(
                  this, METHODID_GET_USER_LIST)))
          .addMethod(
            getGetCorrespListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.User.GetCorrespListRequest,
                generated.User.GetCorrespListResponse>(
                  this, METHODID_GET_CORRESP_LIST)))
          .addMethod(
            getGetMessageListMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.User.GetMessageListRequest,
                generated.User.GetMessageListResponse>(
                  this, METHODID_GET_MESSAGE_LIST)))
          .build();
    }
  }

  /**
   */
  public static final class UserServiceStub extends io.grpc.stub.AbstractAsyncStub<UserServiceStub> {
    private UserServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * получение реверсированной строки
     * </pre>
     */
    public void reverse(generated.User.ReverseRequest request,
        io.grpc.stub.StreamObserver<generated.User.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReverseMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * регистрация
     * </pre>
     */
    public void registration(generated.User.RegistrationRequest request,
        io.grpc.stub.StreamObserver<generated.User.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getRegistrationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * авторизация
     * </pre>
     */
    public void login(generated.User.LoginRequest request,
        io.grpc.stub.StreamObserver<generated.User.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * выход
     * </pre>
     */
    public void logout(generated.User.LogoutRequest request,
        io.grpc.stub.StreamObserver<generated.User.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * получить список постов
     * </pre>
     */
    public void getNoteList(generated.User.GetNoteListRequest request,
        io.grpc.stub.StreamObserver<generated.User.GetNoteListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetNoteListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * создать пост
     * </pre>
     */
    public void createNote(generated.User.CreateNoteRequest request,
        io.grpc.stub.StreamObserver<generated.User.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateNoteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * убрать/поставить лайк
     * </pre>
     */
    public void setLike(generated.User.SetLikeRequest request,
        io.grpc.stub.StreamObserver<generated.User.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSetLikeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * создать комментарий
     * </pre>
     */
    public void createComment(generated.User.CreateCommentRequest request,
        io.grpc.stub.StreamObserver<generated.User.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateCommentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * получить список комментариев
     * </pre>
     */
    public void getCommentList(generated.User.GetCommentListRequest request,
        io.grpc.stub.StreamObserver<generated.User.GetCommentListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCommentListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * отправить сообщение
     * </pre>
     */
    public void sendMessage(generated.User.SendMessageRequest request,
        io.grpc.stub.StreamObserver<generated.User.APIResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * получить список пользователей
     * </pre>
     */
    public void getUserList(generated.User.EmptyRequest request,
        io.grpc.stub.StreamObserver<generated.User.GetUserListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUserListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * получить список переписок
     * </pre>
     */
    public void getCorrespList(generated.User.GetCorrespListRequest request,
        io.grpc.stub.StreamObserver<generated.User.GetCorrespListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCorrespListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * получить список сообщений
     * </pre>
     */
    public void getMessageList(generated.User.GetMessageListRequest request,
        io.grpc.stub.StreamObserver<generated.User.GetMessageListResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetMessageListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<UserServiceBlockingStub> {
    private UserServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * получение реверсированной строки
     * </pre>
     */
    public generated.User.APIResponse reverse(generated.User.ReverseRequest request) {
      return blockingUnaryCall(
          getChannel(), getReverseMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * регистрация
     * </pre>
     */
    public generated.User.APIResponse registration(generated.User.RegistrationRequest request) {
      return blockingUnaryCall(
          getChannel(), getRegistrationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * авторизация
     * </pre>
     */
    public generated.User.LoginResponse login(generated.User.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * выход
     * </pre>
     */
    public generated.User.APIResponse logout(generated.User.LogoutRequest request) {
      return blockingUnaryCall(
          getChannel(), getLogoutMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * получить список постов
     * </pre>
     */
    public generated.User.GetNoteListResponse getNoteList(generated.User.GetNoteListRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetNoteListMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * создать пост
     * </pre>
     */
    public generated.User.APIResponse createNote(generated.User.CreateNoteRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateNoteMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * убрать/поставить лайк
     * </pre>
     */
    public generated.User.APIResponse setLike(generated.User.SetLikeRequest request) {
      return blockingUnaryCall(
          getChannel(), getSetLikeMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * создать комментарий
     * </pre>
     */
    public generated.User.APIResponse createComment(generated.User.CreateCommentRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateCommentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * получить список комментариев
     * </pre>
     */
    public generated.User.GetCommentListResponse getCommentList(generated.User.GetCommentListRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCommentListMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * отправить сообщение
     * </pre>
     */
    public generated.User.APIResponse sendMessage(generated.User.SendMessageRequest request) {
      return blockingUnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * получить список пользователей
     * </pre>
     */
    public generated.User.GetUserListResponse getUserList(generated.User.EmptyRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetUserListMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * получить список переписок
     * </pre>
     */
    public generated.User.GetCorrespListResponse getCorrespList(generated.User.GetCorrespListRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetCorrespListMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * получить список сообщений
     * </pre>
     */
    public generated.User.GetMessageListResponse getMessageList(generated.User.GetMessageListRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetMessageListMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserServiceFutureStub extends io.grpc.stub.AbstractFutureStub<UserServiceFutureStub> {
    private UserServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * получение реверсированной строки
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.User.APIResponse> reverse(
        generated.User.ReverseRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReverseMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * регистрация
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.User.APIResponse> registration(
        generated.User.RegistrationRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getRegistrationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * авторизация
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.User.LoginResponse> login(
        generated.User.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * выход
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.User.APIResponse> logout(
        generated.User.LogoutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * получить список постов
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.User.GetNoteListResponse> getNoteList(
        generated.User.GetNoteListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetNoteListMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * создать пост
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.User.APIResponse> createNote(
        generated.User.CreateNoteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateNoteMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * убрать/поставить лайк
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.User.APIResponse> setLike(
        generated.User.SetLikeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSetLikeMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * создать комментарий
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.User.APIResponse> createComment(
        generated.User.CreateCommentRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateCommentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * получить список комментариев
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.User.GetCommentListResponse> getCommentList(
        generated.User.GetCommentListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCommentListMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * отправить сообщение
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.User.APIResponse> sendMessage(
        generated.User.SendMessageRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * получить список пользователей
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.User.GetUserListResponse> getUserList(
        generated.User.EmptyRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUserListMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * получить список переписок
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.User.GetCorrespListResponse> getCorrespList(
        generated.User.GetCorrespListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCorrespListMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * получить список сообщений
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.User.GetMessageListResponse> getMessageList(
        generated.User.GetMessageListRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetMessageListMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_REVERSE = 0;
  private static final int METHODID_REGISTRATION = 1;
  private static final int METHODID_LOGIN = 2;
  private static final int METHODID_LOGOUT = 3;
  private static final int METHODID_GET_NOTE_LIST = 4;
  private static final int METHODID_CREATE_NOTE = 5;
  private static final int METHODID_SET_LIKE = 6;
  private static final int METHODID_CREATE_COMMENT = 7;
  private static final int METHODID_GET_COMMENT_LIST = 8;
  private static final int METHODID_SEND_MESSAGE = 9;
  private static final int METHODID_GET_USER_LIST = 10;
  private static final int METHODID_GET_CORRESP_LIST = 11;
  private static final int METHODID_GET_MESSAGE_LIST = 12;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REVERSE:
          serviceImpl.reverse((generated.User.ReverseRequest) request,
              (io.grpc.stub.StreamObserver<generated.User.APIResponse>) responseObserver);
          break;
        case METHODID_REGISTRATION:
          serviceImpl.registration((generated.User.RegistrationRequest) request,
              (io.grpc.stub.StreamObserver<generated.User.APIResponse>) responseObserver);
          break;
        case METHODID_LOGIN:
          serviceImpl.login((generated.User.LoginRequest) request,
              (io.grpc.stub.StreamObserver<generated.User.LoginResponse>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((generated.User.LogoutRequest) request,
              (io.grpc.stub.StreamObserver<generated.User.APIResponse>) responseObserver);
          break;
        case METHODID_GET_NOTE_LIST:
          serviceImpl.getNoteList((generated.User.GetNoteListRequest) request,
              (io.grpc.stub.StreamObserver<generated.User.GetNoteListResponse>) responseObserver);
          break;
        case METHODID_CREATE_NOTE:
          serviceImpl.createNote((generated.User.CreateNoteRequest) request,
              (io.grpc.stub.StreamObserver<generated.User.APIResponse>) responseObserver);
          break;
        case METHODID_SET_LIKE:
          serviceImpl.setLike((generated.User.SetLikeRequest) request,
              (io.grpc.stub.StreamObserver<generated.User.APIResponse>) responseObserver);
          break;
        case METHODID_CREATE_COMMENT:
          serviceImpl.createComment((generated.User.CreateCommentRequest) request,
              (io.grpc.stub.StreamObserver<generated.User.APIResponse>) responseObserver);
          break;
        case METHODID_GET_COMMENT_LIST:
          serviceImpl.getCommentList((generated.User.GetCommentListRequest) request,
              (io.grpc.stub.StreamObserver<generated.User.GetCommentListResponse>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((generated.User.SendMessageRequest) request,
              (io.grpc.stub.StreamObserver<generated.User.APIResponse>) responseObserver);
          break;
        case METHODID_GET_USER_LIST:
          serviceImpl.getUserList((generated.User.EmptyRequest) request,
              (io.grpc.stub.StreamObserver<generated.User.GetUserListResponse>) responseObserver);
          break;
        case METHODID_GET_CORRESP_LIST:
          serviceImpl.getCorrespList((generated.User.GetCorrespListRequest) request,
              (io.grpc.stub.StreamObserver<generated.User.GetCorrespListResponse>) responseObserver);
          break;
        case METHODID_GET_MESSAGE_LIST:
          serviceImpl.getMessageList((generated.User.GetMessageListRequest) request,
              (io.grpc.stub.StreamObserver<generated.User.GetMessageListResponse>) responseObserver);
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

  private static abstract class UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.User.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserService");
    }
  }

  private static final class UserServiceFileDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier {
    UserServiceFileDescriptorSupplier() {}
  }

  private static final class UserServiceMethodDescriptorSupplier
      extends UserServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserServiceFileDescriptorSupplier())
              .addMethod(getReverseMethod())
              .addMethod(getRegistrationMethod())
              .addMethod(getLoginMethod())
              .addMethod(getLogoutMethod())
              .addMethod(getGetNoteListMethod())
              .addMethod(getCreateNoteMethod())
              .addMethod(getSetLikeMethod())
              .addMethod(getCreateCommentMethod())
              .addMethod(getGetCommentListMethod())
              .addMethod(getSendMessageMethod())
              .addMethod(getGetUserListMethod())
              .addMethod(getGetCorrespListMethod())
              .addMethod(getGetMessageListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
