package com.zhaobo.stream.config;

import com.zhaobo.stream.mail.entity.Customer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * AppConfig.java
 *
 * <p>
 * Description: TODO
 * CreatBy: ZhaoBo
 * Date: 2021/4/13 - 上午11:51
 * </p>
 */
@Configuration
@EnableScheduling
//@EnableConfigurationProperties
public class AppConfig {

    @Bean
    public Customer customer() {
        return new Customer();
    }

    @Bean
    public MailSender mailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("zhaoboy@aliyun.com");
        return javaMailSender;
    }

    @Bean
    public SimpleMailMessage simpleMailMessage() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("zhaoboy@aliyun.com");
        simpleMailMessage.setSubject("order");
        return simpleMailMessage;
    }
}
