package com.lpj.wxgzhh.domain;

import javax.xml.bind.annotation.XmlElement;
import java.util.Map;

public class VoiceOutMessage extends OutMessage {

    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    @XmlElement(name = "MediaId")
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public VoiceOutMessage(Map<String, String> requestMap,String mediaId) {
        super(requestMap);
        this.setMsgType("voice");
        this.mediaId=mediaId;
    }

    public String toString() {
        return "<xml>" +
                "<ToUserName><![CDATA["+getToUserName()+"]]></ToUserName>" +
                "<FromUserName><![CDATA["+getFromUserName()+"]]></FromUserName>" +
                "<CreateTime>"+getCreateTime()+"</CreateTime>" +
                "<MsgType><![CDATA["+getMsgType()+"]]></MsgType>" +
                "<Voice><MediaId><![CDATA["+getMediaId()+"]]></MediaId></Voice>" +
                "</xml>";
    }
}
