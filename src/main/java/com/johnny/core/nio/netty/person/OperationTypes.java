package com.johnny.core.nio.netty.person;

import com.johnny.core.nio.netty.common.MessageBody;
import com.johnny.core.nio.netty.person.model.KeepAliveRequest;
import com.johnny.core.nio.netty.person.model.KeepAliveResponse;
import com.johnny.core.nio.netty.person.model.PersonRequest;
import com.johnny.core.nio.netty.person.model.PersonResponse;

public enum OperationTypes {

    PERSON(1, PersonRequest.class, PersonResponse.class),
    KEEP_ALIVE(2, KeepAliveRequest.class, KeepAliveResponse.class);

    private final int opCode;
    private final Class<? extends MessageBody> requestClass;
    private final Class<? extends MessageBody> responseClass;

    OperationTypes(int opCode, Class<? extends MessageBody> request, Class<? extends MessageBody> response) {
        this.opCode = opCode;
        this.requestClass = request;
        this.responseClass = response;
    }

    public int getOpCode() {
        return opCode;
    }

    public Class<? extends MessageBody> getRequestClass() {
        return requestClass;
    }

    public Class<? extends MessageBody> getResponseClass() {
        return responseClass;
    }

    public static OperationTypes getByOpCode(int opCode) {
        for (OperationTypes operationTypes : OperationTypes.values()) {
            if (operationTypes.getOpCode() == opCode) {
                return operationTypes;
            }
        }
        return null;
    }

}
