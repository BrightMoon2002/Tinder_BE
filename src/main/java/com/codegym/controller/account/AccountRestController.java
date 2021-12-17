package com.codegym.controller.account;


import com.codegym.model.account.Account;
import com.codegym.model.account.Status;
import com.codegym.model.email.MailObject;
import com.codegym.service.account.IAccountService;
import com.codegym.service.email.EmailService;
import com.codegym.service.email.EmailServiceImpl;
import com.codegym.service.status.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/accounts")
public class AccountRestController {
    @Autowired
    IAccountService accountService;

    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    IStatusService statusService;

    @GetMapping
    public ResponseEntity<Iterable<Account>> findAllAccount() {
        return new ResponseEntity<>(accountService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Account> saveAccount(@RequestBody Account account) {
        accountService.save(account);
        MailObject mailObject = new MailObject("noreply@tinderwindy.com", account.getEmail(), "Account Tinder Windy Verified", "Welcome to Tinder Windy. Please click on the link below to verify this account!!" +"\nhttp://localhost:8080/api/accounts/verify/" + account.getId());
        emailService.sendSimpleMessage(mailObject);
        return new ResponseEntity<>(account,HttpStatus.CREATED);
    }

    @GetMapping("/verify/{id}")
    public ResponseEntity<Account> verifyAccount(@PathVariable Long id) {
        Optional<Account> account = accountService.findById(id);


        if (!account.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


        Status status = statusService.findById(Long.parseLong("1")).get();
        account.get().setStatus(status);
        accountService.save(account.get());

        return new ResponseEntity<>(account.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable Long id, @RequestBody Account account) {
        Optional<Account> account1 = accountService.findById(id);
        if (!account1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        account.setId(account1.get().getId());
        accountService.save(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable Long id) {
        Optional<Account> account = accountService.findById(id);
        if (!account.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account> delete(@PathVariable Long id) {
        Optional<Account> account = accountService.findById(id);
        if (!account.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        accountService.remove(id);
        return new ResponseEntity<>(account.get(), HttpStatus.NO_CONTENT);
    }

}
