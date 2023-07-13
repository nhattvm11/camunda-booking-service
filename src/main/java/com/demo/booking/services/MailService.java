package com.demo.booking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class MailService {

  @Autowired
  private JavaMailSender emailSender;

  @Bean
  public JavaMailSender getJavaMailSender() {
    JavaMailSender mailSender = new JavaMailSenderImpl();
    return mailSender;
  }

  public void sendSimpleMail(String to, String subject, String text) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("noreply@gmail.com");
    message.setTo(to);
    message.setSubject(subject);
    message.setText(text);
    emailSender.send(message);
  }
}
