package com.codegym.controller.status;


import com.codegym.model.account.Status;
import com.codegym.service.status.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/status")
public class StatusRestController {
    @Autowired
    StatusService statusService;

    @GetMapping
    public ResponseEntity<Iterable<Status>> findAllStatus() {
        return new ResponseEntity<>(statusService.findAll(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Status> saveStatus(@RequestBody Status status){
        statusService.save(status);
        return new ResponseEntity<>(status,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Status> updateStatus(@PathVariable Long id,@RequestBody Status status){
        Optional<Status> status1 = statusService.findById(id);
        if(!status1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        status.setId(status1.get().getId());
        statusService.save(status);
        return new ResponseEntity<>(status,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Status>findById(@PathVariable Long id){
        Optional<Status> status = statusService.findById(id);
        if(!status.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(status.get(), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Status> delete(@PathVariable Long id){
        Optional<Status> status = statusService.findById(id);
        if (!status.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        statusService.remove(id);
        return new ResponseEntity<>(status.get(),HttpStatus.NO_CONTENT);
    }
}
