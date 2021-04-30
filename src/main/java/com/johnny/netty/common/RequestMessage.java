package com.johnny.netty.common;

import com.johnny.netty.person.OperationTypes;

public class RequestMessage extends Message {
    @Override
    public Class<? extends MessageBody> getMessageBodyClassByOp(int opCode) {
        OperationTypes operationTypes = OperationTypes.getByOpCode(opCode);
        if (null == operationTypes) {
            return null;
        }
        return operationTypes.getRequestClass();
    }
}
