package com.lpj.wxgzhh.controller;

import com.lpj.wxgzhh.service.MyConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/store/my")
public class MyConvertController {

    @Autowired
    private MyConvertService MS;

    @PostMapping
    @RequestMapping("/info")
    public String userInfo(@RequestParam("userid") String userId){
        String json=MS.findUser(userId);
        return json;
    }
}
