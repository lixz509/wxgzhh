package com.lpj.wxgzhh.service;


import com.lpj.wxgzhh.domain.InMessage;
import com.lpj.wxgzhh.domain.TextOutMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OutMessageService {

    private static final Logger LOG = LoggerFactory.getLogger(OutMessageService.class);

    //序列化和反序列化程序，用于将对象丢如redis消息队列
    @Bean
    public RedisTemplate<String, InMessage> inMessageTemplate(
            @Autowired RedisConnectionFactory connectionFactory) {

        RedisTemplate<String,InMessage> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        // 使用序列化程序完成对象的序列化和反序列化，可以自定义
        template.setValueSerializer(new Jackson2JsonRedisSerializer<>(InMessage.class));
        return template;
    }

    public String getRepose(InMessage inMessage) {

        switch (inMessage.getMsgType()){
            case "text":
                Map<String, String> requestMap =new HashMap<>();
                requestMap.put("ToUserName",inMessage.getToUserName());
                requestMap.put("FromUserName",inMessage.getFromUserName());
                TextOutMessage tom=new TextOutMessage(requestMap,"你好啊");

//                String channel = "wxgzhh_";
//                inMessageTemplate.convertAndSend(channel+inMessage.getMsgType(), inMessage);
                return tom.toString();
        }
        return "no";
    }
}
