package com.lpj.wxgzhh.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

@Service
public class AccessTokenManager {

    @Autowired
    private RedisTemplate<String ,String> tokenTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(AccessTokenManager.class);

    //用于获取token。获取token的方式，向微信指定地址发送get请求传3个参数
    public String getToken(String account){
        // 测试号appID，appsecret
//        String appID="wx656999f734cc7d7b";
//        String appsecret="6baaabdfa5bfa88b0f764f6cc89be919";
        String appID="wx9e1bc1182bdf8864";
        String appsecret= "5c73fe6b3f9bb7fab382ab1e1654ef22";
        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appID+"&secret="+appsecret;
        //创建HTTP客户端
        HttpClient hc = HttpClient.newBuilder().build();
        //查找redis数据库是否有token，没有则请求
        if (tokenTemplate.hasKey("token")){
            //从redis数据库中获取token，然后返回
            LOG.trace("token为：\n{}\n",tokenTemplate.opsForValue().get("token"));
            return tokenTemplate.opsForValue().get("token");
        }else {
            //创建请求
            HttpRequest request = HttpRequest.newBuilder(URI.create(url)).GET().build();
            try {
                // 发送请求
                // BodyHandlers里面包含了一系列的响应体处理程序，能够把响应体转换为需要的数据类型
                // ofString表示转换为String类型的数据
                // Charset.forName("UTF-8")表示使用UTF-8的编码转换数据
                HttpResponse<String> response = hc.send(request, BodyHandlers.ofString(Charset.forName("UTF-8")));
                LOG.trace("token222为：\n{}\n",tokenTemplate.opsForValue().get("token"));
                //接收响应
                String body = response.body();
                if (body.contains("errcode")) {
                    //截取错误代码
                    String errcode = body.substring(11, body.indexOf(",\""));
                    LOG.trace("token333为：\n{}\n",errcode);
                    return "出现错误,错误代码" + errcode;
                } else {
                    //截取token
                    String token = body.substring(17, body.indexOf("\",\""));
                    //将获取到的token储存到redis数据库
                    tokenTemplate.opsForValue().set("token", token);
                    //设置token的过期时间为6900秒
                    tokenTemplate.expire("token", 6900, TimeUnit.SECONDS);
                    LOG.trace("存储token为：\n{}\n",tokenTemplate.opsForValue().get("token"));
                    return token;
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "未知错误01";
    }
}
