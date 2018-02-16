package com.thoughtworks.controllers;

import com.thoughtworks.models.StaffingRequest;
import com.thoughtworks.services.StaffingRequestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class StaffingRequestControllerTest {
    @Mock
    private StaffingRequestService staffingRequestService;
    
    private StaffingRequestController staffingRequestController;
    
    @Mock
    private StaffingRequest staffingRequest;
    
    @Before
    public void setUp() throws Exception {
        staffingRequestController = new StaffingRequestController(staffingRequestService);
    }
    
    @Test
    public void shouldGetAllTheStaffingRequests() throws Exception {
        when(staffingRequestService.getAll()).thenReturn(Collections.singletonList(staffingRequest));
        
        ResponseEntity responseEntity = staffingRequestController.getAll();
        List<StaffingRequest> staffingRequests = (List<StaffingRequest>) responseEntity.getBody();
        
        assertThat(staffingRequests.get(0)).isEqualTo(staffingRequest);
        assertThat(responseEntity.getStatusCode()).isEqualTo(OK);
    }
    
    @Test
    public void shouldSaveStaffingRequest() throws Exception {
        doNothing().when(staffingRequestService).save(staffingRequest);
        
        ResponseEntity responseEntity = staffingRequestController.save(staffingRequest);
        
        verify(staffingRequestService).save(staffingRequest);
        assertThat(responseEntity.getStatusCode()).isEqualTo(CREATED);
    }
}