package com.codegym.controller.gender;

import com.codegym.model.user.Gender;
import com.codegym.service.gender.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/avatar")
public class GenderRestController {
    @Autowired
    IGenderService genderService;

    @GetMapping
    public ResponseEntity<Iterable<Gender>> findAllGenders() {
        return new ResponseEntity<>(genderService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Gender> saveGender(@RequestBody Gender gender) {
        genderService.save(gender);
        return new ResponseEntity<>(gender,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gender> updateGender(@PathVariable Long id, @RequestBody Gender gender) {
        Optional<Gender> gender1 = genderService.findById(id);
        if (!gender1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        gender.setId(gender1.get().getId());
        genderService.save(gender);
        return new ResponseEntity<>(gender, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Gender> findById(@PathVariable Long id) {
        Optional<Gender> gender = genderService.findById(id);
        if (!gender.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(gender.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Gender> delete(@PathVariable Long id) {
        Optional<Gender> gender = genderService.findById(id);
        if (!gender.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        genderService.remove(id);
        return new ResponseEntity<>(gender.get(), HttpStatus.NO_CONTENT);
    }
}
