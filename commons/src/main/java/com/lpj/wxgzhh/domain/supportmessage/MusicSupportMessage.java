package com.lpj.wxgzhh.domain.supportmessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MusicSupportMessage extends SupportMessage {

    @JsonProperty("music")
    private Music music;

    public MusicSupportMessage(String toUser,String mediaId,String description,String musicurl,String hqmusicurl,String thumbMediaId) {
        super(toUser, "music");
        this.music=new Music();
        this.music.mediaId=mediaId;
        this.music.description=description;
        this.music.musicurl=musicurl;
        this.music.hqmusicurl=hqmusicurl;
        this.music.thumbMediaId=thumbMediaId;
    }
    public static class Music{
        //发送的图片/语音/视频/图文消息（点击跳转到图文消息页）的媒体ID
        @JsonProperty("media_id")
        private String mediaId;

        //图文消息/视频消息/音乐消息的描述
        @JsonProperty("description")
        private String description;

        //音乐链接
        @JsonProperty("musicurl")
        private String musicurl;

        //高品质音乐链接，wifi环境优先使用该链接播放音乐
        @JsonProperty("hqmusicurl")
        private String hqmusicurl;

        //缩略图/小程序卡片图片的媒体ID，小程序卡片图片建议大小为520*416
        @JsonProperty("thumb_media_id")
        private String thumbMediaId;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getMusicurl() {
            return musicurl;
        }

        public void setMusicurl(String musicurl) {
            this.musicurl = musicurl;
        }

        public String getHqmusicurl() {
            return hqmusicurl;
        }

        public void setHqmusicurl(String hqmusicurl) {
            this.hqmusicurl = hqmusicurl;
        }

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }
    }
}
