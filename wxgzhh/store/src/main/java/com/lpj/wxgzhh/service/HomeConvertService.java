package com.lpj.wxgzhh.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lpj.wxgzhh.domain.StoreClassify;
import com.lpj.wxgzhh.domain.StoreCommodity;
import com.lpj.wxgzhh.domain.StoreHotSale;
import com.lpj.wxgzhh.domain.dto.HomeDto;
import com.lpj.wxgzhh.repository.ClassifyRepository;
import com.lpj.wxgzhh.repository.CommodityRepository;
import com.lpj.wxgzhh.repository.HotSaleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static com.lpj.wxgzhh.domain.StoreHotSale.hotSaleState.IS_HOTSALE;
import static com.lpj.wxgzhh.domain.StoreHotSale.hotSaleState.IS_SLIDESHOW;

@Service
public class HomeConvertService {

    private static final Logger LOG = LoggerFactory.getLogger(HomeConvertService.class);

    @Autowired
    private HotSaleRepository HSR;

    @Autowired
    private CommodityRepository CR;

    @Autowired
    private ClassifyRepository CLR;

    @Bean
    public String homeShow(){
//        String json= JSON.toJSONString(s);
//        JSONArray jsonArray = JSONArray.fromArray(new ArrayList[]{slideshowCommodity});
        // Dto用于存放发往前端的数据
        HomeDto homeDto=new HomeDto();
        // 查询轮播图
        ArrayList<StoreHotSale> slideShows=HSR.findByHotSaleState(IS_SLIDESHOW);
        ArrayList<StoreCommodity> slideShowsCommodity=new ArrayList<>();
        // 查询精选商品
        ArrayList<StoreHotSale> hotSales=HSR.findByHotSaleState(IS_HOTSALE);
        ArrayList<StoreCommodity> hotSalesCommodity=new ArrayList<>();
        // 查询热销商品
        ArrayList<StoreCommodity> faddish=CR.findBySales();
        // 查询分类
        ArrayList<StoreClassify> classify=CLR.findAll();
        for (StoreHotSale s :slideShows){
            slideShowsCommodity.add(CR.findByCommodityId(s.getCommodityId()));
        };
        for (StoreHotSale h :hotSales){
            hotSalesCommodity.add(CR.findByCommodityId(h.getCommodityId()));
        };
        homeDto.setSlideShows(slideShowsCommodity);
        homeDto.setHotSales(hotSalesCommodity);
        homeDto.setFaddish(faddish);
        homeDto.setClassify(classify);
        // SerializerFeature.DisableCircularReferenceDetect表示加载相同数据时不折叠
        String json= JSON.toJSONString(homeDto,SerializerFeature.DisableCircularReferenceDetect);
        return json;
    }

}
