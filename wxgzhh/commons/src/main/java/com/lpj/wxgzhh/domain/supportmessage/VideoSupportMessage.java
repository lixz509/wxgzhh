package com.lpj.wxgzhh.domain.supportmessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VideoSupportMessage extends SupportMessage {

    @JsonProperty("video")
    private Video video;

    public VideoSupportMessage(String toUser,String mediaId,String thumbMediaId,String title,String description) {
        super(toUser, "video");
        this.video=new Video();
        this.video.mediaId=mediaId;
        this.video.thumbMediaId=thumbMediaId;
        this.video.title=title;
        this.video.description=description;
    }

    public static class Video {
        //发送的图片/语音/视频/图文消息（点击跳转到图文消息页）的媒体ID
        @JsonProperty("media_id")
        private String mediaId;

        //缩略图/小程序卡片图片的媒体ID，小程序卡片图片建议大小为520*416
        @JsonProperty("thumb_media_id")
        private String thumbMediaId;

        //图文消息/视频消息/音乐消息/小程序卡片的标题
        @JsonProperty("title")
        private String title;

        //	图文消息/视频消息/音乐消息的描述
        @JsonProperty("description")
        private String description;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }

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
    }
}

