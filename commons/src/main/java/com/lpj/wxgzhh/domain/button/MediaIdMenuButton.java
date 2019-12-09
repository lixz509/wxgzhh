package com.lpj.wxgzhh.domain.button;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MediaIdMenuButton extends MenuButton {
    private String type;

    @JsonProperty("media_id")
    private String mediaId;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public MediaIdMenuButton(String name, String mediaId) {
        super(name);
        this.type = "media_id";
        this.mediaId = mediaId;
    }
}
