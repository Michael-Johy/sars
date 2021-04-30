package com.johnny.netty.person.client.dispatch;

import com.johnny.netty.common.MessageBody;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RequestPendingCenter {

    private final Map<Long, ResponseFuture> map = new ConcurrentHashMap<>();

    public void add(long messageId, ResponseFuture future) {
        map.put(messageId, future);
    }

    public void setResult(long messageId, MessageBody response) {
        ResponseFuture future = map.get(messageId);
        if (null != future) {
            future.setSuccess(response);
            map.remove(messageId);
        }
    }

}
