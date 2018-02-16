package com.thoughtworks.services;

import com.thoughtworks.models.Account;
import com.thoughtworks.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    
    public void save(Account account) {
        accountRepository.save(account);
    }
    
    public List<Account> getAll() {
        return accountRepository.findAll();
    }
}
