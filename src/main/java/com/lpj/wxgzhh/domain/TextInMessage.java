package com.lpj.wxgzhh.domain;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlRootElement(name="xml")
@ToString
public class TextInMessage {

    private String content;

    public String getContent() {
        return content;
    }

    @XmlElement(name = "Content")
    public void setContent(String content) {
        this.content = content;
    }











    private String toUserName;


    private String fromUserName;


    private String createTime;


    private String msgType;


    private String msgId;

    public String getToUserName() {
        return toUserName;
    }

    @XmlElement(name = "ToUserName")
    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    @XmlElement(name = "FromUserName")
    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }

    public String getCreateTime() {
        return createTime;
    }

    @XmlElement(name = "CreateTime")
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getMsgType() {
        return msgType;
    }

    @XmlElement(name = "MsgType")
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getMgId() {
        return msgId;
    }

    @XmlElement(name = "MsgId")
    public void setMgId(String msgId) {
        this.msgId = msgId;
    }




}
