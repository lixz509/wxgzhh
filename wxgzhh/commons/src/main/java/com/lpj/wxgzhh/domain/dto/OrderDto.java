package com.lpj.wxgzhh.domain.dto;

import com.lpj.wxgzhh.domain.StoreCommodity;
import com.lpj.wxgzhh.domain.StoreOrder;

public class OrderDto {

    // 订单信息
    StoreOrder storeOrder;

    // 商品信息
    StoreCommodity storeCommodity;

    public StoreOrder getStoreOrder() {
        return storeOrder;
    }

    public void setStoreOrder(StoreOrder storeOrder) {
        this.storeOrder = storeOrder;
    }

    public StoreCommodity getStoreCommodity() {
        return storeCommodity;
    }

    public void setStoreCommodity(StoreCommodity storeCommodity) {
        this.storeCommodity = storeCommodity;
    }
}
