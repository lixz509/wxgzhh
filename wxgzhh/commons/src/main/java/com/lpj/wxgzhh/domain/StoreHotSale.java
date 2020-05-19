package com.lpj.wxgzhh.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity // 表示一个JPA的实体
@Table(name="store_hot_sale") // 指定表名，若不指定，默认表名为类名
public class StoreHotSale {

    public static enum hotSaleStatus{
        // 轮播图
        IS_SLIDESHOW,
        // 好物
        IS_HOTSALE,
        // 过期
        IS_OVERDUE;
    }

    // 好物id
    @Id
    @Column(length = 36 )
    // 使用uuid2的算法生成主键的值，分布式系统里面不能使用自增长作为主键值
    // uuid2生成的主键类型为字符串，长度为36
    @GenericGenerator(name="uuid2",strategy="uuid2")
    @GeneratedValue(generator = "uuid2")
    private String hotSaleId;

    // 商品id
    @Column(length = 36 )
    @JsonProperty("commodity_id")
    private String commodityId;

    // 好物时间
    @JsonProperty("hot_sale_time")
    private String hotSaleTime;

    // 好物状态
    @JsonProperty("hot_sale_state")
    @Enumerated(EnumType.STRING)
    private hotSaleStatus hotSaleStatus;

    public String getHotSaleId() {
        return hotSaleId;
    }

    public void setHotSaleId(String hotSaleId) {
        this.hotSaleId = hotSaleId;
    }

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getHotSaleTime() {
        return hotSaleTime;
    }

    public void setHotSaleTime(String hotSaleTime) {
        this.hotSaleTime = hotSaleTime;
    }

    public StoreHotSale.hotSaleStatus getHotSaleStatus() {
        return hotSaleStatus;
    }

    public void setHotSaleStatus(StoreHotSale.hotSaleStatus hotSaleStatus) {
        this.hotSaleStatus = hotSaleStatus;
    }
}
