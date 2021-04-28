package com.johnny.core.nio.netty.person.model;

import com.johnny.core.nio.netty.common.MessageBody;

public class KeepAliveResponse extends MessageBody {
    private long time;

    public KeepAliveResponse() {
    }

    public KeepAliveResponse(long time) {
        super();
        this.time = time;
    }
}
