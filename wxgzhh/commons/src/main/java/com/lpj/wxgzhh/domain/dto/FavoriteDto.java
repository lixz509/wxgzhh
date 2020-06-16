package com.lpj.wxgzhh.domain.dto;

import com.lpj.wxgzhh.StoreCollect;
import com.lpj.wxgzhh.domain.StoreCommodity;

public class FavoriteDto {
    StoreCollect storeCollect;
    StoreCommodity storeCommodity;

    public StoreCollect getStoreCollect() {
        return storeCollect;
    }

    public void setStoreCollect(StoreCollect storeCollect) {
        this.storeCollect = storeCollect;
    }

    public StoreCommodity getStoreCommodity() {
        return storeCommodity;
    }

    public void setStoreCommodity(StoreCommodity storeCommodity) {
        this.storeCommodity = storeCommodity;
    }
}
