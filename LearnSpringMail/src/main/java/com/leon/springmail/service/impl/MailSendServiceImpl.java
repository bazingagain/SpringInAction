package com.leon.springmail.service.impl;

import com.leon.springmail.bean.MailContent;
import com.leon.springmail.service.MailSenderService;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.thymeleaf.Thymeleaf;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 20/03/2018.
 *
 * @author Xiaolei-Peng
 */

@Service
public class MailSendServiceImpl implements MailSenderService{

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private FreeMarkerConfigurer configurer;  //自动注入

    @Autowired
    private SpringTemplateEngine thymeleaf;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void sendSimpleEmail(String to, MailContent mailContent) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject("New Mail From " + from);
        message.setText(mailContent.getContent());
        mailSender.send(message);
    }

    @Override
    public void sendAttachMail(String to, MailContent mailContent) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject("New Mail From " + from);
            helper.setText(mailContent.getContent());
            FileSystemResource image = new FileSystemResource("/");
            helper.addAttachment("image.png", image);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendRichMail(String to, MailContent mailContent) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject("New Mail From " + from);
            helper.setText("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "<image src='cid:sitelogo'>\n" +
                    "<h4>"+from+"</h4>\n" +
                    "<i>"+mailContent.getContent()+"</i>\n" +
                    "</body>\n" +
                    "</html>", true);
            ClassPathResource image = new ClassPathResource("static/image/sitelogo.png");
            helper.addInline("sitelogo", image);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendFreemarkerHtmlMail(String to, MailContent mailContent) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject("New Mail From " + from);
            //修改模板配置
//            FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
//            configurer.setTemplateLoaderPath("classpath:templates");

            Template template = configurer.getConfiguration().getTemplate("mail.html");
            Map<String, Object> model = new HashMap<>();
            model.put("userName", "leon");
            model.put("content", mailContent.getContent());
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);


            helper.setText(html, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (TemplateNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendThemleafHtmlMail(String to, MailContent mailContent) {
        try {
            Context ctx = new Context();
            Map<String, Object> model = new HashMap<>();
            model.put("userName", "leon");
            model.put("content", mailContent.getContent());
            ctx.setVariables(model);
            String html = thymeleaf.process("thymeleafmail.html", ctx);
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setSubject("New Mail Use Thymeleaf From " + from);
            helper.setTo(to);
            helper.setText(html, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
