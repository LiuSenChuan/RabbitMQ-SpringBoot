package cn.tedu.m1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimpleTest {

	@Autowired
	Sender sender;
	
	@Test
	public void text1() throws Exception{
		sender.send();
	}
}
