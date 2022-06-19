package com.autobots.automanager.repository;

import java.util.List;

import com.autobots.automanager.entity.Sale;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
  List<Sale> findByCustomerId(long id);

  List<Sale> findByEmployeeId(long id);
}