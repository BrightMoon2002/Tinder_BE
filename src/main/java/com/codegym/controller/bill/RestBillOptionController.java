package com.codegym.controller.bill;

import com.codegym.model.receipt.BillOption;
import com.codegym.service.billOption.IBillOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/billOptions")
public class RestBillOptionController {
    @Autowired
    private IBillOptionService billOptionService;

    @GetMapping
    public ResponseEntity<Iterable<BillOption>> getAll() {
        return new ResponseEntity<>(billOptionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Page<BillOption>> getAllPage(@PageableDefault(value = 5)Pageable pageable) {
        return new ResponseEntity<>(billOptionService.findAll(pageable), HttpStatus.OK);
    }
}
