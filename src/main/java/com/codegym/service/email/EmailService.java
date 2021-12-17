package com.codegym.service.email;


import com.codegym.model.email.MailObject;

import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;

public interface EmailService {
    void sendSimpleMessage(MailObject mail);

}
