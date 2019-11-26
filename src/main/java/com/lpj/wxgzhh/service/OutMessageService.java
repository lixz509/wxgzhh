package com.lpj.wxgzhh.service;


import com.lpj.wxgzhh.domain.InMessage;
import com.lpj.wxgzhh.domain.TextOutMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class OutMessageService {

    private static final Logger LOG = LoggerFactory.getLogger(OutMessageService.class);

    public String getRepose(InMessage inMessage) {
//        LOG.trace("Type：\n{}\n",inMessage.getMsgType());
//        if (inMessage.getMsgType().equals("text")){
//                Map<String, String> requestMap =new HashMap<>();
//                requestMap.put("ToUserName",inMessage.getToUserName());
//                requestMap.put("FromUserName",inMessage.getFromUserName());
//                TextOutMessage tom=new TextOutMessage(requestMap,"你好啊");
//                LOG.trace("toString：\n{}\n",tom.toString());
//                return tom.toString();
//        } else {
//            return "no";
//        }

        switch (inMessage.getMsgType()){
            case "text":
                Map<String, String> requestMap =new HashMap<>();
                requestMap.put("ToUserName",inMessage.getToUserName());
                requestMap.put("FromUserName",inMessage.getFromUserName());
                TextOutMessage tom=new TextOutMessage(requestMap,"你好啊");
                LOG.trace("toString：\n{}\n",tom.toString());
                return tom.toString();
        }
        return "no";
    }
}
