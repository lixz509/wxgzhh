package com.lpj.wxgzhh.domain;

import javax.xml.bind.annotation.XmlElement;
import java.util.Map;

public class TextOutMessage extends OutMessage {

    //回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
    private String content;

    public String getContent() {
        return content;
    }

    @XmlElement(name = "Content")
    public void setContent(String content) {
        this.content = content;
    }

    public TextOutMessage(Map<String,String> requestMap,String content) {
        super(requestMap);
        this.setMsgType("text");
        this.content=content;
    }

    @Override
    public String toString() {
        return "<xml>" +
                "<ToUserName><![CDATA["+getToUserName()+"]]></ToUserName>" +
                "<FromUserName><![CDATA["+getFromUserName()+"]]></FromUserName>" +
                "<CreateTime>"+getCreateTime()+"</CreateTime>" +
                "<MsgType>"+getMsgType()+"</MsgType>" +
                "<Content><![CDATA["+getContent()+"]]></Content>" +
                "</xml>";
    }
}
