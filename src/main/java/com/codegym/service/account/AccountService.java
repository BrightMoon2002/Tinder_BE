package com.codegym.service.account;

import com.codegym.model.account.Account;
import com.codegym.model.account.UserPrinciple;
import com.codegym.model.user.Staff;
import com.codegym.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
//        if (user.getUsername()==null || user.getEmail()==null || user.getPassword()== null || user.getFullName() == null) {
//            throw new NullPointerException("information not blank");
//        }
        user.setPassword(user.getPassword());
        return accountRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
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
        System.out.println(username);
        return accountRepository.findByUsername(username);
    }

    @Override
    public Optional<Account> findAccountByStaff(Staff staff) {
        return accountRepository.findAccountByStaff(staff);
    }
}
