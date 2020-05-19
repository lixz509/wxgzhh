package com.lpj.wxgzhh.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity // 表示一个JPA的实体
@Table(name="store_dialogue") // 指定表名，若不指定，默认表名为类名
public class StoreDialogue {
    // 会话id
    @Id
    @Column(length = 36 )
    // 使用uuid2的算法生成主键的值，分布式系统里面不能使用自增长作为主键值
    // uuid2生成的主键类型为字符串，长度为36
    @GenericGenerator(name="uuid2",strategy="uuid2")
    @GeneratedValue(generator = "uuid2")
    private String dialogueId;

    // 发送人id
    @Column(length = 36 )
    @JsonProperty("send_id")
    private String sendId;

    // 接收人id
    @Column(length = 36 )
    @JsonProperty("reception_id")
    private String receptionId;

    // 发送时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date dialogueTime;

    // 文本内容
    @JsonProperty("dialogue_text")
    private String dialogueText;

    public String getDialogueId() {
        return dialogueId;
    }

    public void setDialogueId(String dialogueId) {
        this.dialogueId = dialogueId;
    }

    public String getSendId() {
        return sendId;
    }

    public void setSendId(String sendId) {
        this.sendId = sendId;
    }

    public String getReceptionId() {
        return receptionId;
    }

    public void setReceptionId(String receptionId) {
        this.receptionId = receptionId;
    }

    public Date getDialogueTime() {
        return dialogueTime;
    }

    public void setDialogueTime(Date dialogueTime) {
        this.dialogueTime = dialogueTime;
    }

    public String getDialogueText() {
        return dialogueText;
    }

    public void setDialogueText(String dialogueText) {
        this.dialogueText = dialogueText;
    }
}
