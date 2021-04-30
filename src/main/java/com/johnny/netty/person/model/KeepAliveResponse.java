package com.johnny.netty.person.model;

import com.johnny.netty.common.MessageBody;

public class KeepAliveResponse extends MessageBody {
    private long time;

    public KeepAliveResponse() {
    }

    public KeepAliveResponse(long time) {
        super();
        this.time = time;
    }
}
