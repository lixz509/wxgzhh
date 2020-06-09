package com.lpj.wxgzhh.domain.dto;

import java.util.ArrayList;

public class ChatListDto {

    private ArrayList<ChatDto> chatDtos;

    public static class ChatDto{
        private int unreadNum;
        private String dialogueUserId;
        private String lastMessage;
        private String dialogueName;
        private String time;

        public String getDialogueUserId() {
            return dialogueUserId;
        }

        public void setDialogueUserId(String dialogueUserId) {
            this.dialogueUserId = dialogueUserId;
        }

        public int getUnreadNum() {
            return unreadNum;
        }

        public void setUnreadNum(int unreadNum) {
            this.unreadNum = unreadNum;
        }

        public String getLastMessage() {
            return lastMessage;
        }

        public void setLastMessage(String lastMessage) {
            this.lastMessage = lastMessage;
        }

        public String getDialogueName() {
            return dialogueName;
        }

        public void setDialogueName(String dialogueName) {
            this.dialogueName = dialogueName;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String toString() {
            return "ChatDto{" +
                    "unreadNum=" + unreadNum +
                    ", dialogueUserId='" + dialogueUserId + '\'' +
                    ", lastMessage='" + lastMessage + '\'' +
                    ", dialogueName='" + dialogueName + '\'' +
                    ", time='" + time + '\'' +
                    '}';
        }
    }

    public ArrayList<ChatDto> getChatDtos() {
        return chatDtos;
    }

    public void setChatDtos(ArrayList<ChatDto> chatDtos) {
        this.chatDtos = chatDtos;
    }
}
