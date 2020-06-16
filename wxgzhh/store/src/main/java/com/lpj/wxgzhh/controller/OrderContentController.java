package com.lpj.wxgzhh.controller;

import com.lpj.wxgzhh.service.OrderContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/store/order")
public class OrderContentController {

    private static final Logger LOG = LoggerFactory.getLogger(OrderContentController.class);

    @Autowired
    private OrderContentService OS;

    // 前端传订单id，用户id，将订单从未支付状态转为未发货状态
    @PostMapping
    @RequestMapping("/shipments")
    public String shipmentsOrder(@RequestParam("userid") String userId,@RequestParam("orderId") String orderId){
        String json=OS.updateShipmentsOrder(userId,orderId);
        return json;
    }

    // 前端传订单id，返回订单金额
    @PostMapping
    @RequestMapping("/price")
    public String orderPrice(@RequestParam("orderId") String orderId){
        String json=OS.findOrderBalance(orderId);
        return json;
    }

    // 前端传用户id，订单状态查询所有订单信息用于订单页面展示
    @PostMapping
    public String onOrder(@RequestParam("userid") String userId,@RequestParam("sort")String sort){
        String json=OS.onOrder(userId,sort);
        return json;
    }

    // 前端传用户id，商品名，返回订单及产品信息
    @PostMapping
    @RequestMapping("/search")
    public String orderSearch(@RequestParam("userid") String userId,@RequestParam("commodityName") String commodityName){
        String json=OS.orderSearch(userId,commodityName);
        return json;
    }

}
