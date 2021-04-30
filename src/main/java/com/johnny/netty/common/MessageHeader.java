package com.johnny.netty.common;

public class MessageHeader {
    private int version;
    private int opCode;
    private long messageId;

    public MessageHeader() {
    }

    public MessageHeader(int version, int opCode, long messageId) {
        this.version = version;
        this.opCode = opCode;
        this.messageId = messageId;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getOpCode() {
        return opCode;
    }

    public void setOpCode(int opCode) {
        this.opCode = opCode;
    }
}
