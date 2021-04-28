package com.johnny.middleware.cache.redis.functions.pubsub;

import com.johnny.middleware.cache.redis.RedisIns;
import com.johnny.middleware.cache.redis.functions.pubsub.sub.SubClient;

public class Sub {
    public static void main(String[] args) throws Exception {
        SubClient subClient = new SubClient();

        RedisIns.getRedis().getResource().subscribe(subClient, "message");

        Thread.sleep(1000 * 1000);
    }
}
