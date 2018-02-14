package com.thoughtworks.controllers;

import com.thoughtworks.Endpoints;
import com.thoughtworks.models.StaffingRequest;
import com.thoughtworks.services.StaffingRequestService;
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
@RequestMapping(Endpoints.STAFFING_REQUEST)
public class StaffingRequestController {
    private final StaffingRequestService staffingRequestService;
    
    @Autowired
    public StaffingRequestController(StaffingRequestService staffingRequestService) {
        this.staffingRequestService = staffingRequestService;
    }
    
    @PostMapping
    public ResponseEntity saveRequestAsDraft(@Validated @RequestBody StaffingRequest staffingRequest) {
        staffingRequestService.save(staffingRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @RequestMapping
    public ResponseEntity getAll()
    {
        List<StaffingRequest> staffingRequests = staffingRequestService.getAll();
        return new ResponseEntity<>(staffingRequests,HttpStatus.OK);
    }
}
