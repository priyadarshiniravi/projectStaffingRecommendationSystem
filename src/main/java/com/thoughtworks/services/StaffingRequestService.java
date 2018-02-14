package com.thoughtworks.services;

import com.thoughtworks.models.StaffingRequest;
import com.thoughtworks.repositories.StaffingRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffingRequestService {
    private final StaffingRequestRepository staffingRequestRepository;
    
    @Autowired
    public StaffingRequestService(StaffingRequestRepository staffingRequestRepository) {
        this.staffingRequestRepository = staffingRequestRepository;
    }
    
    public void save(StaffingRequest staffingRequest) {
        staffingRequestRepository.save(staffingRequest);
    }
    
    public List<StaffingRequest> getAll() {
        return staffingRequestRepository.findAll();
    }
}
