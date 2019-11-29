package com.lpj.wxgzhh.domain;

import javax.xml.bind.annotation.XmlElement;
import java.util.Map;

public class NewsOutMessage extends OutMessage {

    private String articleCount;

    private Item item;

    public String getArticleCount() {
        return articleCount;
    }

    @XmlElement(name = "ArticleCount")
    public void setArticleCount(String articleCount) {
        this.articleCount = articleCount;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public NewsOutMessage(Map<String, String> requestMap, Item item) {
        super(requestMap);
        this.setMsgType("news");
        this.setArticleCount("1");
        this.item = item;
    }

    public String toString() {
        return "<xml>" +
                "<ToUserName><![CDATA["+getToUserName()+"]]></ToUserName>" +
                "<FromUserName><![CDATA["+getFromUserName()+"]]></FromUserName>" +
                "<CreateTime>"+getCreateTime()+"</CreateTime>" +
                "<MsgType><![CDATA["+getMsgType()+"]]></MsgType>" +
                "<ArticleCount><![CDATA["+getArticleCount()+"]]></ArticleCount>" +
                "<Articles><item><Title><![CDATA["+item.getTitle()+"]]></Title>" +
                "<Description><![CDATA["+item.getDescription()+"]]></Description>" +
                "<PicUrl><![CDATA["+item.getPicUrl()+"]]></PicUrl>" +
                "<Url><![CDATA["+item.getUrl()+"]]></Url></item></Articles>" +
                "</xml>";
    }
}
