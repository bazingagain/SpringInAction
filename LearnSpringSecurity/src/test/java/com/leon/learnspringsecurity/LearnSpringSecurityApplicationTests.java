package com.leon.learnspringsecurity;

import com.leon.learnspringsecurity.dao.SpitterMapper;
import com.leon.learnspringsecurity.entity.Spitter;
import com.leon.learnspringsecurity.service.SpitterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.MessageDigestPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnSpringSecurityApplicationTests {


	@Autowired
	private SpitterService spitterService;

	@Test
	public void contextLoads() {
		spitterService.insert(new Spitter("test", "password"));
	}

	@Test
	public void testVirablePasswordEncoder() {
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
//		String result = encoder.encode("myPassword");
//		System.out.println(result);
//		assertTrue(encoder.matches("myPassword", result));
		MessageDigestPasswordEncoder encoder1 = new MessageDigestPasswordEncoder("md5");
		String result1 = encoder1.encode("pengxiaolei");
		assertTrue(encoder1.matches("pengxiaolei", result1));
	}

}
