package com.lpj.wxgzhh.domain.supportmessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TextSupportMessage extends SupportMessage {

    @JsonProperty("text")
    private Text text;

    public Text getText() {
        return text;
    }

    public void setText(Text text) {
        this.text = text;
    }

    public static class Text {
        //文本消息内容
        @JsonProperty("content")
        private String content;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }


    public TextSupportMessage(String toUser,String content) {
        super(toUser, "text");
        this.text=new Text();
        this.text.content = content;
    }

}
