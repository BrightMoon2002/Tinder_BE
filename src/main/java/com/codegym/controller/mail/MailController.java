package com.codegym.controller.mail;

import com.codegym.model.email.EmailService;
import com.codegym.model.email.MailObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Controller
@CrossOrigin("*")
@RequestMapping("/mails")
public class MailController {

    @Autowired
    public EmailService emailService;

    private static final Map<String, Map<String, String>> labels;

    static {
        labels = new HashMap<>();
        //Simple email
        Map<String, String> props = new HashMap<>();
        props.put("headerText", "Send Simple Email");
        props.put("messageLabel", "Message");
        props.put("additionalInfo", "");
        labels.put("send", props);
    }
    @GetMapping
    public ModelAndView showEmailPage() {
        ModelAndView model = new ModelAndView("/email");
        MailObject mailObject = new MailObject();
        model.addObject("mailObject", mailObject);
        return model;
    }

    @PostMapping("/send")
    public String createMail(Model model,
                             @ModelAttribute("mailObject") MailObject mailObject) {
        emailService.sendSimpleMessage(new MailObject());

        return "/email";
    }

}
