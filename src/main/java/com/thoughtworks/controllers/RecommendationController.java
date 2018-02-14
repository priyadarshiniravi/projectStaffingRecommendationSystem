package com.thoughtworks.controllers;

import com.thoughtworks.Endpoints;
import com.thoughtworks.models.StaffingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoints.RECOMMENDATIONS)
public class RecommendationController {
    private final StaffingRequestController staffingRequestController;
    
    @Autowired
    public RecommendationController(StaffingRequestController staffingRequestController) {
        this.staffingRequestController = staffingRequestController;
    }
    
    @RequestMapping
    public ResponseEntity getRecommendationFor(@RequestParam("projectId") Long projectId) {
        StaffingRequest staffingRequest = staffingRequestController.getById(projectId).getBody();
        return new ResponseEntity<>(staffingRequest, HttpStatus.OK);
    }
}

