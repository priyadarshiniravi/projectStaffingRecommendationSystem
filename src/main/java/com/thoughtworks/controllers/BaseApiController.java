package com.thoughtworks.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

public class BaseApiController {
    private final RestTemplate restTemplate = new RestTemplate();
    
    @Value("${staffing_api_key}")
    String authorization;
    
    @Value("${base_staffing_url}")
    String baseUrl;
    
    HttpEntity<String> getRequestWithAuthorization() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", authorization);
        return new HttpEntity<>(headers);
    }
    
    String getBaseUrl() {
        return baseUrl;
    }
    
}
