package com.codegym.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@CrossOrigin("*")
public class AccountExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView exception(Exception e) {
        System.out.println("error" + e.getMessage());
        ModelAndView model = new ModelAndView("/error-404");
        return model;
    }
}
