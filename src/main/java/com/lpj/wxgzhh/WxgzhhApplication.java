package com.lpj.wxgzhh;

import com.lpj.wxgzhh.domain.InMessage;
import com.lpj.wxgzhh.service.MessageAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

@SpringBootApplication
public class WxgzhhApplication {

	@Autowired
	private MessageAnalysisService MRS;

	@Bean
	public RedisTemplate<String, InMessage> inMessageTemplate(
			@Autowired RedisConnectionFactory connectionFactory) {

		RedisTemplate<String,InMessage> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);

		// 使用序列化程序完成对象的序列化和反序列化，可以自定义
		template.setValueSerializer(new Jackson2JsonRedisSerializer<>(InMessage.class));
		return template;
	}

	public static void main(String[] args) {
		SpringApplication.run(WxgzhhApplication.class, args);
	}

}
