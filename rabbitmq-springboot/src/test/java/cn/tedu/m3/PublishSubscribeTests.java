package cn.tedu.m3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PublishSubscribeTests {

	@Autowired
	Sender sender;
	
	@Test
	void test1() throws Exception {
		sender.send();
	}
}
