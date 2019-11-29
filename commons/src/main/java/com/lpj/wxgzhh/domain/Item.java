package com.lpj.wxgzhh.domain;

import javax.xml.bind.annotation.XmlElement;

public class Item {

    //图文消息标题
    private String title;

    //图文消息描述
    private String description;

    //图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
    private String picUrl;

    //点击图文消息跳转链接
    private String url;

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

    public String getPicUrl() {
        return picUrl;
    }

    @XmlElement(name = "PicUrl")
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    @XmlElement(name = "Url")
    public void setUrl(String url) {
        this.url = url;
    }

    public Item(String title, String description, String picUrl, String url) {
        this.title = title;
        this.description = description;
        this.picUrl = picUrl;
        this.url = url;
    }

    public Item() {
    }
}
