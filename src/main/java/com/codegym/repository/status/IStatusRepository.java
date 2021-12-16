package com.codegym.repository.status;

import com.codegym.model.account.Status;
import com.codegym.model.receipt.StaffOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStatusRepository extends JpaRepository<Status, Long> {
}
