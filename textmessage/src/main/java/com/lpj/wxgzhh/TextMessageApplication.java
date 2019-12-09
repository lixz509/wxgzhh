package com.lpj.wxgzhh;

import com.lpj.wxgzhh.domain.InMessage;
import com.lpj.wxgzhh.domain.supportmessage.*;
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
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class TextMessageApplication {

	private static final Logger LOG = LoggerFactory.getLogger(TextMessageApplication.class);
	private ObjectMapper objectMapper = new ObjectMapper();

	@Autowired
	private AccessTokenManager ATM;

	@Autowired
	private RedisTemplate<String,InMessage> inMessageTemplate;

	//创建HTTP客户端
	private HttpClient httpClient = HttpClient.newBuilder().build();

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
		SupportMessage message=null;
		if(msg.getContent().equals("文本")){
			message = new TextSupportMessage(msg.getFromUserName(), "这是一个文本消息");
		}else if (msg.getContent().equals("图片")){
			message=new ImageSupportMessage(msg.getFromUserName(),
					"http://img-arch.pconline.com.cn/images/upload/upc/tx/photoblog/1712/19/c4/70328457_1513655137311.jpg");
		}else if (msg.getContent().equals("语音")){
			message=new VoiceSupportMessage(msg.getFromUserName(),
				"http://sc1.111ttt.cn/2018/1/03/13/396131232171.mp3");
		}else if (msg.getContent().equals("视频")){
			message=new VideoSupportMessage(msg.getFromUserName(),
				"http://pgcvideo.cdn.xiaodutv.com/2849644470_1797463479_2018110519121820181106011251.mp4?" +
						"Cache-Control=max-age%3D8640000&responseExpires=Thu%2C+14+Feb+2019+01%3A14%3A24+GMT&xcode=" +
						"883053dba8fe93a024ce879f9e817dc01bd054a26917af01&time=1575772889&_=1575686507485",
				"http://img15.3lian.com/2015/f3/17/d/141.jpg",
				"你好","这是个视频消息");
		}else if (msg.getContent().equals("音乐")){
			message=new MusicSupportMessage(msg.getFromUserName(),
					"http://sc1.111ttt.cn/2018/1/03/13/396131232171.mp3",
					"这是一个音乐消息",
					"http://sc1.111ttt.cn/2018/1/03/13/396131232171.mp3",
					"http://sc1.111ttt.cn/2018/1/03/13/396131232171.mp3",
					"http://bpic.588ku.com/element_origin_min_pic/16/11/17/ae79bfc3726b592470db581e83faaa1a.jpg");
		}else if (msg.getContent().equals("图文外")){
			message=new NewsSupportMessage(msg.getFromUserName(),"你好啊","这是一个图文消息",
					"https://www.baidu.com/","http://i1.sinaimg.cn/ent/d/2008-06-04/U105P28T3D2048907F326DT20080604225106.jpg");
		}else if (msg.getContent().equals("图文内")){
			message=new MpnewsSupportMessage(msg.getFromUserName(),
					"http://b-ssl.duitang.com/uploads/blog/201312/09/20131209151602_evtcw.jpeg");
		}else if (msg.getContent().equals("菜单")){
			message=new MsgmenuSupportMessage(msg.getFromUserName(),"您对本次服务是否满意呢？","欢迎再次光临",
					"101","满意","102","不满意");
		}else if (msg.getContent().equals("卡卷")){
			message=new WxcardSupportMessage(msg.getFromUserName(),
					"http://i1.sinaimg.cn/ent/d/2008-06-04/U105P28T3D2048907F326DT20080604225106.jpg");
		}

		String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=" + ATM.getToken("account");
		try {
			//创建json数据用于传参
			String json = this.objectMapper.writeValueAsString(message);
			System.out.println("将要发送的json数据"+json);
			LOG.trace("将要发送的json数据",json);
			//创建请求
			HttpRequest request = HttpRequest.newBuilder(URI.create(url))
					.POST(BodyPublishers.ofString(json, Charset.forName("UTF-8"))).build();
			// 发送请求
			// BodyHandlers里面包含了一系列的响应体处理程序，能够把响应体转换为需要的数据类型
			// ofString表示转换为String类型的数据
			// Charset.forName("UTF-8")表示使用UTF-8的编码转换数据
			HttpResponse<String> response  = httpClient.send(request, HttpResponse.BodyHandlers.ofString(Charset.forName("UTF-8")));
			//接收响应
			String body=response.body();
			System.out.println("响应为"+body);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(TextMessageApplication.class, args);
	}

}
