package com.lpj.wxgzhh.controller;

import com.lpj.wxgzhh.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/store/search")
public class SearchController {

    private static final Logger LOG = LoggerFactory.getLogger(SearchController.class);

    @Autowired
    private SearchService SS;

    // 前端传商品名称，排序方式，返回查询到的商品
    @PostMapping
    public String searchCommodity(@RequestParam("commodityName") String commodityName,@RequestParam("sort") String sort){
        String json=SS.findCommodity(commodityName,sort);
        return json;
    }
}
