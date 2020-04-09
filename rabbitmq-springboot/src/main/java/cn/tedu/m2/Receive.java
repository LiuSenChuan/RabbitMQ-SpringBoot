package cn.tedu.m2;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receive {

	@RabbitListener(queues = "task_queue")
	public void receive1(String s) throws InterruptedException {
		System.out.println("receive1-收到:"+s);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '.') {
				Thread.sleep(1000);
			}
		}
	}
	@RabbitListener(queues = "task_queue")
	public void receive2(String s) throws InterruptedException {
		System.out.println("receive2-收到:"+s);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '.') {
				Thread.sleep(1000);
			}
		}
	}
}
