package com.lpj.wxgzhh.domain.supportmessage;

public class TextSupportMessage extends SupportMessage {

    private TextContent text;


    public TextContent getText() {
        return text;
    }

    public void setText(TextContent text) {
        this.text = text;
    }

    public static class TextContent {
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
        this.text=new TextContent();
        this.text.content = content;
    }
}
