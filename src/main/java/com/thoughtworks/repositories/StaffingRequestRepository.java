package com.thoughtworks.repositories;

import com.thoughtworks.models.StaffingRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffingRequestRepository extends JpaRepository<StaffingRequest, Long> {
}
