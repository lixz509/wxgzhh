package com.lpj.wxgzhh.domain;

import javax.xml.bind.annotation.XmlElement;
import java.util.Map;

public class VideoOutMessage extends OutMessage {

    private String mediaId;

    private String title;

    private String description;

    public String getMediaId() {
        return mediaId;
    }

    @XmlElement(name = "MediaId")
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getTitle() {
        return title;
    }

    @XmlElement(name = "Title")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement(name = "Description")
    public void setDescription(String description) {
        this.description = description;
    }

    public VideoOutMessage(Map<String, String> requestMap, String mediaId, String title, String description) {
        super(requestMap);
        this.setMsgType("video");
        this.mediaId=mediaId;
        this.title=title;
        this.description=description;
    }

    @Override
    public String toString() {
        return "<xml>" +
                "<ToUserName><![CDATA["+getToUserName()+"]]></ToUserName>" +
                "<FromUserName><![CDATA["+getFromUserName()+"]]></FromUserName>" +
                "<CreateTime>"+getCreateTime()+"</CreateTime>" +
                "<MsgType><![CDATA["+getMsgType()+"]]></MsgType>" +
                "<Video><MediaId><![CDATA["+getMediaId()+"]]></MediaId>" +
                "<Title><![CDATA["+getTitle()+"]]></Title>" +
                "<Description><![CDATA["+getDescription()+"]]></Description></Video>" +
                "</xml>";
    }
}
