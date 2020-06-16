package com.lpj.wxgzhh.controller;

import com.lpj.wxgzhh.service.HomeContentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/store/home")
public class HomeContentController {

    private static final Logger LOG = LoggerFactory.getLogger(HomeContentController.class);

    @Autowired
    private HomeContentService HCS;

    // 前端传用户id，返回首页所需要的数据
    @PostMapping
    public String onHome(@RequestParam("userid") String userId){
        String json=HCS.homeShow();
        return json;
    }

    // 前端传分类id，排序方式，查找商品
    @PostMapping
    @RequestMapping("/classify")
    public String onClassify(@RequestParam("classifyId") String classifyId,@RequestParam("sort") String sort){
        String json=HCS.classifyCommodity(classifyId,sort);
        return json;
    }
}
