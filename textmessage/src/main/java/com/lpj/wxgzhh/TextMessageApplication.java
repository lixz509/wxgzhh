package com.lpj.wxgzhh;

import com.lpj.wxgzhh.domain.InMessage;
import com.lpj.wxgzhh.domain.Item;
import com.lpj.wxgzhh.domain.NewsOutMessage;
import com.lpj.wxgzhh.service.AccessTokenManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class TextMessageApplication {

	private static final Logger LOG = LoggerFactory.getLogger(TextMessageApplication.class);

	@Autowired
	private AccessTokenManager ATM;

	@Autowired
	private RedisTemplate<String,InMessage> inMessageTemplate;

	@Bean
	public RedisMessageListenerContainer messageListenerContainer(@Autowired RedisConnectionFactory connectionFactory){
		RedisMessageListenerContainer c=new RedisMessageListenerContainer();
		c.setConnectionFactory(connectionFactory);
		// 监听指定通道的消息
		Topic topic= new ChannelTopic("wxgzhh_text");
		// 添加消息的监听器
		c.addMessageListener(messageListener(),topic);
		return c;
	}

	@Bean
	public MessageListener messageListener(){
		//适配器是把任意对象，任意方法，代理成能处理消息的方法
		MessageListenerAdapter adapter=new MessageListenerAdapter(this,"handle");
		// 使用跟模板相同的序列化程序。
		adapter.setSerializer(inMessageTemplate.getValueSerializer());
		return adapter;
	}

	public void handle(InMessage msg){
		//正常处理消息
		System.out.println("收到的消息：" + msg);
		Map<String, String> requestMap =new HashMap<>();
		requestMap.put("ToUserName",msg.getToUserName());
		requestMap.put("FromUserName",msg.getFromUserName());
		Item item=new Item();
		item.setTitle("你好啊111");
		item.setDescription("这是一个测试的图文消息回复111");
		item.setPicUrl("http://img-arch.pconline.com.cn/images/upload/upc/tx/photoblog/1712/19/c4/70328457_1513655137311.jpg");
		item.setUrl("https://www.baidu.com/");
		NewsOutMessage nom= new NewsOutMessage(requestMap,item);
		String url="https://api.weixin.qq.com/cgi-bin/user/info"
		+ "?access_token=" + ATM.getToken("account")
				+ "&openid=" + msg.getToUserName()
				+ "&lang=zh_CN";
		//创建HTTP客户端
		HttpClient hc = HttpClient.newBuilder().build();
		HttpRequest request = HttpRequest.newBuilder(URI.create(url)).GET().build();
		try {
			// 发送请求
			// BodyHandlers里面包含了一系列的响应体处理程序，能够把响应体转换为需要的数据类型
			// ofString表示转换为String类型的数据
			// Charset.forName("UTF-8")表示使用UTF-8的编码转换数据
			HttpResponse<String> response  = hc.send(request, HttpResponse.BodyHandlers.ofString(Charset.forName("UTF-8")));
			//接收响应
			String body=response.body();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}


	}


	public static void main(String[] args) {
		SpringApplication.run(TextMessageApplication.class, args);
	}

}
