package com.johnny.netty.person.model;

import com.johnny.netty.common.MessageBody;

public class KeepAliveRequest extends MessageBody {
    private long time;

    public KeepAliveRequest() {
    }

    public KeepAliveRequest(long time) {
        super();
        this.time = time;
    }
}
