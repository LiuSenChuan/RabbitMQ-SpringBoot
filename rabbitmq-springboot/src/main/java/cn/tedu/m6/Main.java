package cn.tedu.m6;

import java.util.UUID;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
	//rpc
	//发送调用信息的队列
	@Bean
	public Queue sendQueue() {
		return new Queue("rpcc_queue",false);
	}
	//返回结果的队列(随机)
	@Bean
	public Queue rndQueue() {
		return new Queue(UUID.randomUUID().toString(),false);
	}

}
