package com.lpj.wxgzhh.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.lpj.wxgzhh.StoreCollect;
import com.lpj.wxgzhh.domain.StoreUser;
import com.lpj.wxgzhh.domain.dto.FavoriteDto;
import com.lpj.wxgzhh.repository.CollectRepository;
import com.lpj.wxgzhh.repository.CommodityRepository;
import com.lpj.wxgzhh.repository.StoreUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyContentService {

    @Autowired
    private StoreUserRepository SUR;

    @Autowired
    private CommodityRepository CR;

    @Autowired
    private CollectRepository CR2;

    // 根据用户id查询用户资料
    public String findUser(String userId) {
        StoreUser storeUser=SUR.findByUserId(userId);
        String json= JSON.toJSONString(storeUser, SerializerFeature.DisableCircularReferenceDetect);
        return json;
    }

    // 根据传用户id，用户名，地区，修改相应信息
    public void updateUsernameAndLocation(String userId, String userName, String location) {
        SUR.saveUsernameAndLocation(userId,userName,location);
    }

    // 根据传入用户id，新的地址，修改地址
    public void updateAddress(String userId, String address) {
        SUR.saveAddress(userId,address);
    }

    // 根据传用户id，密码，修改密码
    public void updatePassword(String userId, String password) {
        SUR.savePassword(userId,password);
    }

    // 根据用户id，查询收藏夹内容
    public String onFavorite(String userId) {
        ArrayList<StoreCollect> storeCollects=CR2.findByUserId(userId);
        ArrayList<FavoriteDto> favoriteDtos=new ArrayList<>();
        for (StoreCollect s:storeCollects){
            FavoriteDto favoriteDto=new FavoriteDto();
            favoriteDto.setStoreCollect(s);
            favoriteDto.setStoreCommodity(CR.findByCommodityId(s.getCommodityId()));
            favoriteDtos.add(favoriteDto);
        }
        String json= JSON.toJSONString(favoriteDtos, SerializerFeature.DisableCircularReferenceDetect);
        return json;
    }
}
