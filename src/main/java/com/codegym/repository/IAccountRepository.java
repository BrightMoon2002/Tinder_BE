package com.codegym.repository;

import com.codegym.model.account.Account;
import com.codegym.model.account.Role;
import com.codegym.model.user.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByUsername(String username);
    Optional<Account> findAccountByStaff(Staff staff);
    Optional<Account> findAccountByRoles(Role role);
}
