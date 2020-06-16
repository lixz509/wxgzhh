package com.lpj.wxgzhh.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lpj.wxgzhh.domain.StoreCommodity;
import com.lpj.wxgzhh.repository.CommodityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SearchService {

    private static final Logger LOG = LoggerFactory.getLogger(SearchService.class);

    @Autowired
    private CommodityRepository CR;

    // 根据商品名称，排序方式，查找商品并排序
    public String findCommodity(String commodityName,String sort){
        ArrayList<StoreCommodity> storeCommodities = new ArrayList<>();
        if(sort.equals("1")){
            storeCommodities=CR.findByNameSales(commodityName);
        }else if(sort.equals("2")){
            storeCommodities=CR.findByNamePriceAsc(commodityName);
        }else if(sort.equals("3")){
            storeCommodities=CR.findByNamePriceDesc(commodityName);
        }
        String json= JSON.toJSONString(storeCommodities, SerializerFeature.DisableCircularReferenceDetect);
        return json;
    }
}
