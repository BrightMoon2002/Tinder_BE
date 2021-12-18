package com.codegym.repository.bill;

import com.codegym.model.receipt.Bill;
import com.codegym.model.user.Checker;
import com.codegym.model.user.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepository extends JpaRepository<Bill, Long> {
    Iterable<Bill> findAllByStaff(Staff staff);
    Iterable<Bill> findAllByChecker(Checker checker);
    Iterable<Bill> findAllByStaffIdAndBillStatusId(Long idStaff,Long idStatus);
}
