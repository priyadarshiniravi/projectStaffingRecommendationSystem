package com.thoughtworks.controllers;

import com.thoughtworks.Endpoints;
import com.thoughtworks.models.StaffingRequest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping(Endpoints.STAFFING_REQUEST)
public class StaffingRequestController extends BaseApiController {
    private final RestTemplate restTemplate = new RestTemplate();
    
    @RequestMapping
    public ResponseEntity getAllProjects() {
        String url =  getBaseUrl() + "/staffing_requests?offices[]=Pune&group_ids[]=open_role";
        return restTemplate.exchange(url, HttpMethod.GET, getRequestWithAuthorization(), String.class);
    }
    
    @RequestMapping("{requestId}")
    public ResponseEntity<StaffingRequest> getById(@PathVariable Long projectId) {
        String url =  getBaseUrl() + "/staffing_requests?ids[]=" + projectId;
        ResponseEntity<List<StaffingRequest>> projects = restTemplate.exchange(url,
                HttpMethod.GET, getRequestWithAuthorization(), new ParameterizedTypeReference<List<StaffingRequest>>(){});
        return new ResponseEntity<>(projects.getBody().get(0), HttpStatus.OK);
    }
    
}
