package com.lpj.wxgzhh.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lpj.wxgzhh.domain.InMessage;
import com.lpj.wxgzhh.domain.OutMessage;
import com.lpj.wxgzhh.domain.button.*;
import com.lpj.wxgzhh.service.AccessTokenManager;
import com.lpj.wxgzhh.service.MenuService;
import com.lpj.wxgzhh.service.MessageAnalysisService;
import com.lpj.wxgzhh.service.OutMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.Map;

@RestController
@RequestMapping("/wxgzhh/message/receiver")
public class MessageConvertController {

    private static final Logger LOG = LoggerFactory.getLogger(MessageConvertController.class);

    @Autowired
    private MessageAnalysisService MRS;

    @Autowired
    private OutMessageService OMS;

    @Autowired
    private  RedisTemplate<String,InMessage> inMessageTemplate;

    @Autowired
    private AccessTokenManager ATM;

    @Autowired
    private MenuService MS;

    @GetMapping
    public String echo(
            @RequestParam("signature") String signature,
            @RequestParam("timestamp") String timestamp,
            @RequestParam("nonce") String nonce,
            @RequestParam("echostr") String echostr
    ){
        return echostr;
    }

    @PostMapping
    public String onMessage(
            @RequestParam("signature") String signature,
            @RequestParam("timestamp") String timestamp,
            @RequestParam("nonce") String nonce,
            @RequestBody  String xml) throws JAXBException, IOException, ClassNotFoundException {
        LOG.trace("收到的消息原文：\n{}\n",xml);
//        InputStream isXML = new ByteArrayInputStream(xml.getBytes());
//        Map<String,String> xmlMap=MRS.parseXml(isXML);
//        LOG.trace("解析后：\n{}\n",xmlMap);
//        byte[] bytes=MRS.serialize(xml);
//        LOG.trace("解析为后的字节数组"+bytes);
//        InMessage im=MRS.toInmaesage(bytes);
//        LOG.trace("反序列化的对象"+im);
        InMessage inMessage=MRS.XMLStringToBean(xml);
        LOG.trace("转换为对象：\n{}\n",inMessage);
        String channel = "wxgzhh_";
        if(inMessage.getMsgType().equals("event")){
            inMessageTemplate.convertAndSend(channel+inMessage.getMsgType()+"_"+inMessage.getEvent(), inMessage);
        }else {
            //将得到的消息存入消息队列，并在前面加入消息类型
            inMessageTemplate.convertAndSend(channel+inMessage.getMsgType(), inMessage);
        }

        //重置菜单
        MS.Menu();

        return "success";
    }

}
