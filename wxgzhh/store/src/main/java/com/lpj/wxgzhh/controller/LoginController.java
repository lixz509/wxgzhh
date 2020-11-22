package com.lpj.wxgzhh.controller;

import com.lpj.wxgzhh.service.HomeContentService;
import com.lpj.wxgzhh.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin
@RestController
@RequestMapping("/store/login")
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService LS;

    @PostMapping
    public String onHome(@RequestParam("userid") String userId, @RequestParam("password")
            String password){
        String json=LS.loginValidation(userId,password);
        return json;
    }

}
