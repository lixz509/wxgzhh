package com.lpj.wxgzhh.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity // 表示一个JPA的实体
@Table(name="store_order") // 指定表名，若不指定，默认表名为类名
public class StoreOrder {

    public static enum orderStatus{
        // 待付款
        IS_PAYMENT,
        // 待发货
        IS_SHIPMENTS,
        // 待收货
        IS_RECEIVING,
        // 待评价
        IS_EVALUATE,
        // 退款/售后
        IS_AFTERMARKET;
    }

    // 订单id
    @Id
    @Column(length = 36 )
    // 使用uuid2的算法生成主键的值，分布式系统里面不能使用自增长作为主键值
    // uuid2生成的主键类型为字符串，长度为36
    @GenericGenerator(name="uuid2",strategy="uuid2")
    @GeneratedValue(generator = "uuid2")
    private String orderId;

    // 商品id
    @Column(length = 36 )
    @JsonProperty("commodity_id")
    private String commodityId;

    // 用户id
    @Column(length = 36 )
    @JsonProperty("user_id")
    private String userId;

    // 订购时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderTime;

    // 总金额
    @JsonProperty("total_price")
    private String totalPrice;

    // 订单状态
    @JsonProperty("order_state")
    @Enumerated(EnumType.STRING)
    private orderStatus orderStatus;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public StoreOrder.orderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(StoreOrder.orderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
