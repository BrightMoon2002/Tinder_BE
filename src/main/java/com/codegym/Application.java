package com.codegym;

import com.codegym.service.email.EmailService;
import com.codegym.model.email.MailObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        MailObject mail = new MailObject();
        mail.setMailFrom("hoangbaoanhng18@gmail.com");
        mail.setMailTo("duynh1618@gmail.com");
        mail.setMailSubject("Spring Boot - Email Example");
        mail.setMailContent("Learn How to send Email using Spring Boot!!!\n\nThanks\nwww.technicalkeeda.com");

        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        EmailService mailService = (EmailService) ctx.getBean("mailService");
        mailService.sendSimpleMessage(mail);

    }

}
