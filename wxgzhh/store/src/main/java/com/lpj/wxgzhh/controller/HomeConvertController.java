package com.lpj.wxgzhh.controller;

import com.lpj.wxgzhh.service.HomeConvertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/store/home")
public class HomeConvertController {
    private static final Logger LOG = LoggerFactory.getLogger(HomeConvertController.class);

    @Autowired
    private HomeConvertService HCS;

    @PostMapping
    public String onMessage(@RequestParam("userid") String userId){
        String json=HCS.homeShow();
        System.out.println(json);
        return json;
    }
}
