package cn.tedu.m4;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receive {

	/**
	 * 定义随机队列(随机命名,非持久,排他,自动删除)
	 * 可定义 交换机(已在主程序定义,课省略)
	 * 绑定(将队列绑定至交换机)
	 * @param s
	 * @throws Exception
	 */
	//@QueueBinding进行绑定设置    value = @Queue,定义随机队列  exchange = @Exchange指定logs交换机
	@RabbitListener(bindings = @QueueBinding(
			value = @Queue,
			exchange = @Exchange(name = "directt_logs",declare = "false"),
			key = {"error"}))
	public void receive1(String s) throws Exception {
		System.out.println("receiver1 - 收到: "+s);
	}
	
	@RabbitListener(bindings = @QueueBinding(
			value = @Queue,
			exchange = @Exchange(name = "directt_logs",declare = "false"),
			key = {"error","info"}))
	public void receive2(String s) throws Exception {
		System.out.println("receiver2 - 收到: "+s);
	}
}
