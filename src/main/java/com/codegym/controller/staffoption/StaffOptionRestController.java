package com.codegym.controller.staffoption;

import com.codegym.model.receipt.StaffOption;
import com.codegym.service.staffoption.IStaffOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/staffoption")
public class StaffOptionRestController {
    @Autowired
    IStaffOptionService staffOptionService;

    @GetMapping
    public ResponseEntity<Iterable<StaffOption>> findAllStaffOption() {
        return new ResponseEntity<>(staffOptionService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<StaffOption> saveStaffOption(@RequestBody StaffOption staffOption){
        staffOptionService.save(staffOption);
        return new ResponseEntity<>(staffOption,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StaffOption> updateStaffOption(@PathVariable Long id,@RequestBody StaffOption staffOption){
        Optional<StaffOption> staffOption1 = staffOptionService.findById(id);
        if(!staffOption1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        staffOption.setId(staffOption1.get().getId());
        staffOptionService.save(staffOption);
        return new ResponseEntity<>(staffOption,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StaffOption>findById(@PathVariable Long id){
        Optional<StaffOption> staffOption = staffOptionService.findById(id);
        if(!staffOption.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(staffOption.get(), HttpStatus.OK);
    }

    @GetMapping("/staff/{id}")
    public ResponseEntity<Iterable<StaffOption>>findByStaffId(@PathVariable Long id){
        List<StaffOption> staffOptionList = new ArrayList<>();
        for (StaffOption s: staffOptionService.findAll()) {
            if (s.getStaff().getId().equals(id)) {
                staffOptionList.add(s);
            }
        }

        Iterable<StaffOption> staffOptionIterable = (Iterable<StaffOption>) staffOptionList;

        return new ResponseEntity<>(staffOptionIterable, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StaffOption> delete(@PathVariable Long id){
        Optional<StaffOption> staffOption = staffOptionService.findById(id);
        if (!staffOption.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        staffOptionService.remove(id);
        return new ResponseEntity<>(staffOption.get(),HttpStatus.NO_CONTENT);
    }

}
