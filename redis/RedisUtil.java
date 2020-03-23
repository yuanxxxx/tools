package com.yuan.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author yuan
 * @date 2020/3/23 16:49
 */
public class RedisUtil {

    private JedisPool jedisPool;

    public void initPool(String host, int port) {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(200);
        poolConfig.setMaxIdle(30);
        poolConfig.setBlockWhenExhausted(true);
        poolConfig.setMaxWaitMillis(10 * 1000);
        poolConfig.setTestOnBorrow(false);
        jedisPool = new JedisPool(poolConfig, host, port, 20*1000);
    }

    public Jedis getJedis() {
        return jedisPool.getResource();
    }
}
