package com.codegym.service.assessment;

import com.codegym.model.receipt.Assessment;
import com.codegym.repository.assessment.IAssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AssessmentService implements IAssessmentService{

    @Autowired
    private IAssessmentRepository assessmentRepository;

    @Override
    public Iterable<Assessment> findAll() {
        return assessmentRepository.findAll();
    }

    @Override
    public Optional<Assessment> findById(Long id) {
        return assessmentRepository.findById(id);
    }

    @Override
    public Assessment save(Assessment assessment) {
        return assessmentRepository.save(assessment);
    }

    @Override
    public void remove(Long id) {
        assessmentRepository.deleteById(id);
    }

    @Override
    public Page<Assessment> findAll(Pageable pageable) {
        return assessmentRepository.findAll(pageable);
    }
}
