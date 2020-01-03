package com.lpj.wxgzhh.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lpj.wxgzhh.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;

@Service
public class WeiXinProxy {

    private static final Logger LOG = LoggerFactory.getLogger(WeiXinProxy.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private AccessTokenManager ATM;

    //创建HTTP客户端
    private HttpClient httpClient = HttpClient.newBuilder().build();

    public User getUser(String account,String openId){
        String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token="+ATM.getToken("account")
                +"&openid="+openId+"&lang=zh_CN" + ATM.getToken("account");
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).GET().build();
        try {
            HttpResponse<String> response  = httpClient.send(request, HttpResponse.BodyHandlers.ofString(Charset.forName("UTF-8")));
            String body=response.body();
            LOG.trace("响应为"+body);
            if (!body.contains("errcode")){
                User user = objectMapper.readValue(body, User.class);
                return user;
            }
        } catch (IOException |InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
