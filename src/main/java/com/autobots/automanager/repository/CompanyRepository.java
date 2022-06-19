package com.autobots.automanager.repository;

import com.autobots.automanager.entity.Company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}