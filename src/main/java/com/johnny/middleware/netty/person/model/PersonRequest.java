package com.johnny.middleware.netty.person.model;

import com.johnny.middleware.netty.common.MessageBody;

public class PersonRequest extends MessageBody {
    private int id;

    public PersonRequest() {
    }

    public PersonRequest(int id) {
        super();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
