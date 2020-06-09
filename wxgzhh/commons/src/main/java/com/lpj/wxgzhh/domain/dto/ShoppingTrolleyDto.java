package com.lpj.wxgzhh.domain.dto;


import com.lpj.wxgzhh.domain.StoreCommodity;

import java.util.ArrayList;

public class ShoppingTrolleyDto {
    private String commodityName;
    private String showUrl;
    private String price;
    private String quantity;
    private String shoppingTrolleyId;

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getShowUrl() {
        return showUrl;
    }

    public void setShowUrl(String showUrl) {
        this.showUrl = showUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getShoppingTrolleyId() {
        return shoppingTrolleyId;
    }

    public void setShoppingTrolleyId(String shoppingTrolleyId) {
        this.shoppingTrolleyId = shoppingTrolleyId;
    }
}
