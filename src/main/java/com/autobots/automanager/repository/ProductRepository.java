package com.autobots.automanager.repository;

import com.autobots.automanager.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {}