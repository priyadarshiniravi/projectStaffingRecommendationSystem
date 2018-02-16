package com.thoughtworks.services;

import com.thoughtworks.models.Account;
import com.thoughtworks.repositories.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {
    @Mock
    private AccountRepository accountRepository;
    
    private AccountService accountService;
    
    @Mock
    private Account account;
    
    @Before
    public void setUp() throws Exception {
        accountService = new AccountService(accountRepository);
    }
    
    @Test
    public void shouldSaveAccountIntoRepository() throws Exception {
        accountService.save(account);
        
        verify(accountRepository).save(account);
    }
    
    @Test
    public void shouldFindAllFromRepository() throws Exception {
        accountService.getAll();
        
        verify(accountRepository).findAll();
    }
}