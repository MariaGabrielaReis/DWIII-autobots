package com.autobots.automanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.hateoas.RepresentationModel;

import com.autobots.automanager.model.enums.ProductBrand;
import com.autobots.automanager.model.enums.ProductType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends RepresentationModel<Product> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private ProductType type;
	@Column(nullable = false)
	private ProductBrand brand;
	@Column(nullable = true)
	private Float price;
	@Column(nullable = false)
	private Short quantity;
}