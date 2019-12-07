package com.lpj.wxgzhh.domain.supportmessage;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WxcardSupportMessage extends SupportMessage {

    @JsonProperty("wxcard")
    private Wxcard wxcard;

    public WxcardSupportMessage(String toUser,String cardId) {
        super(toUser, "wxcard");
        this.wxcard=new Wxcard();
        this.wxcard.cardId=cardId;
    }

    public static class Wxcard{
        //小程序卡卷
        @JsonProperty("card_id")
        private String cardId;

        public String getCardId() {
            return cardId;
        }

        public void setCardId(String cardId) {
            this.cardId = cardId;
        }
    }
}
