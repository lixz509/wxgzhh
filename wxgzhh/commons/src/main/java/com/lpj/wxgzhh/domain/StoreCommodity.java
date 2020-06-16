package com.lpj.wxgzhh.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity // 表示一个JPA的实体
@Table(name="store_commodity") // 指定表名，若不指定，默认表名为类名
public class StoreCommodity {

    public static enum commodityState{
        // 正常使用状态
        IS_NORMAL,
        // 冻结状态
        IS_FREEZE;
    }

    // 商品id
    @Id
    @Column(length = 36 )
    // 使用uuid2的算法生成主键的值，分布式系统里面不能使用自增长作为主键值
    // uuid2生成的主键类型为字符串，长度为36
    @GenericGenerator(name="uuid2",strategy="uuid2")
    @GeneratedValue(generator = "uuid2")
    private String commodityId;

    // 商品名称
    @JsonProperty("commodity_name")
    private String commodityName;

    // 商品简介
    @JsonProperty("commodity_intro")
    private String commodityIntro;

    // 商品原价格
    @JsonProperty("original_price")
    private String originalPrice;

    // 商品价格
    @JsonProperty("price")
    private String price;

    // 商品折扣
    @JsonProperty("discount")
    private String discount;

    // 商品展示图片
    @JsonProperty("show_url")
    private String showUrl;

    // 商品详情图片
    @JsonProperty("particulars_url")
    private String particularsUrl;

    // 分类id
    @Column(length = 36 )
    @JsonProperty("classify_id")
    private String classifyId;

    // 商品月销售
    @JsonProperty("Monthly_sales")
    private String MonthlySales ;


    // 商品数量
    @JsonProperty("commodity_num")
    private String commodityNum;


    // 商品剩余数量
    @JsonProperty("commodity_surplus")
    private String commoditySurplus;

    // 商品状态
    @JsonProperty("commodity_state")
    @Enumerated(EnumType.STRING)
    private commodityState commodityState;

    // 商品轮播图地址
    @JsonProperty("slideshow_url")
    private String slideshowUrl;

    public String getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(String commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getCommodityIntro() {
        return commodityIntro;
    }

    public void setCommodityIntro(String commodityIntro) {
        this.commodityIntro = commodityIntro;
    }

    public String getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(String originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }

    public String getParticularsUrl() {
        return particularsUrl;
    }

    public void setParticularsUrl(String particularsUrl) {
        this.particularsUrl = particularsUrl;
    }

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getMonthlySales() {
        return MonthlySales;
    }

    public void setMonthlySales(String monthlySales) {
        MonthlySales = monthlySales;
    }

    public String getCommodityNum() {
        return commodityNum;
    }

    public void setCommodityNum(String commodityNum) {
        this.commodityNum = commodityNum;
    }

    public String getCommoditySurplus() {
        return commoditySurplus;
    }

    public void setCommoditySurplus(String commoditySurplus) {
        this.commoditySurplus = commoditySurplus;
    }

    public StoreCommodity.commodityState getCommodityState() {
        return commodityState;
    }

    public void setCommodityState(StoreCommodity.commodityState commodityState) {
        this.commodityState = commodityState;
    }

    public String getSlideshowUrl() {
        return slideshowUrl;
    }

    public void setSlideshowUrl(String slideshowUrl) {
        this.slideshowUrl = slideshowUrl;
    }

    public String toString() {
        return "StoreCommodity{" +
                "commodityId='" + commodityId + '\'' +
                ", commodityName='" + commodityName + '\'' +
                ", commodityIntro='" + commodityIntro + '\'' +
                ", originalPrice='" + originalPrice + '\'' +
                ", price='" + price + '\'' +
                ", discount='" + discount + '\'' +
                ", showUrl='" + showUrl + '\'' +
                ", particularsUrl='" + particularsUrl + '\'' +
                ", classifyId='" + classifyId + '\'' +
                ", MonthlySales='" + MonthlySales + '\'' +
                ", commodityNum='" + commodityNum + '\'' +
                ", commoditySurplus='" + commoditySurplus + '\'' +
                ", commodityState=" + commodityState +
                ", slideshowUrl='" + slideshowUrl + '\'' +
                '}';
    }
}
