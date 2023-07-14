package com.demo.booking.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class EmailConfiguration {

  @Bean
  public JavaMailSender getJavaMailSender() {
    JavaMailSender mailSender = new JavaMailSenderImpl();
    return mailSender;
  }
}
