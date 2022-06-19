package com.autobots.automanager.repository;

import com.autobots.automanager.entity.VehicleBrand;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleBrandRepository extends JpaRepository<VehicleBrand, Long> {
  VehicleBrand findByName(String name);
}