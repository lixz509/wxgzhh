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

        LOG.trace("发回的响应0：\n{}\n",channel);

        String hf="<xml>" +
                "<ToUserName><![CDATA["+inMessage.getFromUserName()+"]]></ToUserName>" +
                "<FromUserName><![CDATA["+inMessage.getToUserName()+"]]></FromUserName>" +
                "<CreateTime>12345678</CreateTime>" +
                "<MsgType><![CDATA[text]]></MsgType>" +
                "<Content><![CDATA[你好]]></Content>" +
                "</xml>";
        LOG.trace("发回的响应1：\n{}\n",hf);
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        LOG.trace("发回的响应2：\n{}\n",hf);
//        OutputStream out=response.getOutputStream();
        OutputStreamWriter out = new OutputStreamWriter(response
                .getOutputStream(), "UTF-8");
//        out.print(hf);-
        LOG.trace("发回的响应3：\n{}\n",hf);
        out.flush();
        LOG.trace("发回的响应4：\n{}\n",hf);
        out.write(hf);
        LOG.trace("发回的响应5：\n{}\n",hf);
        out.close();
        LOG.trace("发回的响应：\n{}\n",response);

        LOG.trace("反序列化的对象2"+im);
        return hf;
    }

}
