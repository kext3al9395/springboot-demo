package com.example.demo.config;

import com.example.demo.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by lisen on 2017/6/29.
 */
@Configuration
public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();

        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(8);
        poolConfig.setMaxTotal(8);
        poolConfig.setMinIdle(0);
        poolConfig.setMaxWaitMillis(-1);

        factory.setDatabase(0);
        factory.setHostName("192.168.0.12");
        factory.setPort(6379);
        factory.setPassword("Gb2tdfOD55QWdmx");
        factory.setPoolConfig(poolConfig);
        return factory;
    }

    @Bean
    public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, User> template = new RedisTemplate<String, User>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }
}
