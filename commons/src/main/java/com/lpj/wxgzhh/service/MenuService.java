package com.lpj.wxgzhh.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lpj.wxgzhh.domain.button.*;
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
public class MenuService {

    private static final Logger LOG = LoggerFactory.getLogger(MenuService.class);

    @Autowired
    private AccessTokenManager ATM;

    //创建HTTP客户端
    private HttpClient httpClient = HttpClient.newBuilder().build();

    private ObjectMapper objectMapper = new ObjectMapper();

    public String Menu(){
        //设置菜单
        Button btn=new Button();
        btn.getButton().add(new ViewMenuButton("一级跳转","http://www.baidu.com"));
        SubButtonMenuButton sb1=new SubButtonMenuButton("子菜单一");
        sb1.getSubButton().add(new ViewMenuButton("二级跳转","http://www.4399.com"));
        sb1.getSubButton().add(new ScancodePushMenuButton("扫码推事件","2-2"));
        sb1.getSubButton().add(new ScancodeWaitmsgMenuButton("扫码带提示","2-3"));
//        sb1.getSubButton().add(new MediaIdMenuButton("图片","3-3"));
        btn.getButton().add(sb1);
        SubButtonMenuButton sb2=new SubButtonMenuButton("子菜单二");
        sb2.getSubButton().add(new PicWeixinMenuButton("微信相册发图","3-1"));
        sb2.getSubButton().add(new LocationSelectMenuButton("发送位置","3-2"));
        sb2.getSubButton().add(new PicSysphotoMenuButton("系统拍照发图","3-3"));
        sb2.getSubButton().add(new PicPhotoOrAlbumMenuButton("拍照或者相册发图","3-4"));
//        sb2.getSubButton().add(new ViewLlimitedMenuButton("图文消息","3-5"));
        btn.getButton().add(sb2);
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=" + ATM.getToken("account");
        try {
            //创建json数据用于传参
            String json = this.objectMapper.writeValueAsString(btn);
            System.out.println("将要发送的json数据"+json);
            //创建请求
            HttpRequest request = HttpRequest.newBuilder(URI.create(url))
                    .POST(HttpRequest.BodyPublishers.ofString(json, Charset.forName("UTF-8"))).build();
            // 发送请求
            // BodyHandlers里面包含了一系列的响应体处理程序，能够把响应体转换为需要的数据类型
            // ofString表示转换为String类型的数据
            // Charset.forName("UTF-8")表示使用UTF-8的编码转换数据
            HttpResponse<String> response  = httpClient.send(request, HttpResponse.BodyHandlers.ofString(Charset.forName("UTF-8")));
            //接收响应
            String body=response.body();
            LOG.trace("设置菜单的响应为：\n{}\n",body);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return "ok";
    }

}
