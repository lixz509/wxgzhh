package com.lpj.wxgzhh.domain;

import javax.xml.bind.annotation.XmlElement;

public class Item {

    private String title;

    private String description;

    private String picUrl;

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
}
