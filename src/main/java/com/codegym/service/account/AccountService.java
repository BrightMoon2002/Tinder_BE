package com.codegym.service.account;

import com.codegym.model.account.Account;
import com.codegym.model.account.UserPrinciple;
import com.codegym.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository accountRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public Iterable<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findById(Long id) {
        return accountRepository.findById(id);
    }

    @Override
    public Account save(Account user) {
        user.setPassword(user.getPassword());
        return accountRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> accountOptional = accountRepository.findByUsername(username);
        if (!accountOptional.isPresent()) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails userDetails = UserPrinciple.build(accountOptional.get());
        return userDetails;
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }
}
