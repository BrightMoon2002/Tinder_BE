package com.codegym.repository.checker;

import com.codegym.model.user.Checker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICheckerRepository extends JpaRepository<Checker, Long> {
}
