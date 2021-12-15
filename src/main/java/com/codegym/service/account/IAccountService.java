package com.codegym.service.account;

import com.codegym.model.Account;
import com.codegym.service.IGeneralService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IAccountService extends IGeneralService<Account>, UserDetailsService {
    Optional<Account> findByUsername(String username);
}
