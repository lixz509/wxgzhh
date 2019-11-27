package com.lpj.wxgzhh.service;


import com.lpj.wxgzhh.domain.InMessage;
import com.lpj.wxgzhh.domain.TextOutMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OutMessageService {

    private static final Logger LOG = LoggerFactory.getLogger(OutMessageService.class);

    @Autowired
    private RedisTemplate<String,InMessage> inMessageTemplate;

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
