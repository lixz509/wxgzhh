package com.lpj.wxgzhh.domain.supportmessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class SupportMessage {

    @JsonProperty("touser")
    private String toUser;

    @JsonProperty("msgtype")
    private String messageType;

    public String getToUser() {
        return toUser;
    }

    public void setToUser(String toUser) {
        this.toUser = toUser;
    }

    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public SupportMessage(String toUser, String messageType) {
        this.toUser = toUser;
        this.messageType = messageType;
    }
}
