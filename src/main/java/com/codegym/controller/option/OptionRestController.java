package com.codegym.controller.option;

import com.codegym.model.account.Status;
import com.codegym.model.receipt.Option;
import com.codegym.service.option.IOptionService;
import com.codegym.service.option.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/options")
public class OptionRestController {
    @Autowired
    IOptionService optionService;

    @GetMapping
    public ResponseEntity<Iterable<Option>> findAllOption() {
        return new ResponseEntity<>(optionService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Option> saveOption(@RequestBody Option option){
        optionService.save(option);
        return new ResponseEntity<>(option,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Option> updateOption(@PathVariable Long id,@RequestBody Option option){
        Optional<Option> option1 = optionService.findById(id);
        if(!option1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        option.setId(option1.get().getId());
        optionService.save(option);
        return new ResponseEntity<>(option,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Option>findById(@PathVariable Long id){
        Optional<Option> option = optionService.findById(id);
        if(!option.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(option.get(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Option> delete(@PathVariable Long id){
        Optional<Option> option = optionService.findById(id);
        if (!option.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        optionService.remove(id);
        return new ResponseEntity<>(option.get(),HttpStatus.NO_CONTENT);
    }
}
