package com.lpj.wxgzhh.domain.dto;

import com.lpj.wxgzhh.domain.StoreClassify;
import com.lpj.wxgzhh.domain.StoreCommodity;
import lombok.Data;

import java.util.ArrayList;

//@Data
public class HomeDto {
    // 轮播图
    private ArrayList<StoreCommodity> slideShows;
    // 分类
    private ArrayList<StoreClassify> classify;
    // 爆款
    private ArrayList<StoreCommodity> faddish;
    // 好物
    private ArrayList<StoreCommodity>  hotSales;

    public ArrayList<StoreCommodity> getSlideShows() {
        return slideShows;
    }

    public void setSlideShows(ArrayList<StoreCommodity> slideShows) {
        this.slideShows = slideShows;
    }

    public ArrayList<StoreClassify> getClassify() {
        return classify;
    }

    public void setClassify(ArrayList<StoreClassify> classify) {
        this.classify = classify;
    }

    public ArrayList<StoreCommodity> getFaddish() {
        return faddish;
    }

    public void setFaddish(ArrayList<StoreCommodity> faddish) {
        this.faddish = faddish;
    }

    public ArrayList<StoreCommodity> getHotSales() {
        return hotSales;
    }

    public void setHotSales(ArrayList<StoreCommodity> hotSales) {
        this.hotSales = hotSales;
    }

    @Override
    public String toString() {
        return "HomeDto{" +
                "slideShows=" + slideShows +
                ", classify=" + classify +
                ", faddish=" + faddish +
                ", hotSales=" + hotSales +
                '}';
    }
}
