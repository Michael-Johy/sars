package com.johnny.middleware.cache.redis;

import com.google.common.collect.Lists;
import com.johnny.sars.lang.exception.Exceptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * * Created By: yangtao3
 * * Date: 2019/5/6 14:50
 * * Description: RedisUtils
 * <h1>Usage</h1>
 *
 * @Configuration public class MyApplication{
 * @Bean public RedisUtils redisUtils(){
 * RedisUtils redisUtils = new RedisUtils();
 * redisUtils.setHost("127.0.0.1");
 * redisUtils.setPort(6379);
 * redisUtils.setPassword("11111");
 * redisUtils.setMaxIdle(8);
 * redisUtils.setMinIdle(0);
 * redisUtils.setMaxTotal(8);
 * redisUtils.setMaxWaitMills(1000L);
 * redisUtils.setTimeout(1000);
 * return redisUtils;
 * }
 * }
 * <p>
 * }
 */
public class RedisUtils {

    private static final Logger log = LoggerFactory.getLogger(ØRedisUtils.class);

    private static volatile JedisPool jedisPool = null;

    private String host;
    private int port;
    private int timeout = 1000;
    private String password = null;
    private int maxIdle = 8;
    private int minIdle = 0;
    private long maxWaitMills = -1L;
    private int maxTotal = 8;


    private static final String Success = "1";

    private static final String LOCK_SCRIPT = "local num = redis.call('SETNX', KEYS[1], ARGV[1])\n" +
            "if tonumber(num) == 1 then\n" +
            "    redis.call('expire', KEYS[1], ARGV[2])\n" +
            "    return 1\n" +
            "else \n" +
            "    return 0\n" +
            "end";

    private static final String UNLOCK_SCRIPT = "local value = redis.call('GET', KEYS[1])\n" +
            "if value == ARGV[1] then\n" +
            "    redis.call('del', KEYS[1])\n" +
            "    return 1\n" +
            "else \n" +
            "    return 0\n" +
            "end";

    private void init() {
        if (null == jedisPool) {
            synchronized (RedisUtils.class) {
                if (null == jedisPool) {
                    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
                    jedisPoolConfig.setMaxIdle(maxIdle);
                    jedisPoolConfig.setMinIdle(minIdle);
                    jedisPoolConfig.setMaxWaitMillis(maxWaitMills);
                    jedisPoolConfig.setMaxTotal(maxTotal);
                    jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
                }
            }
        }
    }

    public Jedis getResource() {
        init();
        return jedisPool.getResource();
    }

    private void releaseResource(Jedis jedis) {
        if (null != jedis) {
            jedis.close();
        }
    }

    public boolean tryLock(String key, String randomValue, long timeout, long expire) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            long sleepTime = timeout / 5;
            while (timeout > 0) {
                Object object = jedis.eval(LOCK_SCRIPT, Lists.newArrayList(key), Lists.newArrayList(randomValue, expire + ""));
                if (object.toString().equalsIgnoreCase(Success)) {
                    return true;
                }
                timeout -= sleepTime;
            }
        } catch (Exception e) {
            log.warn("RedisUtils tryLock fault, error = " + Exceptions.getStackTrace(e));
        } finally {
            releaseResource(jedis);
        }
        return false;
    }

    public boolean unLock(String key, String value) {
        return unLock(key, value, 3);
    }

    public boolean unLock(String key, String value, int retrys) {
        Jedis jedis = null;
        try {
            jedis = getResource();
            while (retrys > 0) {
                Object object = jedis.eval(UNLOCK_SCRIPT, Lists.newArrayList(key), Lists.newArrayList(value));
                if (object.toString().equalsIgnoreCase(Success)) {
                    return true;
                }
                retrys--;
            }
        } catch (Exception e) {
            log.warn("RedisUtils unLock fault, error = " + Exceptions.getStackTrace(e));
        } finally {
            releaseResource(jedis);
        }
        return false;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }

    public long getMaxWaitMills() {
        return maxWaitMills;
    }

    public void setMaxWaitMills(long maxWaitMills) {
        this.maxWaitMills = maxWaitMills;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }
}
