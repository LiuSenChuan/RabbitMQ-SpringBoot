package cn.tedu.m3;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
	/**
	 * 创建fanoutExchange实例封装交换机名
	 * 自动配置类会自动发现这个实例,并连接rabbitmq来定义这个交换机
	 * @return
	 */
	@Bean
	public FanoutExchange logsExchange() {
		return new FanoutExchange("logsss");
	}

}
