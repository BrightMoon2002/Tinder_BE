package com.codegym.controller.checker;

import com.codegym.model.user.Checker;
import com.codegym.service.checker.ICheckerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/checkers")
public class CheckerRestController {
    @Autowired
    ICheckerService checkerService;

    @GetMapping
    public ResponseEntity<Iterable<Checker>> findAllCheckers() {
        return new ResponseEntity<>(checkerService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Checker> saveChecker(@RequestBody Checker checker) {
        checkerService.save(checker);
        return new ResponseEntity<>(checker,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Checker> updateChecker(@PathVariable Long id, @RequestBody Checker checker) {
        Optional<Checker> checker1 = checkerService.findById(id);
        if (!checker1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        checker.setId(checker1.get().getId());
        checkerService.save(checker);
        return new ResponseEntity<>(checker, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Checker> findById(@PathVariable Long id) {
        Optional<Checker> checker = checkerService.findById(id);
        if (!checker.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(checker.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Checker> delete(@PathVariable Long id) {
        Optional<Checker> checker = checkerService.findById(id);
        if (!checker.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        checkerService.remove(id);
        return new ResponseEntity<>(checker.get(), HttpStatus.NO_CONTENT);
    }
}
