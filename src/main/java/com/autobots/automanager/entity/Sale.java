package com.autobots.automanager.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Sale extends RepresentationModel<Sale> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	private User employee;
	@OneToOne(optional = false)
	private User customer;
	@OneToOne
	private Vehicle vehicle;
	@OneToMany
	@Column(nullable = true)
	private List<Product> products;
	@OneToMany
	@Column(nullable = true)
	private List<Service> services;
	@Column(nullable = true)
	private Double discont;
	@Column(nullable = false)
	private Double total;
	@Column(nullable = true)
	private Double totalWithDiscont;
}