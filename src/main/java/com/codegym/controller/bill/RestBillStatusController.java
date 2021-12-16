package com.codegym.controller.bill;

import com.codegym.model.receipt.BillStatus;
import com.codegym.service.billstatus.IBillStatusService;
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
@RequestMapping("/api/billStatus")
public class RestBillStatusController {
    @Autowired
    private IBillStatusService billStatusService;

    @GetMapping
    public ResponseEntity<Iterable<BillStatus>> getAll() {
        return new ResponseEntity<>(billStatusService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Page<BillStatus>> getAllPage(@PageableDefault(value = 5)Pageable pageable) {
        return new ResponseEntity<>(billStatusService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BillStatus> createBill (@RequestBody BillStatus billStatus) {
        return new ResponseEntity<>(billStatusService.save(billStatus), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BillStatus> deleteById(@PathVariable Long id) {
        Optional<BillStatus> billStatusOptional = billStatusService.findById(id);
        if (!billStatusOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            billStatusService.remove(id);
        }
        return new ResponseEntity<>(billStatusOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillStatus> getById(@PathVariable Long id) {
        Optional<BillStatus> billStatusOptional = billStatusService.findById(id);
        if (!billStatusOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(billStatusOptional.get(), HttpStatus.OK);
    }
}
