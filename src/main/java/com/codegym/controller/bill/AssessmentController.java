package com.codegym.controller.bill;

import com.codegym.model.receipt.Assessment;
import com.codegym.service.assessment.IAssessmentService;
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
@RequestMapping("/api/assessments")
public class AssessmentController {
    @Autowired
    private IAssessmentService assessmentService;

    @GetMapping("/")
    public ResponseEntity<Page<Assessment>> getAll(@PageableDefault(value = 5)Pageable pageable) {
        return new ResponseEntity<>(assessmentService.findAll(pageable), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Assessment> create(@RequestBody Assessment assessment) {
        return new ResponseEntity<>(assessmentService.save(assessment), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Assessment> delete(@PathVariable Long id) {
        Optional<Assessment> assessmentOptional = assessmentService.findById(id);
        if (!assessmentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            assessmentService.remove(id);
        }
        return new ResponseEntity<>(assessmentOptional.get(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Assessment> getById(@PathVariable Long id) {
        Optional<Assessment> assessmentOptional = assessmentService.findById(id);
        if (!assessmentOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(assessmentOptional.get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assessment> updateById(@PathVariable Long id, @RequestBody Assessment assessment) {
        assessment.setId(id);
        Assessment assessment1 = assessmentService.save(assessment);
        return new ResponseEntity<>(assessment1, HttpStatus.OK);
    }
}
