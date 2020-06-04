package com.lpj.wxgzhh.controller;

import com.lpj.wxgzhh.service.MyContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/store/my")
public class MyContentController {

    private static final Logger LOG = LoggerFactory.getLogger(MyContentController.class);

    @Autowired
    private MyContentService MS;

    // 前端传入用户id，返回用户信息
    @PostMapping
    @RequestMapping("/info")
    public String userInfo(@RequestParam("userid") String userId){
        String json=MS.findUser(userId);
        return json;
    }
}
