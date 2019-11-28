package com.lpj.wxgzhh;

import com.lpj.wxgzhh.domain.InMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@SpringBootApplication
public class TextMessageApplication {

	private static final Logger LOG = LoggerFactory.getLogger(TextMessageApplication.class);

	@Autowired
	private RedisTemplate<String,InMessage> inMessageTemplate;
	@Bean
	public RedisTemplate<String, InMessage> inMessageTemplate(
			@Autowired RedisConnectionFactory connectionFactory) {

		RedisTemplate<String,InMessage> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);

		// 使用序列化程序完成对象的序列化和反序列化，可以自定义
		template.setValueSerializer(new Jackson2JsonRedisSerializer<>(InMessage.class));
		return template;
	}


	@Bean
	public MessageListener messageListener(){
		//适配器是把任意对象，任意方法，代理成能处理消息的方法
		MessageListenerAdapter adapter=new MessageListenerAdapter(this,"handle");
		adapter.setSerializer(inMessageTemplate.getValueSerializer());
		return adapter;
	}

	public void handle(InMessage msg){
		//正常处理消息
		System.out.println("收到的消息：" + msg);
		LOG.trace("从消息通道收到的消息",msg);
	}

	@Bean
	public RedisMessageListenerContainer messageListenerContainer(@Autowired RedisConnectionFactory connectionFactory){
		RedisMessageListenerContainer c=new RedisMessageListenerContainer();
		c.setConnectionFactory(connectionFactory);
		Topic topic= new ChannelTopic("wxgzhh_text");
		c.addMessageListener(messageListener(),topic);
		return c;
	}

	public static void main(String[] args) {
		SpringApplication.run(TextMessageApplication.class, args);
	}

}
