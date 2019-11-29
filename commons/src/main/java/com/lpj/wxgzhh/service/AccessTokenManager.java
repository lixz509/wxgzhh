package com.lpj.wxgzhh.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.Charset;

@Service
public class AccessTokenManager {

    //用于获取token。获取token的方式，向微信指定地址发送get请求传3个参数
    public static String getToken(String account){
        String appID="wx656999f734cc7d7b";
        String appsecret="6baaabdfa5bfa88b0f764f6cc89be919";
        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appID+"&secret="+appsecret;
        //创建HTTP客户端
        HttpClient hc = HttpClient.newBuilder().build();
        //查找消息队列是否有token，没有则请求（未做）

        //创建请求
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).GET().build();
        try {
            // 发送请求
            // BodyHandlers里面包含了一系列的响应体处理程序，能够把响应体转换为需要的数据类型
            // ofString表示转换为String类型的数据
            // Charset.forName("UTF-8")表示使用UTF-8的编码转换数据
            HttpResponse<String> response  = hc.send(request, BodyHandlers.ofString(Charset.forName("UTF-8")));
            //接收响应
            String body=response.body();
            if (body.contains("errcode")){
                //截取错误代码
                String errcode=body.substring(11,body.indexOf(",\""));
                return "出现错误,错误代码"+errcode;
            }else {
                //截取token
                String token=body.substring(17,body.indexOf("\",\""));
                return token;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "未知错误01";
    }

}
