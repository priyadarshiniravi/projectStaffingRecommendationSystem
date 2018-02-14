package com.thoughtworks;

import com.thoughtworks.controllers.StaffingRequestController;
import com.thoughtworks.controllers.RecommendationController;
import com.thoughtworks.models.StaffingRequest;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RecommendationControllerTest {
    private static final long REQUEST_ID = 123456L;
    @Mock
    private StaffingRequestController staffingRequestController;
    
    @Mock
    private StaffingRequest staffingRequest;
    
    
    @Before
    public void setUp() throws Exception {
        ResponseEntity<StaffingRequest> staffingRequestResponseEntity = new ResponseEntity<>(staffingRequest, HttpStatus.OK);
        when(staffingRequestController.getById(REQUEST_ID)).thenReturn(staffingRequestResponseEntity);
    }
    
    @Test
    public void shouldGetProjectFromProjectController() throws Exception {
        RecommendationController recommendationController = new RecommendationController(staffingRequestController);
        
        recommendationController.getRecommendationFor(REQUEST_ID);
        
        verify(staffingRequestController).getById(REQUEST_ID);
    }
}