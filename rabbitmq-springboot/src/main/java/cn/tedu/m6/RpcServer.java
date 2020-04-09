package cn.tedu.m6;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RpcServer {

	@RabbitListener(queues = "rpcc_queue")
	public long getFbnq(int n) {
		return f(n);
	}
	
	private long f(int n) {
		if (n==1 || n==2) {
			return 1;
		}
		return f(n-1) + f(n-2);
	}
}
