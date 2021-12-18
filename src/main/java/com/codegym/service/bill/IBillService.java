package com.codegym.service.bill;

import com.codegym.model.receipt.Bill;
import com.codegym.model.user.Checker;
import com.codegym.model.user.Staff;
import com.codegym.service.IGeneralService;

public interface IBillService extends IGeneralService<Bill> {
    Iterable<Bill> findAllByStaff(Staff staff);
    Iterable<Bill> findAllByChecker(Checker checker);
    Iterable<Bill> findAllByStaffIdAndBillStatusId(Long idStaff,Long idStatus);
}
