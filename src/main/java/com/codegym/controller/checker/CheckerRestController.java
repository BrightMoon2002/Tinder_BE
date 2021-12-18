package com.codegym.controller.checker;

import com.codegym.model.account.Account;
import com.codegym.model.email.MailObject;
import com.codegym.model.receipt.Option;
import com.codegym.model.user.Checker;
import com.codegym.model.user.CheckerDTO;
import com.codegym.model.user.Staff;
import com.codegym.service.account.IAccountService;
import com.codegym.service.checker.ICheckerService;
import com.codegym.service.email.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/checkers")
public class CheckerRestController {
    @Autowired
    ICheckerService checkerService;

    @Autowired
    EmailServiceImpl emailService;

    @Autowired
    IAccountService accountService;

    @GetMapping
    public ResponseEntity<Iterable<Checker>> findAllCheckers() {
        return new ResponseEntity<>(checkerService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Checker> saveChecker(@RequestBody Checker checker) {
        Optional<Account> account = accountService.findById(checker.getAccount().getId());
        checkerService.save(checker);
        MailObject mailObject = new MailObject("noreply@tinderwindy.com", account.get().getEmail(), "Account Tinder Windy Verified", "Welcome to Tinder Windy. Please click on the link below to verify this account!!" +"\nhttp://localhost:8080/api/accounts/verify/" + account.get().getId());
        emailService.sendSimpleMessage(mailObject);
        return new ResponseEntity<>(checker,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Checker> updateChecker(@PathVariable Long id, @RequestBody Checker checker) {
        Optional<Checker> checker1 = checkerService.findById(id);
        if (!checker1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        checker.setId(checker1.get().getId());
        checkerService.save(checker);
        return new ResponseEntity<>(checker, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Checker> findById(@PathVariable Long id) {
        Optional<Checker> checker = checkerService.findById(id);
        if (!checker.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(checker.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Checker> delete(@PathVariable Long id) {
        Optional<Checker> checker = checkerService.findById(id);
        if (!checker.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        checkerService.remove(id);
        return new ResponseEntity<>(checker.get(), HttpStatus.NO_CONTENT);
    }
    @GetMapping("/find/{idAccount}")
    public ResponseEntity<Checker> findByAccountID(@PathVariable Long idAccount){
        Optional<Checker> checker = checkerService.findAllByAccount_Id(idAccount);
        if(!checker.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(checker.get(), HttpStatus.OK);
    }

    //Checker's own APIs
    @GetMapping("/findDTO/{id}")
    public ResponseEntity<CheckerDTO> findDTOById(@PathVariable Long id) {
        Optional<Checker> checker = checkerService.findById(id);
        CheckerDTO checkerDTO = new CheckerDTO(checker.get().getId().toString(), checker.get().getAccount().getId().toString(), checker.get().getName(), checker.get().getDob(), checker.get().getGender().getName(), checker.get().getIdentity(), checker.get().getAddress(), checker.get().getCity(), checker.get().getHobbies(), checker.get().getDescription(), checker.get().getUrl_facebook());
        if (!checker.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(checkerDTO, HttpStatus.OK);
    }
}
