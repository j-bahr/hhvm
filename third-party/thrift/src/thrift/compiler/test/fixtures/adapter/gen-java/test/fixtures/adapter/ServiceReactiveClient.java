/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */

package test.fixtures.adapter;

import static com.facebook.swift.service.SwiftConstants.STICKY_HASH_KEY;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.thrift.protocol.*;
import org.apache.thrift.ClientPushMetadata;
import org.apache.thrift.InteractionCreate;
import org.apache.thrift.InteractionTerminate;
import com.facebook.thrift.client.ResponseWrapper;
import com.facebook.thrift.client.RpcOptions;
import com.facebook.thrift.util.Readers;

public class ServiceReactiveClient 
  implements Service.Reactive {
  private static final AtomicLong _interactionCounter = new AtomicLong(0);

  protected final org.apache.thrift.ProtocolId _protocolId;
  protected final reactor.core.publisher.Mono<? extends com.facebook.thrift.client.RpcClient> _rpcClient;
  protected final reactor.core.publisher.Mono<Map<String, String>> _headersMono;
  protected final reactor.core.publisher.Mono<Map<String, String>> _persistentHeadersMono;
  protected final Set<Long> _activeInteractions;

  private static final TField _func_ARG1_FIELD_DESC = new TField("arg1", TType.STRING, (short)1);
  private static final TField _func_ARG2_FIELD_DESC = new TField("arg2", TType.STRING, (short)2);
  private static final TField _func_ARG3_FIELD_DESC = new TField("arg3", TType.STRUCT, (short)3);
  private static final java.util.Map<Short, com.facebook.thrift.payload.Reader> _func_EXCEPTION_READERS = java.util.Collections.emptyMap();

  static {
  }

  public ServiceReactiveClient(org.apache.thrift.ProtocolId _protocolId, reactor.core.publisher.Mono<? extends com.facebook.thrift.client.RpcClient> _rpcClient) {
    
    this._protocolId = _protocolId;
    this._rpcClient = _rpcClient;
    this._headersMono = reactor.core.publisher.Mono.empty();
    this._persistentHeadersMono = reactor.core.publisher.Mono.empty();
    this._activeInteractions = ConcurrentHashMap.newKeySet();
  }

  public ServiceReactiveClient(org.apache.thrift.ProtocolId _protocolId, reactor.core.publisher.Mono<? extends com.facebook.thrift.client.RpcClient> _rpcClient, Map<String, String> _headers, Map<String, String> _persistentHeaders) {
    this(_protocolId, _rpcClient, reactor.core.publisher.Mono.just(_headers != null ? _headers : java.util.Collections.emptyMap()), reactor.core.publisher.Mono.just(_persistentHeaders != null ? _persistentHeaders : java.util.Collections.emptyMap()), new AtomicLong(), ConcurrentHashMap.newKeySet());
  }

  public ServiceReactiveClient(org.apache.thrift.ProtocolId _protocolId, reactor.core.publisher.Mono<? extends com.facebook.thrift.client.RpcClient> _rpcClient, reactor.core.publisher.Mono<Map<String, String>> _headersMono, reactor.core.publisher.Mono<Map<String, String>> _persistentHeadersMono) {
    this(_protocolId, _rpcClient, _headersMono, _persistentHeadersMono, new AtomicLong(), ConcurrentHashMap.newKeySet());
  }

  public ServiceReactiveClient(org.apache.thrift.ProtocolId _protocolId, reactor.core.publisher.Mono<? extends com.facebook.thrift.client.RpcClient> _rpcClient, Map<String, String> _headers, Map<String, String> _persistentHeaders, AtomicLong interactionCounter, Set<Long> activeInteractions) {
    this(_protocolId,_rpcClient, reactor.core.publisher.Mono.just(_headers != null ? _headers : java.util.Collections.emptyMap()), reactor.core.publisher.Mono.just(_persistentHeaders != null ? _persistentHeaders : java.util.Collections.emptyMap()), interactionCounter, activeInteractions);
  }

  public ServiceReactiveClient(org.apache.thrift.ProtocolId _protocolId, reactor.core.publisher.Mono<? extends com.facebook.thrift.client.RpcClient> _rpcClient, reactor.core.publisher.Mono<Map<String, String>> _headersMono, reactor.core.publisher.Mono<Map<String, String>> _persistentHeadersMono, AtomicLong interactionCounter, Set<Long> activeInteractions) {
    
    this._protocolId = _protocolId;
    this._rpcClient = _rpcClient;
    this._headersMono = _headersMono;
    this._persistentHeadersMono = _persistentHeadersMono;
    this._activeInteractions = activeInteractions;
  }

  @java.lang.Override
  public void dispose() {}

  private com.facebook.thrift.payload.Writer _createfuncWriter(final String arg1, final String arg2, final test.fixtures.adapter.Foo arg3) {
    return oprot -> {
      try {
        {
          oprot.writeFieldBegin(_func_ARG1_FIELD_DESC);

          String _iter0 = arg1;

          oprot.writeString(arg1);
          oprot.writeFieldEnd();
        }

        {
          oprot.writeFieldBegin(_func_ARG2_FIELD_DESC);

          String _iter0 = arg2;

          oprot.writeString(arg2);
          oprot.writeFieldEnd();
        }

        {
          oprot.writeFieldBegin(_func_ARG3_FIELD_DESC);

          test.fixtures.adapter.Foo _iter0 = arg3;

          _iter0.write0(oprot);
          oprot.writeFieldEnd();
        }


      } catch (Throwable _e) {
        com.facebook.thrift.util.NettyUtil.releaseIfByteBufTProtocol(oprot);
        throw reactor.core.Exceptions.propagate(_e);
      }
    };
  }

  private static final com.facebook.thrift.payload.Reader _func_READER = Readers.i32Reader();

  @java.lang.Override
  public reactor.core.publisher.Mono<com.facebook.thrift.client.ResponseWrapper<Integer>> funcWrapper(final String arg1, final String arg2, final test.fixtures.adapter.Foo arg3,  final com.facebook.thrift.client.RpcOptions rpcOptions) {
    return _rpcClient
      .flatMap(_rpc -> getHeaders(rpcOptions).flatMap(headers -> {
        org.apache.thrift.RequestRpcMetadata _metadata = new org.apache.thrift.RequestRpcMetadata.Builder()
                .setName("func")
                .setKind(org.apache.thrift.RpcKind.SINGLE_REQUEST_SINGLE_RESPONSE)
                .setOtherMetadata(headers)
                .setProtocol(_protocolId)
                .build();

            com.facebook.thrift.payload.ClientRequestPayload<Integer> _crp =
                com.facebook.thrift.payload.ClientRequestPayload.create(
                    "Service",
                    _createfuncWriter(arg1, arg2, arg3),
                    _func_READER,
                    _func_EXCEPTION_READERS,
                    _metadata,
                    java.util.Collections.emptyMap());

            return _rpc
                .singleRequestSingleResponse(_crp, rpcOptions).transform(com.facebook.thrift.util.MonoPublishingTransformer.getInstance()).doOnNext(_p -> {if(_p.getException() != null) throw com.facebook.thrift.util.ExceptionUtil.propagate(_p);});
      }));
  }

  @java.lang.Override
  public reactor.core.publisher.Mono<Integer> func(final String arg1, final String arg2, final test.fixtures.adapter.Foo arg3,  final com.facebook.thrift.client.RpcOptions rpcOptions) {
    return funcWrapper(arg1, arg2, arg3,  rpcOptions).map(_p -> _p.getData());
  }

  @java.lang.Override
  public reactor.core.publisher.Mono<Integer> func(final String arg1, final String arg2, final test.fixtures.adapter.Foo arg3) {
    return func(arg1, arg2, arg3,  com.facebook.thrift.client.RpcOptions.EMPTY);
  }



  private reactor.core.publisher.Mono<Map<String, String>> getHeaders(com.facebook.thrift.client.RpcOptions rpcOptions) {
      Map<String, String> requestHeaders = new HashMap<>();
      if (rpcOptions.getRequestHeaders() != null && !rpcOptions.getRequestHeaders().isEmpty()) {
          requestHeaders.putAll(rpcOptions.getRequestHeaders());
      }

      return _headersMono.defaultIfEmpty(java.util.Collections.emptyMap()).zipWith(_persistentHeadersMono.defaultIfEmpty(java.util.Collections.emptyMap()), (headers, persistentHeaders) -> {
          Map<String, String> result = new HashMap<>();
          result.putAll(requestHeaders);
          result.putAll(headers);
          result.putAll(persistentHeaders);
          return result;
      });
  }
}
