package com.codegym.controller.bill;

import com.codegym.model.receipt.Bill;
import com.codegym.model.receipt.Option;
import com.codegym.service.option.IOptionService;
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
@RequestMapping("/api/option")
public class RestOptionController {

    @Autowired
    private IOptionService optionService;

    @GetMapping
    private ResponseEntity<Iterable<Option>> getAll() {
        return new ResponseEntity<>(optionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/")
    private ResponseEntity<Page<Option>> getAllPage(@PageableDefault(value = 5) Pageable pageable) {
        return new ResponseEntity<>(optionService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Option> create(@RequestBody Option option) {
        return new ResponseEntity<>(optionService.save(option), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Option> getById(@PathVariable Long id) {
        Optional<Option> optionalOption = optionService.findById(id);
        if (!optionalOption.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(optionalOption.get(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    private ResponseEntity<Option> delete(@PathVariable Long id) {
        Optional<Option> optionalOption = optionService.findById(id);
        if (!optionalOption.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            optionService.remove(id);
        }
        return new ResponseEntity<>(optionalOption.get(), HttpStatus.OK);
    }
}
