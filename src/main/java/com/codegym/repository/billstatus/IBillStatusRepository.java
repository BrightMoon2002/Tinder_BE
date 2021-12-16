package com.codegym.repository.billstatus;

import com.codegym.model.receipt.BillStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillStatusRepository extends JpaRepository<BillStatus, Long> {

}
