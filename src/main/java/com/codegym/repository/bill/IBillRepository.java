package com.codegym.repository.bill;

import com.codegym.model.receipt.Bill;
import com.codegym.model.DTO.IBillDTo;
import com.codegym.model.user.Checker;
import com.codegym.model.user.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepository extends JpaRepository<Bill, Long> {
    Iterable<Bill> findAllByStaff(Staff staff);
    Iterable<Bill> findAllByChecker(Checker checker);
    Iterable<Bill> findAllByStaffIdAndBillStatusId(Long idStaff,Long idStatus);
    @Query(value = "select sum(amount) from bills b join staffs s on b.staff_id = s.id join checkers c on b.checker_id = c.id where b.checker_id = :checker_id and b.staff_id = :staff_id", nativeQuery = true)
    double sumAmountBill(@Param("staff_id") Long staff_id, @Param("checker_id") Long checker_id);
    @Query(value = "select b.id as id, s.name as staff_name, a.content as content from bills b join staffs s on b.staff_id = s.id join checkers c on b.checker_id = c.id join assessments a on a.id = b.assessment_id", nativeQuery = true)
    Iterable<IBillDTo> customShowBillWithContent();
}
