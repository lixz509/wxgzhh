package com.lpj.wxgzhh.service;

import com.lpj.wxgzhh.domain.InMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;

@Service
public class CommonsService {
    //序列化和反序列化程序，用于将对象丢入redis消息队列
    @Bean
    public RedisTemplate<String, InMessage> inMessageTemplate(
            @Autowired RedisConnectionFactory connectionFactory) {

        RedisTemplate<String,InMessage> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        // 使用序列化程序完成对象的序列化和反序列化，可以自定义
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(InMessage.class));
        return template;
    }
    @Bean
    public <T> RedisTemplate<String, T> redisTemplate(
            @Autowired RedisConnectionFactory connectionFactory) {
        RedisTemplate<String,T> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        // 使用序列化程序完成对象的序列化和反序列化，可以自定义
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(InMessage.class));
        return template;
    }
}
