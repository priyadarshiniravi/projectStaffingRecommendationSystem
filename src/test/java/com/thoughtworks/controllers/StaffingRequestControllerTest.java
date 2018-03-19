package com.thoughtworks.controllers;

import com.thoughtworks.models.Staff;
import com.thoughtworks.models.StaffingRequest;
import com.thoughtworks.services.StaffingRequestService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
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
    
    @InjectMocks
    private StaffingRequestController staffingRequestController;
    
    @Mock
    private RestTemplate restTemplate;
    
    @Mock
    private StaffingRequest staffingRequest;
    
    private String staffUrl = "http://localhost:3000/staffs";
    
    @Before
    public void setUp() throws Exception {
        Field restTemplateField = ReflectionUtils.findField(StaffingRequestController.class, "restTemplate");
        ReflectionUtils.makeAccessible(restTemplateField);
        ReflectionUtils.setField(restTemplateField, staffingRequestController, restTemplate);
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
        Staff[] staffs = {new Staff()};
        doNothing().when(staffingRequestService).save(staffingRequest);
        ResponseEntity<Staff[]> staffResponse = new ResponseEntity<>(staffs, OK);
        when(restTemplate.getForEntity(staffUrl+ "?role={role}", Staff[].class , staffingRequest.getRole()))
                .thenReturn(staffResponse);
        
        ResponseEntity responseEntity = staffingRequestController.save(staffingRequest);
        
        verify(staffingRequestService).save(staffingRequest);
        assertThat(responseEntity.getStatusCode()).isEqualTo(CREATED);
        assertThat(responseEntity.getBody()).isEqualTo(staffResponse);
    }
}