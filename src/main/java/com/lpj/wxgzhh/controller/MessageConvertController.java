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
    private RedisTemplate<String,InMessage> inMessageTemplate;


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
            HttpServletResponse response,
            HttpServletRequest request,
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

        String hf="<xml>" +
                "<ToUserName><![CDATA["+inMessage.getFromUserName()+"]]></ToUserName>" +
                "<FromUserName><![CDATA["+inMessage.getToUserName()+"]]></FromUserName>" +
                "<CreateTime>12345678</CreateTime>" +
                "<MsgType><![CDATA[text]]></MsgType>" +
                "<Content><![CDATA[你好]]></Content>" +
                "</xml>";

        response.reset();

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        OutputStream out=response.getOutputStream();
        OutputStreamWriter out = new OutputStreamWriter(response
                .getOutputStream(), "UTF-8");
//        out.print(hf);
        out.flush();
        out.write(hf);
        out.close();
        LOG.trace("发回的响应：\n{}\n",response);
        return "success";
    }

}
