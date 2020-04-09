package cn.tedu.m2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WorkTest {

	@Autowired
	Sender sender;
	
	@Test
	void test1() throws Exception {
		sender.send();
	}
}
