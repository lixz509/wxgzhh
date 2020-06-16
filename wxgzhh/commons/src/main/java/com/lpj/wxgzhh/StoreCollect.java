package com.lpj.wxgzhh;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity // 表示一个JPA的实体
@Table(name="store_collect") // 指定表名，若不指定，默认表名为类名
public class StoreCollect {

    // 收藏id
    @Id
    @Column(length = 36 )
    // 使用uuid2的算法生成主键的值，分布式系统里面不能使用自增长作为主键值
    // uuid2生成的主键类型为字符串，长度为36
    @GenericGenerator(name="uuid2",strategy="uuid2")
    @GeneratedValue(generator = "uuid2")
    private String collectId;

    // 商品id
    @Column(length = 36 )
    @JsonProperty("commodity_id")
    private String commodityId;

    // 用户id
    @Column(length = 36 )
    @JsonProperty("user_id")
    private String userId;

    // 收藏时间
    @Temporal(TemporalType.TIMESTAMP)
    private Date collectTime;

    public String getCollectId() {
        return collectId;
    }

    public void setCollectId(String collectId) {
        this.collectId = collectId;
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

    public Date getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Date collectTime) {
        this.collectTime = collectTime;
    }
}
