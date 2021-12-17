package com.codegym.controller.bill;

import com.codegym.service.email.EmailService;
import com.codegym.model.email.MailObject;
import com.codegym.model.receipt.Bill;
import com.codegym.service.bill.IBillService;
import com.codegym.service.billOption.IBillOptionService;
import com.codegym.service.billstatus.IBillStatusService;
import com.codegym.service.staff.IStaffService;
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
@RequestMapping("/api/bills")
public class RestBillController {

    @Autowired
    private IBillService billService;

    @Autowired
    private IBillOptionService billOptionService;

    @Autowired
    private IBillStatusService billStatusService;

    @Autowired
    private IStaffService staffService;

    @Autowired
    private EmailService emailService;

    @GetMapping
    public ResponseEntity<Iterable<Bill>> getAll() {
        MailObject mailObject = new MailObject("hoangbaoanhng18@gmail.com", "hieudaohn94@gmail.com", "sign in successful", "congratulation Hieu to is first member in tinder windy club, click to: http://localhost:8080/ to dating with KAX ");
        emailService.sendSimpleMessage(mailObject);
        return new ResponseEntity<>(billService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Page<Bill>> showAll(@PageableDefault(value = 5) Pageable pageable) {

        return new ResponseEntity<>(billService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bill> findBillById(@PathVariable Long id) {
        Optional<Bill> billOptional = billService.findById(id);
        if (!billOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(billOptional.get(), HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    @ResponseBody
    public ResponseEntity<Bill> saveBill(@RequestBody Bill bill) {
        return new ResponseEntity<>(billService.save(bill), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Bill> deleteBill(@PathVariable Long id) {
        Optional<Bill> billOptional = billService.findById(id);
        if (!billOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            billService.remove(id);
        }
        return new ResponseEntity<>(billOptional.get(), HttpStatus.OK);
    }



}
