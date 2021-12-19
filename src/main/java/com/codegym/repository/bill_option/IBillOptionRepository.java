package com.codegym.repository.bill_option;

import com.codegym.model.receipt.BillOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillOptionRepository extends JpaRepository<BillOption, Long> {
    Iterable<BillOption> findAllByBillId(Long id);
}
