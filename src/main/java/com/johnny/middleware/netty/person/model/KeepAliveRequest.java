package com.johnny.middleware.netty.person.model;

import com.johnny.middleware.netty.common.MessageBody;

public class KeepAliveRequest extends MessageBody {
    private long time;

    public KeepAliveRequest() {
    }

    public KeepAliveRequest(long time) {
        super();
        this.time = time;
    }
}
