package com.lpj.wxgzhh.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/wxgzhh/message/receiver")
public class MessageReceiverController {

    private static final Logger LOG = LoggerFactory.getLogger(MessageReceiverController.class);

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
            @RequestBody String xml){
        LOG.trace("收到的消息原文：\n{}\n",xml);
        return "success";
    }


}
