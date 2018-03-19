package com.thoughtworks.controllers;

import com.thoughtworks.Endpoints;
import com.thoughtworks.models.Staff;
import com.thoughtworks.models.StaffingRequest;
import com.thoughtworks.services.StaffingRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(Endpoints.STAFFING_REQUEST)
public class StaffingRequestController {
    private final StaffingRequestService staffingRequestService;
    private final RestTemplate restTemplate = new RestTemplate();
    private String staffUrl = "http://localhost:3000/staffs";
    
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    
    @Autowired
    public StaffingRequestController(StaffingRequestService staffingRequestService) {
        this.staffingRequestService = staffingRequestService;
    }
    
    @PostMapping
    public ResponseEntity save(@Validated @RequestBody StaffingRequest staffingRequest) {
        staffingRequestService.save(staffingRequest);
        ResponseEntity<Staff[]> staffs = restTemplate.getForEntity(staffUrl+ "?role={role}", Staff[].class , staffingRequest.getRole());
        return new ResponseEntity<>(staffs, HttpStatus.CREATED);
    }
    
    @RequestMapping
    public ResponseEntity getAll() {
        List<StaffingRequest> staffingRequests = staffingRequestService.getAll();
        return new ResponseEntity<>(staffingRequests, HttpStatus.OK);
    }
    
    @RequestMapping(path = "/mapping")
    public ResponseEntity getMapping()
    {
        return restTemplate.getForEntity(staffUrl , String.class);
    }
}
