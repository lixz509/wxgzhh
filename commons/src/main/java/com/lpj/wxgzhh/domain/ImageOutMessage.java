package com.lpj.wxgzhh.domain;

import javax.xml.bind.annotation.XmlElement;
import java.util.Map;

public class ImageOutMessage extends OutMessage  {

    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    @XmlElement(name = "MediaId")
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public ImageOutMessage(Map<String, String> requestMap,String mediaId) {
        super(requestMap);
        this.setMsgType("image");
        this.mediaId=mediaId;
    }

    @Override
    public String toString() {
        return "<xml>" +
                "<ToUserName><![CDATA["+getToUserName()+"]]></ToUserName>" +
                "<FromUserName><![CDATA["+getFromUserName()+"]]></FromUserName>" +
                "<CreateTime>"+getCreateTime()+"</CreateTime>" +
                "<MsgType><![CDATA["+getMsgType()+"]]></MsgType>" +
                "<Image><MediaId><![CDATA["+getMediaId()+"]]></MediaId></Image>" +
                "</xml>";
    }
}
