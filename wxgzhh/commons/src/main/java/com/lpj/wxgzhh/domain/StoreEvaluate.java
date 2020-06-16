package com.lpj.wxgzhh.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity // 表示一个JPA的实体
@Table(name="store_evaluate") // 指定表名，若不指定，默认表名为类名
public class StoreEvaluate {

    // 评论id
    @Id
    @Column(length = 36 )
    // 使用uuid2的算法生成主键的值，分布式系统里面不能使用自增长作为主键值
    // uuid2生成的主键类型为字符串，长度为36
    @GenericGenerator(name="uuid2",strategy="uuid2")
    @GeneratedValue(generator = "uuid2")
    private String evaluateId;

    // 商品id
    @Column(length = 36 )
    @JsonProperty("commodity_id")
    private String commodityId;

    // 用户id
    @Column(length = 36 )
    @JsonProperty("user_id")
    private String userId;

    // 用户名
    @Column(length = 36 )
    @JsonProperty("user_name")
    private String userName;

    // 订单id
    @Column(length = 36 )
    @JsonProperty("order_id")
    private String orderId;

    // 评论内容
    @JsonProperty("evaluate_text")
    private String evaluateText;

    // 评论时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date evaluateTime;

    // 评级
    @JsonProperty("rating")
    private String rating;

    public String getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(String evaluateId) {
        this.evaluateId = evaluateId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getEvaluateText() {
        return evaluateText;
    }

    public void setEvaluateText(String evaluateText) {
        this.evaluateText = evaluateText;
    }

    public Date getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(Date evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
