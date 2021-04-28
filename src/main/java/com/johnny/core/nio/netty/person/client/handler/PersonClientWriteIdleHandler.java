package com.johnny.core.nio.netty.person.client.handler;

import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

public class PersonClientWriteIdleHandler extends IdleStateHandler {

    public PersonClientWriteIdleHandler() {
        super(0, 15, 0, TimeUnit.SECONDS);
    }
}
