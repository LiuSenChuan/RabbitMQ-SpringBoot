package cn.tedu.m2;

import java.util.Scanner;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	AmqpTemplate t;
	
	public void send() {
		while (true) {
			System.out.println("输入:");
			String s = new Scanner(System.in).nextLine();
			//spring默认将消息的DeliveryMode 设置为 PERSISTENT 持久化,
			t.convertAndSend("task_queue",s);
		}
	}
}
