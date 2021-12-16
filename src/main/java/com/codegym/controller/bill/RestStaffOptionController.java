package com.codegym.controller.bill;

import com.codegym.model.receipt.StaffOption;
import com.codegym.model.user.Staff;
import com.codegym.service.staffoption.IStaffOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/staffOptions")
public class RestStaffOptionController {
    @Autowired
    private IStaffOptionService staffOptionService;

    @GetMapping
    public ResponseEntity<Iterable<StaffOption>> getAll() {
        return new ResponseEntity<>(staffOptionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Page<StaffOption>> getAllPage(@PageableDefault(value = 5)Pageable pageable) {
        return new ResponseEntity<>(staffOptionService.findAll(pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StaffOption> getById(@PathVariable Long id) {
        Optional<StaffOption> staffOptionOptional = staffOptionService.findById(id);
        if (!staffOptionOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(staffOptionOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StaffOption> create(@RequestBody StaffOption staffOption) {
        return new ResponseEntity<>(staffOptionService.save(staffOption), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StaffOption> delete(@PathVariable Long id) {
        Optional<StaffOption> staffOption = staffOptionService.findById(id);
        if (!staffOption.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            staffOptionService.remove(id);
        }
        return new ResponseEntity<>(staffOption.get(), HttpStatus.OK);
    }
}
