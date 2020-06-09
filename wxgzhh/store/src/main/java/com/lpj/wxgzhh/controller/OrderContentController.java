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
    @PostMapping("/shipments")
    public String shipmentsOrder(@RequestParam("userid") String userId,@RequestParam("orderId") String orderId){
        String json=OS.updateShipmentsOrder(userId,orderId);
        return json;
    }

    // 前端传订单id，返回订单金额
    @PostMapping("/price")
    public String orderPrice(@RequestParam("orderId") String orderId){
        String json=OS.findOrderBalance(orderId);
        return json;
    }

}
