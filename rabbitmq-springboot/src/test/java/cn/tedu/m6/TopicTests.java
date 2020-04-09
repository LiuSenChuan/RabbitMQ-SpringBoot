package cn.tedu.m6;

import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TopicTests {
	@Autowired
	RpcClient client;

	@Test
	void test1() throws Exception {
		while (true) {
			System.out.print("求第几个斐波那契数: ");
			int n = new Scanner(System.in).nextInt();
			client.send(n);
		}
	}

}
