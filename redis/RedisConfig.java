package com.yuan.config;

import com.yuan.util.RedisUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuan
 * @date 2020/3/23 16:48
 */
@Configuration
public class RedisConfig {

    @Value("${spring.redis.host:disable}")
    private String host;

    @Value("${spring.redis.port:6379}")
    private int port;

    @Bean
    public RedisUtil redisUtil() {
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.initPool(host, port);
        return redisUtil;
    }
}
