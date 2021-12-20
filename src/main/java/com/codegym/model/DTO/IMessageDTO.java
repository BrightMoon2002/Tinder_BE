package com.codegym.model.DTO;

import java.time.LocalDateTime;

public interface IMessageDTO {
    Long getId();
    String getContent();
    LocalDateTime getDateSend();
    String getNameReceiver();
    String getNameSend();
}
