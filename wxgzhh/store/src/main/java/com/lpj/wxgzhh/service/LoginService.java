package com.lpj.wxgzhh.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lpj.wxgzhh.repository.StoreUserRepository;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {

    @Autowired
    private StoreUserRepository SR;

    // 查询用户密码是否正确
    public String loginValidation(String userId,String password){
        String correctPasswoed=SR.findByUserId(userId).getPassword();
        Map map = new HashMap();
        String json;
        if(correctPasswoed.equals(password)){
            json= JSON.toJSONString("ok", SerializerFeature.DisableCircularReferenceDetect);
            return json;
        }
        json= JSON.toJSONString("no", SerializerFeature.DisableCircularReferenceDetect);
        return json;
    }

}
