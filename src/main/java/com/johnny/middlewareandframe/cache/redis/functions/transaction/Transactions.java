package com.johnny.middlewareandframe.cache.redis.functions.transaction;

import com.johnny.middlewareandframe.cache.redis.RedisIns;
import redis.clients.jedis.Transaction;

import java.util.List;

public class Transactions {

    public static void main(String[] args) throws Exception {
        new Thread(new Lock()).start();
        new Thread(new Lock()).start();

        Thread.sleep(1000 * 1000 * 1000);

    }

    static class Lock implements Runnable {
        @Override
        public void run() {
            while (true) {
                // to get a lock
                Transaction multi = RedisIns.getRedis().getResource().multi();
                multi.set("key", "1");
                List<Object> objects = multi.exec();
                multi.close();
                try {
                    Thread.sleep(30 * 1000);
                } catch (Exception e) {
                }
            }
        }
    }

}
