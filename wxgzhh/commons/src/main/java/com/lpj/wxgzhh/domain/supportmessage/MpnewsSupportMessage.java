package com.lpj.wxgzhh.domain.supportmessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MpnewsSupportMessage extends SupportMessage {

    @JsonProperty("mpnews")
    private Mpnews mpnews;

    public MpnewsSupportMessage(String toUser,String mediaId) {
        super(toUser,"mpnews");
        this.mpnews=new Mpnews();
        this.mpnews.mediaId=mediaId;
    }

    public static class Mpnews {
        //发送的图片/语音/视频/图文消息（点击跳转到图文消息页）的媒体ID
        @JsonProperty("media_id")
        private String mediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }
    }
}
