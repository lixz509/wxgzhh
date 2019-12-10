package com.lpj.wxgzhh.domain.supportmessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VoiceSupportMessage extends SupportMessage {

    @JsonProperty("voice")
    private Voice voice;

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    public VoiceSupportMessage(String toUser, String mediaId) {
        super(toUser, "voice");
        this.voice=new Voice();
        this.voice.mediaId=mediaId;
    }
    public static class Voice {
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
