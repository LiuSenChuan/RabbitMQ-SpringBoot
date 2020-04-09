package cn.tedu.m5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RouteTests {

	@Autowired
	Sender sender;
	
	@Test
	void test1() throws Exception {
		sender.send();
	}
}
