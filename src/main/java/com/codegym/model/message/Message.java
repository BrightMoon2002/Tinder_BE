package com.codegym.model.message;

import com.codegym.model.account.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
public class Message {


    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    private String content;

    private LocalDateTime dateSend;

    @ManyToOne(targetEntity = Account.class)

    private Account sender;

    @ManyToOne(targetEntity = Account.class)
    private Account receiver;
}

