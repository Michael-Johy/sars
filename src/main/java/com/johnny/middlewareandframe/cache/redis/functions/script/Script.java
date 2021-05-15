package com.johnny.middlewareandframe.cache.redis.functions.script;

import com.johnny.middlewareandframe.cache.redis.RedisIns;

// commands: script load; script flush; script exists
// transaction or pipeline 不适合后续操作依赖前面操作返回的结果，例如获取分布式锁操作，则依赖前面是否setNx=1,
// 等于1，则继续操作; 不等于1，取消
public class Script {

    public static void main(String[] args) {
        Object o = RedisIns.getRedis().getResource().eval("return 1");
        System.out.println(o);
    }

}
