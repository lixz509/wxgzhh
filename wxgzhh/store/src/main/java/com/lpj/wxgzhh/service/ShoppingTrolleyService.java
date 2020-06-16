package com.lpj.wxgzhh.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lpj.wxgzhh.domain.StoreCommodity;
import com.lpj.wxgzhh.domain.StoreOrder;
import com.lpj.wxgzhh.domain.StoreShoppingTrolley;
import com.lpj.wxgzhh.domain.dto.ShoppingTrolleyDto;
import com.lpj.wxgzhh.repository.CommodityRepository;
import com.lpj.wxgzhh.repository.OrderRepository;
import com.lpj.wxgzhh.repository.ShoppingTrolleyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;

import static com.lpj.wxgzhh.domain.StoreOrder.orderState.IS_PAYMENT;

@Service
public class ShoppingTrolleyService {


    @Autowired
    private ShoppingTrolleyRepository STR;

    @Autowired
    private CommodityRepository CR;

    @Autowired
    private OrderRepository OR;

    // 根据用户id，查询相应购物车信息
    public String shoppingTrolleyShow(String userId){
        ArrayList<ShoppingTrolleyDto> shoppingTrolleyDto=new ArrayList<>();
        ArrayList<StoreShoppingTrolley> storeShoppingTrolleys=STR.findShoppingTrolleyByUserId(userId);
        for (StoreShoppingTrolley s:storeShoppingTrolleys){
            ShoppingTrolleyDto std=new ShoppingTrolleyDto();
            StoreCommodity commodity=CR.findByCommodityId(s.getCommodityId());
            std.setQuantity(s.getPurchaseQuantity());
            std.setCommodityName(commodity.getCommodityName());
            std.setShowUrl(commodity.getShowUrl());
            std.setPrice(commodity.getPrice());
            std.setShoppingTrolleyId(s.getShoppingTrolleyId());
            shoppingTrolleyDto.add(std);
        }
        String json= JSON.toJSONString(shoppingTrolleyDto, SerializerFeature.DisableCircularReferenceDetect);
        return json;
    };

    // 根据购物车id，修改相应数量
    public void shoppingTrolleyNum(String shoppingTrolleyId,String num){
        STR.saveShoppingTrolleyNumById(shoppingTrolleyId,num);
    }

    // 根据购物车id，用户id，商品id，数量，新增一个状态为未付款的订单，并将该商品从购物车列表中删除
    public  String savePaymentOrder(String shoppingTrolleyId){
        StoreShoppingTrolley shoppingTrolley=STR.findByShoppingTrolleyId(shoppingTrolleyId);
        StoreOrder order=new StoreOrder();
        order.setOrderState(IS_PAYMENT);
        order.setUserId(shoppingTrolley.getUserId());
        order.setCommodityId(shoppingTrolley.getCommodityId());
        order.setPurchaseQuantity(shoppingTrolley.getPurchaseQuantity());
        order.setOrderTime(new Date());
        int price= Double.valueOf(shoppingTrolley.getPrice()).intValue()*Double.valueOf(shoppingTrolley
                .getPurchaseQuantity()).intValue();
        order.setTotalPrice(String.valueOf(price));
        // 生成一个订单并获取它的id
        StoreOrder orderId=OR.save(order);
        String json= JSON.toJSONString(orderId.getOrderId(),SerializerFeature.DisableCircularReferenceDetect);
        // 根据购物车id删除信息
        STR.deleteByShoppingTrolleyId(shoppingTrolleyId);
        return json;
    }
    // 根据购物车id,删除该购物车信息
    public void deleteShoppingTrolley(String shoppingTrolleyId) {
        STR.deleteByShoppingTrolleyId(shoppingTrolleyId);
    }
}
