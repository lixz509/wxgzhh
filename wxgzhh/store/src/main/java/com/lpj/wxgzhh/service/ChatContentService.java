package com.lpj.wxgzhh.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lpj.wxgzhh.domain.StoreDialogue;
import com.lpj.wxgzhh.domain.StoreUser;
import com.lpj.wxgzhh.domain.dto.ChatListDto;
import com.lpj.wxgzhh.repository.DialogueRepository;
import com.lpj.wxgzhh.repository.StoreUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import static com.lpj.wxgzhh.domain.StoreDialogue.dialogueState.IS_UNREAD;

@Service
public class ChatContentService {

    @Autowired
    private DialogueRepository DR;

    @Autowired
    private StoreUserRepository SUR;

    // 根据用户id查询消息
    // 用户列表展示
    public String messageListShow(String userId){
        ChatListDto chatListDto=new ChatListDto();
        // 分别查询接收者和发送者为该用户的消息，从中获取对话对象用户id
        ArrayList<String> a=DR.findUserIdByReceptionId(userId);
        ArrayList<String> b=DR.findUserIdBySendId(userId);
        // TreeSet用于存储不重复的对象
        TreeSet t=new TreeSet();
        t.addAll(a);
        t.addAll(b);
        ArrayList<ChatListDto.ChatDto> cds=new ArrayList<>();
        for (Object c:t){
            ChatListDto.ChatDto chatDto=new ChatListDto.ChatDto();
            String message= DR.findLastMessage(userId, (String) c);
            StoreUser storeUser=SUR.findByUserId((String) c);
            chatDto.setDialogueName(storeUser.getUserName());
            chatDto.setDialogueUserId(storeUser.getUserId());
            chatDto.setUnreadNum(DR.findUnreadNumById((String) c,userId));
            chatDto.setLastMessage(message.substring(0, message.indexOf(",")));
            chatDto.setTime(message.substring(message.indexOf(",")+1,message.length()));
            System.out.println(chatDto.toString());
            cds.add(chatDto);
        }
        chatListDto.setChatDtos(cds);
        String json= JSON.toJSONString(chatListDto, SerializerFeature.DisableCircularReferenceDetect);
        return json;
    }

    // 根据用户及会话对象id查询聊天记录
    // 并且将未读状态刷新
    // 用户对话展示
    public String messageShow(String userId,String dialogueUserId){
        // SerializerFeature.DisableCircularReferenceDetect表示加载相同数据时不折叠
        String json= JSON.toJSONString(DR.findByReceptionIdAndSendId(userId,dialogueUserId),
                SerializerFeature.DisableCircularReferenceDetect);
        System.out.println(DR.saveState(userId,dialogueUserId));
        return json;
    }

    // 增加消息
    public void AddChat(String userId,String receptionId,String text){
        StoreDialogue storeDialogue=new StoreDialogue();
        storeDialogue.setSendId(userId);
        storeDialogue.setReceptionId(receptionId);
        storeDialogue.setDialogueText(text);
        storeDialogue.setDialogueState(IS_UNREAD);
        storeDialogue.setDialogueTime(new Date());
        DR.save(storeDialogue);
    }

}
