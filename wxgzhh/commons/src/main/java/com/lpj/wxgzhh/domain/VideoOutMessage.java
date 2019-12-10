package com.lpj.wxgzhh.domain;

import javax.xml.bind.annotation.XmlElement;
import java.util.Map;

public class VideoOutMessage extends OutMessage {

    //通过素材管理中的接口上传多媒体文件，得到的id
    private String mediaId;

    //视频消息的标题
    private String title;

    //视频消息的描述
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
