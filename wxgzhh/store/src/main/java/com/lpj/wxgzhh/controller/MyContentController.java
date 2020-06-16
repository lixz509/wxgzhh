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

    // 前端传用户id，用户名，地区，修改相应信息
    @PostMapping
    @RequestMapping("/updateUsername")
    public void updateUsernameAndLocation(@RequestParam("userid") String userId,@RequestParam("userName") String userName,
                                            @RequestParam("location") String location){
        MS.updateUsernameAndLocation(userId,userName,location);
    }

    // 前端传入用户id，新的地址，修改地址
    @PostMapping
    @RequestMapping("/updateAddress")
    public void updateAddress(@RequestParam("userid") String userId,@RequestParam("address") String address){
        MS.updateAddress(userId,address);
    }

    // 前端传用户id，密码，修改密码
    @PostMapping
    @RequestMapping("/updatePassword")
    public void updatePassword(@RequestParam("userid") String userId,@RequestParam("password") String password){
        MS.updatePassword(userId,password);
    }

    // 前端传用户id，查询收藏夹内容
    @PostMapping
    @RequestMapping("/favorite")
    public String onFavorite(@RequestParam("userid") String userId){
        String json=MS.onFavorite(userId);
        return json;
    }

}
