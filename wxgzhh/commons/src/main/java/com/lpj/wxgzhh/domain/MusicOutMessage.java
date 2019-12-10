package com.lpj.wxgzhh.domain;

import javax.xml.bind.annotation.XmlElement;
import java.util.Map;

public class MusicOutMessage extends OutMessage {

    //音乐标题
    private String title;

    //音乐描述
    private String description;

    //音乐链接
    private String musicURL;

    //高质量音乐链接，WIFI环境优先使用该链接播放音乐
    private String hqMusicUrl;

    //缩略图的媒体id，通过素材管理中的接口上传多媒体文件，得到的id
    private String thumbMediaId;

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

    public String getMusicURL() {
        return musicURL;
    }

    @XmlElement(name = "MusicURL")
    public void setMusicURL(String musicURL) {
        this.musicURL = musicURL;
    }

    public String getHqMusicUrl() {
        return hqMusicUrl;
    }

    @XmlElement(name = "HQMusicUrl")
    public void setHqMusicUrl(String hqMusicUrl) {
        this.hqMusicUrl = hqMusicUrl;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    @XmlElement(name = "ThumbMediaId")
    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    public MusicOutMessage(Map<String, String> requestMap,String title,String description,
            String musicURL,String hqMusicUrl,String thumbMediaId) {
        super(requestMap);
        this.setMsgType("music");
        this.title=title;
        this.description=description;
        this.musicURL=musicURL;
        this.hqMusicUrl=hqMusicUrl;
        this.thumbMediaId=thumbMediaId;
    }

    public String toString() {
        return "<xml>" +
                "<ToUserName><![CDATA["+getToUserName()+"]]></ToUserName>" +
                "<FromUserName><![CDATA["+getFromUserName()+"]]></FromUserName>" +
                "<CreateTime>"+getCreateTime()+"</CreateTime>" +
                "<MsgType><![CDATA["+getMsgType()+"]]></MsgType>" +
                "<Music><Title><![CDATA["+getTitle()+"]]></Title>" +
                "<Description><![CDATA["+getDescription()+"]]></Description>" +
                "<MusicUrl><![CDATA["+getMusicURL()+"]]></MusicUrl>" +
                "<HQMusicUrl><![CDATA["+getHqMusicUrl()+"]]></HQMusicUrl>" +
                "<ThumbMediaId><![CDATA["+getThumbMediaId()+"]]></ThumbMediaId></Music>" +
                "</xml>";
    }
}
