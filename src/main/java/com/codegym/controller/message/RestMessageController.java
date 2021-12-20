package com.codegym.controller.message;

import com.codegym.model.DTO.IMessageDTO;
import com.codegym.model.account.Account;
import com.codegym.model.message.Message;
import com.codegym.service.account.IAccountService;
import com.codegym.service.message.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/messages")
public class RestMessageController {

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IAccountService accountService;

    @GetMapping
    public ResponseEntity<Iterable<Message>> showAll() {
        Iterable<Message> messages = messageService.findAll();
        if (messages == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(messageService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Page<Message>> showAllPage(@PageableDefault(value = 12) Pageable pageable) {
        return new ResponseEntity<>(messageService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Message> sendMessage(@RequestBody Message message) {
        messageService.save(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Message> editMessage(@RequestBody Message message) {
        messageService.save(message);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Message> deleteMessage(@PathVariable Long id) {
        Optional<Message> messageOptional = messageService.findById(id);
        if (!messageOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        messageService.remove(id);
        return new ResponseEntity<>(messageOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/sender/{id}")
    public ResponseEntity<Iterable<Message>> showAllMessageBySender(@PathVariable Long id) {
        Optional<Account> accountOptional = accountService.findById(id);
        if (!accountOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Iterable<Message> messagesSender = messageService.findAllBySender(accountOptional.get());
        return new ResponseEntity<>(messagesSender, HttpStatus.OK);
    }

    @GetMapping("/receiver/{id}")
    public ResponseEntity<Iterable<Message>> showAllMessageByReceiver(@PathVariable Long id) {
        Optional<Account> accountOptional = accountService.findById(id);
        if (!accountOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Iterable<Message> messagesReceiver = messageService.findAllByReceiver(accountOptional.get());
        return new ResponseEntity<>(messagesReceiver, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Iterable<Message>> showAllMessageByChecker(@PathVariable Long id) {
        Optional<Account> accountOptional = accountService.findById(id);
        if (!accountOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Iterable<Message> messages = messageService.findAllBySenderOrReceiver(accountOptional.get(), accountOptional.get());
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping("/{id1}/{id2}")
    public ResponseEntity<Iterable<IMessageDTO>> showAllMessageByReceiver(@PathVariable(value = "id1") Long id1, @PathVariable(value = "id2") Long id2) {
        Optional<Account> accountOptionalSender = accountService.findById(id1);
        Account accountSender = accountOptionalSender.get();
        Optional<Account> accountOptionalReceiver = accountService.findById(id2);
        if (!accountOptionalSender.isPresent() || !accountOptionalReceiver.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Iterable<IMessageDTO> messages = messageService.showMessageDTO(id1, id2, id2, id1);
//        Iterable<Message> messages = messageService.customFindAllBySenderOrReceiverOrderByReceiver(id2, id1, id1, id2);
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }


}
