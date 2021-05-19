package com.johnny.middleware.cache.redis;


/**
 * redis.cn
 * http://www.redis.cn/
 * <p>
 * Redis Cluster
 * Redis Sentinel
 */
public class RedisIns {

    public static RedisUtils getRedis() {
        RedisUtils result = new RedisUtils();
        result.setHost("redis.host");
        result.setPort(6379);
        result.setPassword("D1spatchEr");
        result.setMaxIdle(8);
        result.setMinIdle(0);
        result.setMaxTotal(8);
        result.setMaxWaitMills(1000L);
        result.setTimeout(1000);
        return result;
    }

}
