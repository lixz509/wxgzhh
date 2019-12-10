package com.lpj.wxgzhh.service;


import com.lpj.wxgzhh.domain.InMessage;
import com.lpj.wxgzhh.domain.Item;
import com.lpj.wxgzhh.domain.NewsOutMessage;
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

    //测试用的方法，封装一个消息进行回复，正式使用时会更改，不在这里进行业务逻辑处理
    public String getRepose(InMessage inMessage) {

//        switch (inMessage.getMsgType()){
//            case "text":
//                Map<String, String> requestMap =new HashMap<>();
//                requestMap.put("ToUserName",inMessage.getToUserName());
//                requestMap.put("FromUserName",inMessage.getFromUserName());
//                Item item=new Item();
//                item.setTitle("你好啊");
//                item.setDescription("这是一个测试的图文消息回复");
//                item.setPicUrl("http://img-arch.pconline.com.cn/images/upload/upc/tx/photoblog/1712/19/c4/70328457_1513655137311.jpg");
//                item.setUrl("https://www.baidu.com/");
//                NewsOutMessage nom= new NewsOutMessage(requestMap,item);
////                TextOutMessage tom=new TextOutMessage(requestMap,"你好啊");
////                String channel = "wxgzhh_";
////                inMessageTemplate.convertAndSend(channel+inMessage.getMsgType(), inMessage);
//                return nom.toString();
//        }
        return "no";
    }
}
