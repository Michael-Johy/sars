package com.johnny.core.nio.netty.person.model;

import com.johnny.core.nio.netty.common.MessageBody;

public class PersonResponse extends MessageBody {
    private int id;
    private String name;

    public PersonResponse() {
    }

    public PersonResponse(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
