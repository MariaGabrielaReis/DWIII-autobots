package com.autobots.automanager.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.autobots.automanager.entity.Customer;
import com.autobots.automanager.entity.Vehicle;
import com.autobots.automanager.entity.Product;

import com.autobots.automanager.model.enums.ProductType;
import com.autobots.automanager.model.enums.Service;

import lombok.Data;

public interface ServicePerfomedProduct {
	public Long id;
	public String name;
	public ProductType type;
	public ProductBrand brand;
	public Byte quantity;
	public Float price?; // opcional
}

public interface ServicePerfomedService {
	public Long id;
	public Service name;
	public String responsibleEmployeeName;
	public Float price?; // opcional
}

@Data
@Entity
public class ServicePerfomed {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Date date;
	@OneToMany(nullable = false)
	private Customer customer;
	@OneToMany(nullable = false)
	private Vehicle vehicle;
	@Column(nullable = false)
	private List<ServicePerfomedService> services;
	@Column(nullable = true)
	private List<ServicePerfomedProduct> products;
	@Column(nullable = false)
	private Float totalPrice;
	@Column(nullable = true)
	private String observations;
	@Column(nullable = false)
	private Date nextReview;
}