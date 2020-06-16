package com.lpj.wxgzhh.controller;

import com.lpj.wxgzhh.service.ShoppingTrolleyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/store/shopping")
public class ShoppingTrolleyController {

    private static final Logger LOG = LoggerFactory.getLogger(ShoppingTrolleyController.class);

    @Autowired
    private ShoppingTrolleyService STS;

    // 前端传用户id，返回购物车页面数据
    @PostMapping
    private String onShoppingTrolley(@RequestParam("userid") String userId){
        String json=STS.shoppingTrolleyShow(userId);
        return json;
    }

    // 前端传购物车id，数量，修改购物车商品数量
    @PostMapping
    @RequestMapping("/number")
    private void saveShoppingNum(@RequestParam("shoppingTrolleyId") String shoppingTrolleyId,@RequestParam("num") String num){
        STS.shoppingTrolleyNum(shoppingTrolleyId,num);
    }

    // 前端传购物车id，用户id，商品id，数量，新增一个状态为未付款的订单，并将该商品从购物车列表中删除
    @PostMapping
    @RequestMapping("/order")
    private String shoppingTrolleyOrder(@RequestParam("shoppingTrolleyId") String shoppingTrolleyId){
        String json=STS.savePaymentOrder(shoppingTrolleyId);
        return json;
    }

    // 根据购物车id，删除购物车信息
    @PostMapping
    @RequestMapping("/deleteShoppingTrolley")
    private void deleteShoppingTrolley(@RequestParam("shoppingTrolleyId") String shoppingTrolleyId){
        STS.deleteShoppingTrolley(shoppingTrolleyId);
    }

}
