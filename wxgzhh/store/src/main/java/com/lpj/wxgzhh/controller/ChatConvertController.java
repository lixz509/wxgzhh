package com.lpj.wxgzhh.controller;

import com.lpj.wxgzhh.service.ChatConvertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/store/chat")
public class ChatConvertController {
    private static final Logger LOG = LoggerFactory.getLogger(ChatConvertController.class);

    @Autowired
    private ChatConvertService CCS;

    @PostMapping
    public String onMessage(@RequestParam("userid") String userId) {
        String json=CCS.messageListShow(userId);
        return json;
    }

    @PostMapping
    @RequestMapping("/dialogue")
    public String dialogue(@RequestParam("userid") String userId,@RequestParam("dialogueUserId") String dialogueUserId) {
        String json=CCS.messageShow(userId,dialogueUserId);
        return json;
    }

    @PostMapping
    @RequestMapping("/add")
    public String addChat(@RequestParam("userid") String userId, @RequestParam("receptionid") String receptionId,
                          @RequestParam("text") String text) {
        String message = CCS.AddChat(userId, receptionId,text);
        System.out.println(text);
        return message;
    }

}
