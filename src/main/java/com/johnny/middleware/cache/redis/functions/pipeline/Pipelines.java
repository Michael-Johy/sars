package com.johnny.middleware.cache.redis.functions.pipeline;

import com.johnny.middleware.cache.redis.RedisIns;
import redis.clients.jedis.Pipeline;


// improve
public class Pipelines {
    public static void main(String[] args) {
        Pipeline pipelined = RedisIns.getRedis().getResource().pipelined();
        pipelined.set("1", "1");
        pipelined.set("2", "2");
        pipelined.set("3", "3");
        pipelined.set("4", "4");
        pipelined.set("5", "5");

        pipelined.sync();
        pipelined.syncAndReturnAll();

    }
}
