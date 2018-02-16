package com.thoughtworks.controllers;

import com.thoughtworks.Endpoints;
import com.thoughtworks.models.Account;
import com.thoughtworks.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Endpoints.ACCOUNT)
public class AccountController {
    private final AccountService accountService;
    
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }
    
    @PostMapping
    public ResponseEntity save(@Validated @RequestBody Account account) {
        accountService.save(account);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping
    public ResponseEntity getAll() {
        List<Account> accounts = accountService.getAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }
}
