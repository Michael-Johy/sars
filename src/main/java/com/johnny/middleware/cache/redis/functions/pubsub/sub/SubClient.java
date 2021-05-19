package com.johnny.middleware.cache.redis.functions.pubsub.sub;

import redis.clients.jedis.JedisPubSub;

public class SubClient extends JedisPubSub {
    @Override
    public void onMessage(String channel, String message) {
        System.out.println("channel = " + channel + ", message = " + message);
    }

    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println("pattern + " + pattern + ", channel = " + channel + ", message = " + message);

    }

    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        super.onSubscribe(channel, subscribedChannels);
    }

    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        super.onUnsubscribe(channel, subscribedChannels);
    }

    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        super.onPUnsubscribe(pattern, subscribedChannels);
    }

    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        super.onPSubscribe(pattern, subscribedChannels);
    }

    @Override
    public void onPong(String pattern) {
        super.onPong(pattern);
    }
}
