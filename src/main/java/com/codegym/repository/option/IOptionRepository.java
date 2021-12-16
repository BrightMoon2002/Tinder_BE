package com.codegym.repository.option;

import com.codegym.model.receipt.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOptionRepository extends JpaRepository<Option, Long> {

}
