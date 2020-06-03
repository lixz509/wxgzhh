package com.lpj.wxgzhh.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lpj.wxgzhh.domain.StoreUser;
import com.lpj.wxgzhh.repository.StoreUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyConvertService {

    @Autowired
    private StoreUserRepository SUR;

    // 根据用户id查询用户资料
    public String findUser(String userId) {
        StoreUser storeUser=SUR.findByUserId(userId);
        String json= JSON.toJSONString(storeUser, SerializerFeature.DisableCircularReferenceDetect);
        return json;
    }


}
