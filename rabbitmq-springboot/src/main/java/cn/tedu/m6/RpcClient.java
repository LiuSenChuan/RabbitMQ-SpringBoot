package cn.tedu.m6;

import java.util.UUID;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class RpcClient {
	@Autowired
	AmqpTemplate t;
	
	@Value("#{rndQueue.name}")
	String rndQueue;
	
	public void send(int n) {
		// 发送调用信息时, 通过前置消息处理器, 对消息属性进行设置, 添加返回队列名和关联id
		t.convertAndSend("rpcc_queue", (Object)n, new MessagePostProcessor() {
			@Override
			public Message postProcessMessage(Message message) throws AmqpException {
				MessageProperties p = message.getMessageProperties();
				p.setReplyTo(rndQueue);
				p.setCorrelationId(UUID.randomUUID().toString());
				return message;
			}
		});
	}
	
	//从随机队列接收计算结果
	@RabbitListener(queues = "#{rndQueue.name}")
	public void receive(long r, @Header(name=AmqpHeaders.CORRELATION_ID) String correlationId) {
		System.out.println("\n\n"+correlationId+" - 收到: "+r);
	}
	
}
