package com.autobots.automanager.repository;

import java.util.List;

import com.autobots.automanager.entity.Vehicle;
import com.autobots.automanager.entity.VehicleBrand;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
  List<Vehicle> findByBrand(VehicleBrand brand);
}