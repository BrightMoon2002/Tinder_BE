package com.codegym.repository.staff;

import com.codegym.model.account.Account;
import com.codegym.model.user.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStaffRepository extends JpaRepository<Staff, Long> {
}
