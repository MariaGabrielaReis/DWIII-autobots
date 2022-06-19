package com.autobots.automanager.repository;

import java.util.List;

import com.autobots.automanager.entity.Product;
import com.autobots.automanager.model.enums.ProductBrand;
import com.autobots.automanager.model.enums.ProductCategory;
import com.autobots.automanager.model.enums.ProductType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
  List<Product> findByCategory(ProductCategory category);

  List<Product> findByType(ProductType type);

  List<Product> findByBrand(ProductBrand brand);
}