package com.lpj.wxgzhh.controller;

import com.lpj.wxgzhh.service.ChatContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/store/chat")
public class ChatContentController {
    private static final Logger LOG = LoggerFactory.getLogger(ChatContentController.class);

    @Autowired
    private ChatContentService CCS;

    // 前端传用户id，返回对话列表界面需要的数据
    @PostMapping
    public String onMessage(@RequestParam("userid") String userId) {
        String json=CCS.messageListShow(userId);
        return json;
    }

    // 前端传用户id及会话对象id，返回聊天记录
    @PostMapping
    @RequestMapping("/dialogue")
    public String onChatRoom(@RequestParam("userid") String userId,@RequestParam("dialogueUserId") String dialogueUserId) {
        String json=CCS.messageShow(userId,dialogueUserId);
        return json;
    }

    // 前端传用户id，会话对象id，聊天内容进行对话添加，返回是否成功
    @PostMapping
    @RequestMapping("/add")
    public void addChat(@RequestParam("userid") String userId, @RequestParam("receptionid") String receptionId,
                          @RequestParam("text") String text) {
        CCS.AddChat(userId, receptionId,text);
    }

}
