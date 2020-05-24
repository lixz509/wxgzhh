package com.lpj.wxgzhh.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity // 表示一个JPA的实体
@Table(name="store_logistics") // 指定表名，若不指定，默认表名为类名
public class StoreLogistics {

    public static enum logisticsStatus{
        // 未签收
        IS_UNRECEIPTED,
        // 已签收
        IS_RECEIPTED;
    }

    // 物流id
    @Id
    @Column(length = 36 )
    // 使用uuid2的算法生成主键的值，分布式系统里面不能使用自增长作为主键值
    // uuid2生成的主键类型为字符串，长度为36
    @GenericGenerator(name="uuid2",strategy="uuid2")
    @GeneratedValue(generator = "uuid2")
    private String logisticsId;

    // 发货人id
    @Column(length = 36 )
    @JsonProperty("consigner_id")
    private String consignerId;

    // 接收人id
    @Column(length = 36 )
    @JsonProperty("consignee_id")
    private String consigneeId;

    // 发货地址
    @JsonProperty("ship_address")
    private String shipAddress;

    // 收货地址
    @JsonProperty("shipping_address ")
    private String shippingAddress ;

    // 发货时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date shipTime;

    // 签收时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date shippingTime;

    // 订单状态
    @JsonProperty("logistics_state")
    @Enumerated(EnumType.STRING)
    private logisticsStatus logisticsStatus;


    // 订单id
    @Column(length = 36 )
    @JsonProperty("order_id ")
    private String orderId;

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }

    public String getConsignerId() {
        return consignerId;
    }

    public void setConsignerId(String consignerId) {
        this.consignerId = consignerId;
    }

    public String getConsigneeId() {
        return consigneeId;
    }

    public void setConsigneeId(String consigneeId) {
        this.consigneeId = consigneeId;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }

    public Date getShippingTime() {
        return shippingTime;
    }

    public void setShippingTime(Date shippingTime) {
        this.shippingTime = shippingTime;
    }

    public StoreLogistics.logisticsStatus getLogisticsStatus() {
        return logisticsStatus;
    }

    public void setLogisticsStatus(StoreLogistics.logisticsStatus logisticsStatus) {
        this.logisticsStatus = logisticsStatus;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
