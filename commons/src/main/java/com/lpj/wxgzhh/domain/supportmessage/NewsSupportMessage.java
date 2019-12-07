package com.lpj.wxgzhh.domain.supportmessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NewsSupportMessage extends SupportMessage {

    @JsonProperty("news")
    private News news;

    public NewsSupportMessage(String toUser,String title,String description,String url,String picurl) {
        super(toUser, "news");
        this.news =new News();
        this.news.articles =new News.Articles();
        this.news.articles.title=title;
        this.news.articles.description=description;
        this.news.articles.url=url;
        this.news.articles.picurl=picurl;
    }

    public static class News{

        @JsonProperty("articles")
        private Articles articles;

        public static class Articles{
            //图文消息/视频消息/音乐消息/小程序卡片的标题
            @JsonProperty("title")
            private String title;

            //图文消息/视频消息/音乐消息的描述
            @JsonProperty("description")
            private String description;

            //图文消息被点击后跳转的链接
            @JsonProperty("url")
            private String url;

            //图文消息的图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
            @JsonProperty("picurl")
            private String picurl;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getPicurl() {
                return picurl;
            }

            public void setPicurl(String picurl) {
                this.picurl = picurl;
            }
        }
    }
}
