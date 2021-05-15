package com.johnny.middlewareandframe.cache.redis.datatype;

import com.johnny.middlewareandframe.cache.redis.RedisIns;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;
import redis.clients.jedis.ZParams;

import java.util.Set;

/**
 * Redis inner datatype
 * intSet
 */

public class DataTypes {

    private static final Jedis jedis = RedisIns.getRedis().getResource();
    private static final String key = "set1";
    private static final String key2 = "set2";
    private static final String key3 = "set3";


    public static void main(String[] args) {
        testSortedSet();
    }

    /**
     * Sorted Set
     */
    private static void testSortedSet() {
        jedis.zadd(key, 1.0, "yt1");
        jedis.zadd(key, 2.0, "yt2");
        jedis.zadd(key, 3.0, "yt3");
        jedis.zadd(key, 4.0, "yt4");

        long zCard = jedis.zcard(key);
        System.out.println("zCard = " + zCard);

        long count = jedis.zcount(key, 2, 3);
        System.out.println("zCount = " + count);

        double newScore = jedis.zincrby(key, 1.0, "yt1");
        System.out.println("zIncrBy = " + newScore);

        jedis.zadd(key2, 1.0, "yt1");
        jedis.zadd(key2, 2.0, "yt2");
        jedis.zadd(key2, 3.0, "yt3");

        ZParams zParams = new ZParams();
        zParams.weights(1, 2);
        long key3Card = jedis.zinterstore(key3, zParams, key, key2);
        System.out.println("key3 zCard = " + key3Card);

        long lexCount = jedis.zlexcount(key, "yt", "yt");
        System.out.println("lexCount = " + lexCount);

        Tuple max = jedis.zpopmax(key);
        System.out.println("elem = " + max.getElement() + ", score = " + max.getScore());

        Set<Tuple> maxN = jedis.zpopmax(key, 3);
        for (Tuple tuple : maxN) {
            System.out.println("elem = " + tuple.getElement() + ", score = " + tuple.getScore());
        }

        Set<String> items = jedis.zrange(key, 1, 3);
        Set<String> lexItems = jedis.zrangeByLex(key, "yt", "yt");
        Set<String> scoreItems = jedis.zrangeByScore(key, 1, 2);

        long rank = jedis.zrank(key, "yt1");
        long removed = jedis.zrem(key, "yt1");

    }
}
