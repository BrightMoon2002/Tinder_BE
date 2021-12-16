package com.codegym.repository.gender;

import com.codegym.model.user.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGenderRepository extends JpaRepository<Gender, Long> {
}
