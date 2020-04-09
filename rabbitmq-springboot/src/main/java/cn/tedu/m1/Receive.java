package cn.tedu.m1;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class Receive {

	@RabbitHandler
	public void receive(String msg) {
		System.out.println("收到的消息:"+msg);
	}
}
