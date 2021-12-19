package com.codegym.controller.bill;

import com.codegym.model.account.Account;
import com.codegym.model.receipt.Bill;
import com.codegym.model.receipt.BillOption;
import com.codegym.service.account.IAccountService;
import com.codegym.service.bill.IBillService;
import com.codegym.service.billOption.IBillOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static java.time.temporal.ChronoUnit.HOURS;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/billOptions")
public class RestBillOptionController {
    @Autowired
    private IBillOptionService billOptionService;

    @Autowired
    private IBillService billService;


    @Autowired
    private IAccountService accountService;

    @GetMapping
    public ResponseEntity<Iterable<BillOption>> getAll() {
        return new ResponseEntity<>(billOptionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Page<BillOption>> getAllPage(@PageableDefault(value = 5)Pageable pageable) {
        return new ResponseEntity<>(billOptionService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BillOption> create(@RequestBody BillOption billOption) {
        BillOption billOption1 = billOptionService.save(billOption);

//        Bill bill = billService.findById(billOption.getBill().getId()).get();
//
//        double amount = 0;
//        for (BillOption b : bill.getBillOptionList()) {
//            amount += b.getOption().getPrice();
//        }
//
//        long time = HOURS.between(bill.getDateOrder(), bill.getDateEnd());
//
//        amount = amount * time;
//
//        System.out.println("mmmmm " + amount);
//
//        bill.setAmount(amount);
//        Account accountChecker = bill.getChecker().getAccount();
//        double amountChecker = accountChecker.getBalance() - bill.getAmount();
//        accountChecker.setBalance(amountChecker);
//        accountService.save(accountChecker);
//
//        Optional<Account> accountAdmin = accountService.findById(4L);
//        double amountAdmin = accountAdmin.get().getBalance() + bill.getAmount();
//        accountAdmin.get().setBalance(amountAdmin);
//        accountService.save(accountAdmin.get());

        return new ResponseEntity<>(billOption1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BillOption> deleteById(@PathVariable Long id) {
        Optional<BillOption> billOptionOptional = billOptionService.findById(id);
        if (!billOptionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            billOptionService.remove(id);
        }
        return new ResponseEntity<>(billOptionOptional.get(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BillOption> getById(@PathVariable Long id) {
        Optional<BillOption> billOptionOptional = billOptionService.findById(id);
        if (!billOptionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(billOptionOptional.get(), HttpStatus.OK);
    }
    @GetMapping("/findByBill/{idBill}")
    public ResponseEntity<Iterable<BillOption>> getAllByBill(@PathVariable Long idBill){
        return new ResponseEntity<>(billOptionService.findAllByBillId(idBill), HttpStatus.OK);

    }
}
