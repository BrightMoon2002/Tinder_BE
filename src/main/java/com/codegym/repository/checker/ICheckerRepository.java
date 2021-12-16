package com.codegym.repository.checker;

import com.codegym.model.user.Checker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICheckerRepository extends JpaRepository<Checker, Long> {
}
