package com.lpj.wxgzhh;

import com.lpj.wxgzhh.domain.InMessage;
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

@SpringBootApplication
public class SubscribeApplication {

	private static final Logger LOG = LoggerFactory.getLogger(SubscribeApplication.class);

	@Autowired
	private RedisTemplate<String, InMessage> inMessageTemplate;

	@Autowired
	private AccessTokenManager ATM;

	@Bean
	public MessageListener messageListener(){
		//适配器是把任意对象，任意方法，代理成能处理消息的方法
		MessageListenerAdapter adapter=new MessageListenerAdapter(this,"handle");
		// 使用跟模板相同的序列化程序。
		adapter.setSerializer(inMessageTemplate.getValueSerializer());
		return adapter;
	}

	@Bean
	public RedisMessageListenerContainer messageListenerContainer(@Autowired RedisConnectionFactory connectionFactory){
		RedisMessageListenerContainer c=new RedisMessageListenerContainer();
		c.setConnectionFactory(connectionFactory);
		// 监听指定通道的消息
		Topic topic= new ChannelTopic("wxgzhh_subscribe");
		// 添加消息的监听器
		c.addMessageListener(messageListener(),topic);
		return c;
	}

	public void handle(InMessage msg) {
		System.out.println("收到的消息：" + msg);
	}

	public static void main(String[] args) {
		SpringApplication.run(SubscribeApplication.class, args);
	}

}
