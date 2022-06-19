package com.autobots.automanager.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Company extends RepresentationModel<Company> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String corporateName;
	@Column(nullable = true)
	private String commercialName;
	@Column(nullable = true)
	private Long phone;
	@Column(nullable = true)
	private LocalDateTime registrationDate;
	@OneToMany
	@Column(nullable = false)
	private List<User> users;
	@OneToMany
	@Column(nullable = true)
	private List<Product> products;
	@OneToMany
	@Column(nullable = true)
	private List<Service> services;
	@OneToMany
	@Column(nullable = true)
	private List<Sale> sales;

	// Address
	@Column(nullable = true)
	private String state;
	@Column(nullable = true)
	private String city;
	@Column(nullable = true)
	private String district;
	@Column(nullable = true)
	private String street;
	@Column(nullable = true)
	private Integer number;
	@Column(nullable = true)
	private Integer zipCode;
	@Column(nullable = true)
	private String complement;
}