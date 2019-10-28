package com.lpj.wxgzhh.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.lpj.wxgzhh.domain.InMessage;
import com.lpj.wxgzhh.domain.OutMessage;
import com.lpj.wxgzhh.service.MessageAnalysisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;


import javax.xml.bind.JAXBException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.Charset;


@RestController
@RequestMapping("/wxgzhh/message/receiver")
public class MessageConvertController {

    private static final Logger LOG = LoggerFactory.getLogger(MessageConvertController.class);

    @Autowired
    private MessageAnalysisService MRS;

    @Autowired
    private RedisTemplate<String,InMessage> inMessageTemplate;

    //测试
    ObjectMapper objectMapper = new ObjectMapper();
    private HttpClient httpClient = HttpClient.newBuilder().build();

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

        InputStream isXML = new ByteArrayInputStream(xml.getBytes());

        Map<String,String> xmlMap=MRS.parseXml(isXML);
        LOG.trace("解析后：\n{}\n",xmlMap);

        LOG.trace("解析后获取类型：\n{}\n",xmlMap.get("MsgType"));

        InMessage inMessage=MRS.XMLStringToBean(xml);

        LOG.trace("转换为对象：\n{}\n",inMessage);

        byte[] bytes=MRS.serialize(xml);

        LOG.trace("解析为后的字节数组"+bytes);

        InMessage im=MRS.toInmaesage(bytes);

        LOG.trace("反序列化的对象"+im);

        String channel = "wxgzhh";

        inMessageTemplate.convertAndSend(channel, inMessage);

        String hf="<xml>\n" +
                "  <ToUserName><![CDATA["+inMessage.getFromUserName()+"]]></ToUserName>\n" +
                "  <FromUserName><![CDATA["+inMessage.getToUserName()+"]]></FromUserName>\n" +
                "  <CreateTime>12345678</CreateTime>\n" +
                "  <MsgType><![CDATA[text]]></MsgType>\n" +
                "  <Content><![CDATA[你好]]></Content>\n" +
                "</xml>";


        //测试回复消息

        String openId=inMessage.getFromUserName();

        String url="https://api.weixin.qq.com/customservice/kfaccount/add?access_token=lpj";

        String text="655";

        OutMessage out = new OutMessage(openId, text);

        String json = this.objectMapper.writeValueAsString(out);

        HttpRequest request = HttpRequest.newBuilder(URI.create(url))//
                // 以POST方式发送请求
                .POST(BodyPublishers.ofString(json, StandardCharsets.UTF_8))//
                .build();

        return "success";
    }

}
