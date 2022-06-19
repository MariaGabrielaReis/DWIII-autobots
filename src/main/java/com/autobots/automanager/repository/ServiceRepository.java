package com.autobots.automanager.repository;

import java.util.List;

import com.autobots.automanager.entity.Service;
import com.autobots.automanager.model.enums.ServiceType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
  List<Service> findByType(ServiceType type);
}