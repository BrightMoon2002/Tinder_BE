//package com.codegym.model.message;
//
//import com.codegym.model.account.Account;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name= "messagePools")
//public class MessagePool {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @ManyToOne(targetEntity = Account.class)
//    private Account senderMessage;
//
//    @ManyToOne(targetEntity = Account.class)
//    private Account receiverMessage;
//
//    @ManyToOne(targetEntity = Message.class)
//    private Message sendingMessage;
//
//    @ManyToOne(targetEntity = Message.class)
//    private Message receivedMessage;
//
//    public MessagePool(Long id, Account sender, Account receiver, Message sendingMessage, Message receivedMessage) {
//        this.id = id;
//        this.senderMessage = sender;
//        this.receiverMessage = receiver;
//        this.sendingMessage = sendingMessage;
//        this.receivedMessage = receivedMessage;
//    }
//
//    public MessagePool() {
//    }
//
//    public MessagePool(Account sender, Account receiver, Message sendingMessage, Message receivedMessage) {
//        this.senderMessage = sender;
//        this.receiverMessage = receiver;
//        this.sendingMessage = sendingMessage;
//        this.receivedMessage = receivedMessage;
//    }
//
//    public MessagePool(Account sender, Account receiver) {
//        this.senderMessage = sender;
//        this.receiverMessage = receiver;
//    }
//
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Account getSenderMessage() {
//        return senderMessage;
//    }
//
//    public void setSenderMessage(Account senderMessage) {
//        this.senderMessage = senderMessage;
//    }
//
//    public Account getReceiverMessage() {
//        return receiverMessage;
//    }
//
//    public void setReceiverMessage(Account receiverMessage) {
//        this.receiverMessage = receiverMessage;
//    }
//
//    public Message getSendingMessage() {
//        return sendingMessage;
//    }
//
//    public void setSendingMessage(Message sendingMessage) {
//        this.sendingMessage = sendingMessage;
//    }
//
//    public Message getReceivedMessage() {
//        return receivedMessage;
//    }
//
//    public void setReceivedMessage(Message receivedMessage) {
//        this.receivedMessage = receivedMessage;
//    }
//}
