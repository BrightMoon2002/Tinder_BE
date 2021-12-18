package com.codegym.controller.staff;

import com.codegym.model.user.Staff;
import com.codegym.service.staff.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/staffs")
public class StaffRestController {
    @Autowired
    StaffService staffService;

    @GetMapping
    public ResponseEntity<Iterable<Staff>> findAllStaff() {
        return new ResponseEntity<>(staffService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Staff> saveStaff(@RequestBody Staff staff){
        staffService.save(staff);
        return new ResponseEntity<>(staff,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable Long id,@RequestBody Staff staff){
        Optional<Staff> staff1 = staffService.findById(id);
        if(!staff1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        staff.setId(staff1.get().getId());
        staffService.save(staff);
        return new ResponseEntity<>(staff,HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Staff>findById(@PathVariable Long id){
        Optional<Staff> staff = staffService.findById(id);
        if(!staff.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(staff.get(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Staff> delete(@PathVariable Long id){
        Optional<Staff> staff = staffService.findById(id);
        if (!staff.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        staffService.remove(id);
        return new ResponseEntity<>(staff.get(),HttpStatus.NO_CONTENT);
    }
    @GetMapping("/find/{idAccount}")
    public ResponseEntity<Staff> findByAccountID(@PathVariable Long idAccount){
        Optional<Staff> staff = staffService.findAllByAccount_Id(idAccount);
        if(!staff.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(staff.get(), HttpStatus.OK);
    }
}
