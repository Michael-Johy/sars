package com.johnny.middleware.netty.common;

import com.johnny.utils.json.JsonUtils;
import io.netty.buffer.ByteBuf;

import java.nio.charset.StandardCharsets;

public abstract class Message {
    private MessageHeader header;
    private MessageBody body;

    public Message() {
    }

    public Message(MessageHeader header, MessageBody body) {
        this.header = header;
        this.body = body;
    }

    public void encode(ByteBuf buf) {
        buf.writeLong(header.getMessageId());
        buf.writeInt(header.getVersion());
        buf.writeInt(header.getOpCode());
        buf.writeBytes(JsonUtils.toJSONString(body).getBytes(StandardCharsets.UTF_8));
    }

    public abstract Class<? extends MessageBody> getMessageBodyClassByOp(int opCode);

    public void decode(ByteBuf buf) {
        long messageId = buf.readLong();
        int version = buf.readInt();
        int opCode = buf.readInt();
        Class<? extends MessageBody> clazz = getMessageBodyClassByOp(opCode);
        if (null == clazz) {
            return;
        }
        header = new MessageHeader(version, opCode, messageId);
        body = JsonUtils.parseObject(buf.toString(StandardCharsets.UTF_8), clazz);
    }

    public MessageHeader getHeader() {
        return header;
    }

    public void setHeader(MessageHeader header) {
        this.header = header;
    }

    public MessageBody getBody() {
        return body;
    }

    public void setBody(MessageBody body) {
        this.body = body;
    }
}
