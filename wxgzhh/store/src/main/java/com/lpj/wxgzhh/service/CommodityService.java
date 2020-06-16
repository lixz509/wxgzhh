package com.lpj.wxgzhh.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lpj.wxgzhh.StoreCollect;
import com.lpj.wxgzhh.domain.StoreCommodity;
import com.lpj.wxgzhh.domain.StoreEvaluate;
import com.lpj.wxgzhh.domain.StoreOrder;
import com.lpj.wxgzhh.domain.StoreShoppingTrolley;
import com.lpj.wxgzhh.domain.dto.CommodityDetailsDto;
import com.lpj.wxgzhh.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.lpj.wxgzhh.domain.StoreOrder.orderState.IS_PAYMENT;

@Service
public class CommodityService {

    private static final Logger LOG = LoggerFactory.getLogger(CommodityService.class);

    @Autowired
    private CommodityRepository CR;

    @Autowired
    private EvaluateRepository ER;

    @Autowired
    private ShoppingTrolleyRepository STR;

    @Autowired
    private CollectRepository CR2;

    @Autowired
    private OrderRepository OR;

    // 商品详情展示
    public String commodityDetailsShow(String userId,String commodityId){
        // 建立返回给前端的dto
        CommodityDetailsDto commodityDetailsDto=new CommodityDetailsDto();
        // 查询商品信息
        StoreCommodity storeCommodity=CR.findByCommodityId(commodityId);
        // 将图片地址转换为数组
        String slideshowUrls=storeCommodity.getSlideshowUrl();
        List<String> slideshowUrl= Arrays.asList(slideshowUrls.split("\\s*;\\s*"));
        String particularsUrls=storeCommodity.getParticularsUrl();
        List<String> particularsUrl= Arrays.asList(particularsUrls.split("\\s*;\\s*"));
        // 查询该商品最后一条评论
        StoreEvaluate storeEvaluate=ER.findByCommodityId(commodityId);
        // 查询是否已加入购物车
        StoreShoppingTrolley storeShoppingTrolley=STR.findByUserIdAndCommodityId(userId,commodityId);
        if (storeShoppingTrolley == null){
            commodityDetailsDto.setShoppingTrolley("no");
        }else {
            commodityDetailsDto.setShoppingTrolley("yes");
        }
        // 查询是否加入收藏
        StoreCollect storeCollect=CR2.findByUserIdAndCommodityId(userId,commodityId);
        if (storeCollect == null){
            commodityDetailsDto.setCollect("no");
        }else {
            commodityDetailsDto.setCollect("yes");
        }
        // 填充
        commodityDetailsDto.setCommodityId(storeCommodity.getCommodityId());
        commodityDetailsDto.setCommodityName(storeCommodity.getCommodityName());
        commodityDetailsDto.setCommodityIntro(storeCommodity.getCommodityIntro());
        commodityDetailsDto.setOriginalPrice(storeCommodity.getOriginalPrice());
        commodityDetailsDto.setPrice(storeCommodity.getPrice());
        commodityDetailsDto.setDiscount(storeCommodity.getDiscount());
        commodityDetailsDto.setParticularsUrl(particularsUrl);
        commodityDetailsDto.setMonthlySales(storeCommodity.getMonthlySales());
        commodityDetailsDto.setCommodityNum(storeCommodity.getCommodityNum());
        commodityDetailsDto.setCommoditySurplus(storeCommodity.getCommoditySurplus());
        commodityDetailsDto.setSlideshowUrl(slideshowUrl);
        commodityDetailsDto.setStoreEvaluate(storeEvaluate);
        String json= JSON.toJSONString(commodityDetailsDto, SerializerFeature.DisableCircularReferenceDetect);
//        System.out.println(json);
        return json;
    }

    // 根据用户id，商品id，添加到收藏
    public void addCollect(String userId,String commodityId){
        StoreCollect storeCollect=new StoreCollect();
        storeCollect.setUserId(userId);
        storeCollect.setCommodityId(commodityId);
        storeCollect.setCollectTime(new Date());
        CR2.save(storeCollect);
    }

    // 根据用户id，商品id，删除收藏
    public void deleteCollect(String userId,String commodityId){
        CR2.deleteByUserIdAndCommodityId(userId,commodityId);
    }

    // 根据用户id，商品id，添加到收藏
    public void addShoppingTrolley(String userId,String commodityId){
        StoreShoppingTrolley storeShoppingTrolley = new StoreShoppingTrolley();
        storeShoppingTrolley.setUserId(userId);
        storeShoppingTrolley.setCommodityId(commodityId);
        storeShoppingTrolley.setPurchaseQuantity("1");
        storeShoppingTrolley.setPrice(CR.findByCommodityId(commodityId).getPrice());
        STR.save(storeShoppingTrolley);
    }

    // 根据用户id，商品id，生成一个未支付的订单
    public String addOrder(String userId, String commodityId) {
        StoreOrder storeOrder=new StoreOrder();
        storeOrder.setUserId(userId);
        storeOrder.setCommodityId(commodityId);
        storeOrder.setOrderTime(new Date());
        storeOrder.setTotalPrice(CR.findByCommodityId(commodityId).getPrice());
        storeOrder.setOrderState(IS_PAYMENT);
        storeOrder.setPurchaseQuantity("1");
        String orderId=OR.save(storeOrder).getOrderId();
        String json= JSON.toJSONString(orderId,SerializerFeature.DisableCircularReferenceDetect);
        return json;
    }
}
