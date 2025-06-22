package com.example.cms.CMS.repository;

import com.example.cms.CMS.entity.ServiceRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest,Long> {
}
