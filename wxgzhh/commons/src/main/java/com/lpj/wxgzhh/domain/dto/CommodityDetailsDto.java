package com.lpj.wxgzhh.domain.dto;

import com.lpj.wxgzhh.domain.StoreEvaluate;

import java.util.ArrayList;
import java.util.List;

public class CommodityDetailsDto {

    // 商品id
    private String commodityId;

    // 商品名称
    private String commodityName;

    // 商品简介
    private String commodityIntro;

    // 商品原价格
    private String originalPrice;

    // 商品价格
    private String price;

    // 商品折扣
    private String discount;

    // 商品详情图片
    private List<String> particularsUrl;

    // 商品月销售
    private String MonthlySales;

    // 商品数量
    private String commodityNum;

    // 商品剩余数量
    private String commoditySurplus;

    // 商品轮播图地址
    private List<String> slideshowUrl;

    // 商品最后一条评论
    private StoreEvaluate storeEvaluate;

    // 是否收藏
    private String collect;

    // 是否加入购物车
    private String shoppingTrolley;

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

    public List<String> getParticularsUrl() {
        return particularsUrl;
    }

    public void setParticularsUrl(List<String> particularsUrl) {
        this.particularsUrl = particularsUrl;
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

    public List<String> getSlideshowUrl() {
        return slideshowUrl;
    }

    public void setSlideshowUrl(List<String> slideshowUrl) {
        this.slideshowUrl = slideshowUrl;
    }

    public StoreEvaluate getStoreEvaluate() {
        return storeEvaluate;
    }

    public void setStoreEvaluate(StoreEvaluate storeEvaluate) {
        this.storeEvaluate = storeEvaluate;
    }

    public String getCollect() {
        return collect;
    }

    public void setCollect(String collect) {
        this.collect = collect;
    }

    public String getShoppingTrolley() {
        return shoppingTrolley;
    }

    public void setShoppingTrolley(String shoppingTrolley) {
        this.shoppingTrolley = shoppingTrolley;
    }
}
