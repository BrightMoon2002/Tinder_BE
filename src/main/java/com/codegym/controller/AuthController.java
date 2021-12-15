package com.codegym.controller;

import com.codegym.model.account.Account;
import com.codegym.model.account.JwtResponse;

import com.codegym.service.account.IAccountService;
import com.codegym.service.jwt.JwtService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private IAccountService accountService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Account account) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(account.getUsername(), account.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Account currentAccount = accountService.findByUsername(account.getUsername()).get();
        return ResponseEntity.ok(new JwtResponse(jwt, currentAccount.getId(), userDetails.getUsername(), currentAccount.getFullName(), userDetails.getAuthorities()));
    }

    @GetMapping("/helloStaff")
    public ResponseEntity<String> hello1() {
        return new ResponseEntity<>("Hello Staff", HttpStatus.OK);
    }

    @GetMapping("/helloAdmin")
    public ResponseEntity<String> hello2() {
        return new ResponseEntity<>("Hello Admin", HttpStatus.OK);
    }
    @GetMapping("/helloCustomer")
    public ResponseEntity<String> hello3() {
        return new ResponseEntity<>("Hello Customer", HttpStatus.OK);
    }
}