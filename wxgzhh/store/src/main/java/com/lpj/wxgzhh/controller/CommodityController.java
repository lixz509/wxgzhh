package com.lpj.wxgzhh.controller;

import com.lpj.wxgzhh.service.CommodityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/store/commodity")
public class CommodityController {

    private static final Logger LOG = LoggerFactory.getLogger(CommodityController.class);

    @Autowired
    private CommodityService CS;

    // 前端传商品id，查询商品详细信息
    @PostMapping
    public String onCommodityDetails(@RequestParam("userid") String userId,@RequestParam("commodityId") String commodityId){
        String json=CS.commodityDetailsShow(userId,commodityId);
        return json;
    }

    // 前端传用户id，商品id，添加到收藏
    @PostMapping
    @RequestMapping("/addCollect")
    public void addCollect(@RequestParam("userid") String userId,@RequestParam("commodityId") String commodityId){
        CS.addCollect(userId,commodityId);
    }

    // 前端传用户id，商品id，删除收藏
    @PostMapping
    @RequestMapping("/deleteCollect")
    public void deleteCollect(@RequestParam("userid") String userId,@RequestParam("commodityId") String commodityId){
        CS.deleteCollect(userId,commodityId);
    }

    // 前端传用户id，商品id，添加到购物车
    @PostMapping
    @RequestMapping("/addShoppingTrolley")
    public void addShoppingTrolley(@RequestParam("userid") String userId,@RequestParam("commodityId") String commodityId){
        CS.addShoppingTrolley(userId,commodityId);
    }

    // 前端传用户id，商品id，生成一个未支付的订单
    @PostMapping
    @RequestMapping("/addOrder")
    public String  addOrder(@RequestParam("userid") String userId,@RequestParam("commodityId") String commodityId){
        String json=CS.addOrder(userId,commodityId);
        return json;
    }
}
