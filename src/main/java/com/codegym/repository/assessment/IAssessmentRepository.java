package com.codegym.repository.assessment;

import com.codegym.model.receipt.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAssessmentRepository extends JpaRepository<Assessment, Long> {
}
