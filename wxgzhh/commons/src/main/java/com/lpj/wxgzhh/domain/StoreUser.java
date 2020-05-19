package com.lpj.wxgzhh.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity // 表示一个JPA的实体
@Table(name="store_user") // 指定表名，若不指定，默认表名为类名
public class StoreUser {

    public static enum userStatus{
        // 正常使用状态
        IS_NORMAL,
        // 冻结状态
        IS_FREEZE;
    }

    // 用户的id
    @Id
    @Column(length = 36 )
    // 使用uuid2的算法生成主键的值，分布式系统里面不能使用自增长作为主键值
    // uuid2生成的主键类型为字符串，长度为36
    @GenericGenerator(name="uuid2",strategy="uuid2")
    @GeneratedValue(generator = "uuid2")
    private String userId;

    // 微信id
    @Column(length = 36)
    @JsonProperty("id")
    private String id;

    // 用户名
    @JsonProperty("user_name")
    private String userName;

    // 密码
    @JsonProperty("password")
    private String password;

    // 地址
    @JsonProperty("location")
    private String location;

    // 头像
    @JsonProperty("portrait")
    private String portrait;

    // 余额
    @JsonProperty("balance")
    private String balance;

    // 用户状态
    @JsonProperty("user_state")
    @Enumerated(EnumType.STRING)
    private userStatus userState;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public userStatus getUserState() {
        return userState;
    }

    public void setUserState(userStatus userState) {
        this.userState = userState;
    }
}
