package com.codegym.repository.checker;

import com.codegym.model.user.Checker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICheckerRepository extends JpaRepository<Checker, Long> {
    Optional<Checker> findAllByAccount_Id(Long id);
}
