package com.lpj.wxgzhh.controller;

import com.lpj.wxgzhh.service.WxgzhhService;
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
        if(WxgzhhService.chexk(signature,timestamp,nonce)){
            //成功则返回微信要求的参数
            return echostr;
        }else {
            //失败则error
            return "error";
        }
    }

}
