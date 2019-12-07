package com.lpj.wxgzhh.domain.supportmessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImageSupportMessage extends SupportMessage  {

    @JsonProperty("image")
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public ImageSupportMessage(String toUser, String mediaId) {
        super(toUser, "image");
        this.image=new Image();
        this.image.mediaId=mediaId;
    }

    public static class Image {
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
