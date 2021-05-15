package com.johnny.middlewareandframe.cache.redis.functions.pubsub;

import com.johnny.middlewareandframe.cache.redis.RedisIns;

public class Pub {
    public static void main(String[] args) {
        long a = RedisIns.getRedis().getResource().publish("message", "hello");
        System.out.println("pub reply = " + a);
    }

}
