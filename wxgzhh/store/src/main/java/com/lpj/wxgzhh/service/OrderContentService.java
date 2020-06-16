package com.lpj.wxgzhh.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lpj.wxgzhh.domain.StoreCommodity;
import com.lpj.wxgzhh.domain.StoreOrder;
import com.lpj.wxgzhh.domain.StoreUser;
import com.lpj.wxgzhh.domain.dto.OrderDto;
import com.lpj.wxgzhh.repository.CommodityRepository;
import com.lpj.wxgzhh.repository.OrderRepository;
import com.lpj.wxgzhh.repository.StoreUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OrderContentService {

    @Autowired
    private OrderRepository OR;

    @Autowired
    private StoreUserRepository SUR;

    @Autowired
    private CommodityRepository CR;

    // 根据订单id，用户id，判断余额是否大于订单金额，大于则将订单状态改为未发货并扣除相应金额
    public String updateShipmentsOrder(String userId,String orderId){
        int balance=Integer.parseInt(SUR.findByUserId(userId).getBalance());
        int price=Integer.parseInt(OR.findByOrderId(orderId).getTotalPrice());
        if(balance>price){
            OR.saveOrderState(orderId,"IS_SHIPMENTS");
            String newBalance=String.valueOf(balance-price);
            SUR.saveBalance(userId,newBalance);
            return "ok";
        }else {
            return "no";
        }
    }
    // 根据订单id，查询订单信息
    public String findOrderBalance(String orderId){
        String balance=OR.findByOrderId(orderId).getTotalPrice();
        return balance;
    }
    // 根据传用户id，订单类型，查询订单
    public String onOrder(String userId,String sort) {
        ArrayList<OrderDto> orderDtos = new ArrayList<>();
        ArrayList<StoreOrder> storeOrder;
        if (sort.equals("all")) {
            // 根据用户查询订单
            storeOrder = OR.findByUserId(userId);
        }else {
            // 根据用户查,订单状态询订单
            storeOrder = OR.findByOrderIdAndState(userId,sort);
        };
        for (StoreOrder s : storeOrder) {
            OrderDto orderDto = new OrderDto();
            // 根据订单中的商品id查询商品
            StoreCommodity storeCommodity = CR.findByCommodityId(s.getCommodityId());
            orderDto.setStoreOrder(s);
            orderDto.setStoreCommodity(storeCommodity);
            orderDtos.add(orderDto);
        }
        String json= JSON.toJSONString(orderDtos, SerializerFeature.DisableCircularReferenceDetect);
        return json;
    }

    // 根据传商品名，查找订单及产品信息
    public String orderSearch(String userId,String commodityName) {
        ArrayList<OrderDto> orderDtos=new ArrayList<>();
        ArrayList<StoreCommodity> storeCommodities=CR.findByNameSales(commodityName);
        System.out.println("a"+storeCommodities.toString());
        for (StoreCommodity commodities:storeCommodities){
            ArrayList<StoreOrder> storeOrders=OR.findByUserIdAndCommodityId(userId,commodities.getCommodityId());
            System.out.println("b"+storeOrders.toString());
            if (storeOrders!=null){
                for (StoreOrder order : storeOrders) {
                    OrderDto orderDto = new OrderDto();
                    // 根据订单中的商品id查询商品
                    orderDto.setStoreOrder(order);
                    orderDto.setStoreCommodity(commodities);
                    orderDtos.add(orderDto);
                }
            }
        }
        String json= JSON.toJSONString(orderDtos, SerializerFeature.DisableCircularReferenceDetect);
        System.out.println("c"+json.toString());
        return json;
    }
}
