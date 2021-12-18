package com.codegym.service.checker;

import com.codegym.model.user.Checker;
import com.codegym.service.IGeneralService;

import java.util.Optional;

public interface ICheckerService extends IGeneralService<Checker> {
    Optional<Checker> findAllByAccount_Id(Long id);
}
