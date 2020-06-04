package com.lpj.wxgzhh.controller;

import com.lpj.wxgzhh.service.ShoppingTrolleyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/store/shopping")
public class ShoppingTrolleyController {

    private static final Logger LOG = LoggerFactory.getLogger(ShoppingTrolleyController.class);

    @Autowired
    private ShoppingTrolleyService STS;

    // 前端传用户id，返回购物车页面数据

}
