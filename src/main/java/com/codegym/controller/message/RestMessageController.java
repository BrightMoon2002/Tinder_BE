package com.codegym.controller.message;

import com.codegym.model.message.Message;
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
@RequestMapping("/api/message")
public class RestMessageController {

    @Autowired
    private IMessageService messageService;

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
}
