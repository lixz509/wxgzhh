package com.lpj.wxgzhh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wxgzhh/message/receiver")
public class MessageReceiverController {

    @GetMapping
    public String echo(
            String signature,
            String timestamp,
            String nonce,
            String echostr
    ){
        return echostr;
    }

}
