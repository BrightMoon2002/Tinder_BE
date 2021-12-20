package com.codegym.service.staff;

import com.codegym.model.user.Staff;
import com.codegym.service.IGeneralService;

import java.util.Optional;

public interface IStaffService extends IGeneralService<Staff> {
    Optional<Staff> findAllByAccount_Id(Long id);
    Iterable<Staff> findAllByGenderId(Long id);
}
