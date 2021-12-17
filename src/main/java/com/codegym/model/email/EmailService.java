package com.codegym.model.email;


import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;

public interface EmailService {
    void sendSimpleMessage(MailObject mail);

}
