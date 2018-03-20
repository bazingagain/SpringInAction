package com.leon.springmail;

import com.leon.springmail.bean.MailContent;
import com.leon.springmail.service.MailSenderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LearnSpringMailApplicationTests {

	@Autowired
	private MailSenderService mailSenderService;

	@Value("${spring.mail.to}")
	private String to;

	@Test
	public void contextLoads() {
		String content = "test 文本";
//		mailSenderService.sendSimpleEmail(to, new MailContent(content));
//		mailSenderService.sendRichMail(to, new MailContent(content));
//		mailSenderService.sendFreemarkerHtmlMail(to, new MailContent(content));
		mailSenderService.sendThemleafHtmlMail(to, new MailContent(content));
	}

}
