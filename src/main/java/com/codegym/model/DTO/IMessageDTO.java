package com.codegym.model.DTO;

import java.time.LocalDateTime;

public interface IMessageDTO {
    Long getId();
    String content();
    LocalDateTime dateSend();
    String nameReceiver();
    String nameSend();
}
