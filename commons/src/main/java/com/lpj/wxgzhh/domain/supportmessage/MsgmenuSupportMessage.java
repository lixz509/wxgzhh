package com.lpj.wxgzhh.domain.supportmessage;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MsgmenuSupportMessage extends SupportMessage {

    @JsonProperty("msgmenu")
    private Msgmenu msgmenu;

    public MsgmenuSupportMessage(String toUser,String headContent,String tailContent,String id1,String content1,String id2,String content2) {
        super(toUser, "msgmenu");
        this.msgmenu=new Msgmenu();
        this.msgmenu.headContent=headContent;
        this.msgmenu.tailContent=tailContent;
        Msgmenu.Lists lists1=new Msgmenu.Lists(id1,content1);
        Msgmenu.Lists lists2=new Msgmenu.Lists(id2,content2);
        this.msgmenu.list.add(lists1);
        this.msgmenu.list.add(lists2);
    }

    public static class Msgmenu{

        //菜单消息头部
        @JsonProperty("head_content")
        private String headContent;

        //菜单消息选项
        @JsonProperty("list")
        private List<Lists> list=new ArrayList<Lists>();

        //菜单消息尾部
        @JsonProperty("tail_content")
        private String tailContent;

        public static class Lists{

            @JsonProperty("id")
            private String id;

            @JsonProperty("content")
            private String content;

            public Lists(String id, String content) {
                this.id = id;
                this.content = content;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }

        public String getHeadContent() {
            return headContent;
        }

        public void setHeadContent(String headContent) {
            this.headContent = headContent;
        }

        public String getTailContent() {
            return tailContent;
        }

        public void setTailContent(String tailContent) {
            this.tailContent = tailContent;
        }

        public List<Lists> getList() {
            return list;
        }

        public void setList(List<Lists> list) {
            this.list = list;
        }
    }

    public Msgmenu getMsgmenu() {
        return msgmenu;
    }

    public void setMsgmenu(Msgmenu msgmenu) {
        this.msgmenu = msgmenu;
    }
}
