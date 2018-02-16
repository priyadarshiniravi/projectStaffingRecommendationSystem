package com.thoughtworks.services;

import com.thoughtworks.models.StaffingRequest;
import com.thoughtworks.repositories.StaffingRequestRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StaffingRequestServiceTest {
    @Mock
    private StaffingRequestRepository staffingRequestRepository;
    
    private StaffingRequestService staffingRequestService;
    
    @Mock
    private StaffingRequest staffingRequest;
    
    @Before
    public void setUp() throws Exception {
        staffingRequestService = new StaffingRequestService(staffingRequestRepository);
    }
    
    @Test
    public void shouldSaveStaffingRequestIntoRepository() throws Exception {
        staffingRequestService.save(staffingRequest);
        
        verify(staffingRequestRepository).save(staffingRequest);
    }
    
    @Test
    public void shouldFindAllFromRepository() throws Exception {
        staffingRequestService.getAll();
        
        verify(staffingRequestRepository).findAll();
    }
    
}