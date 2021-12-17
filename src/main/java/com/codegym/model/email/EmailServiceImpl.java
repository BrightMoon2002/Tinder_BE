package com.codegym.model.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Map;

@Component
public class EmailServiceImpl implements EmailService  {

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("kiemda02@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    @Override
    public void sendSimpleMessageUsingTemplate(String to, String subject, String... templateModel) {

    }

    @Override
    public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment) {

    }

    @Override
    public void sendMessageUsingThymeleafTemplate(String to, String subject, Map<String, Object> templateModel) throws IOException, MessagingException {

    }

    @Override
    public void sendMessageUsingFreemarkerTemplate(String to, String subject, Map<String, Object> templateModel) throws IOException, MessagingException {

    }
}
