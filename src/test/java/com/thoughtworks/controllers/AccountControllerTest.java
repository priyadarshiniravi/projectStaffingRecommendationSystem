package com.thoughtworks.controllers;

import com.thoughtworks.models.Account;
import com.thoughtworks.services.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {
    @Mock
    private AccountService accountService;
    
    @InjectMocks
    private AccountController accountController;
    
    @Mock
    private Account account;
    
    @Test
    public void shouldGetAllTheAccounts() throws Exception {
        when(accountService.getAll()).thenReturn(Collections.singletonList(account));
        
        ResponseEntity responseEntity = accountController.getAll();
        List<Account> accounts = (List<Account>) responseEntity.getBody();
        
        assertThat(accounts.get(0)).isEqualTo(account);
        assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
    }
    
    @Test
    public void shouldSaveAccount() throws Exception {
        doNothing().when(accountService).save(account);
        
        ResponseEntity responseEntity = accountController.save(account);
        
        verify(accountService).save(account);
        assertThat(responseEntity.getStatusCode()).isEqualTo(CREATED);
    }
}