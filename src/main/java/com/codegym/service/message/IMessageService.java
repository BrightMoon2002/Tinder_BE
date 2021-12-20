package com.codegym.service.message;

import com.codegym.model.message.Message;
import com.codegym.service.IGeneralService;
import com.codegym.service.gender.IGenderService;
import org.springframework.stereotype.Service;

@Service
public interface IMessageService extends IGeneralService<Message> {
}
