package com.autobots.automanager.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Customer extends RepresentationModel<Customer> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = true)
	private String nickname;
	@Column(unique = true, nullable = true)
	private Long cpf;
	@Column(nullable = true)
	private Long rg;
	@Column(nullable = true)
	private Long phone;
	@Column(nullable = false)
	private String email;
	@Column(nullable = true)
	private LocalDateTime birthDate;
	@Column(nullable = true)
	private LocalDateTime registrationDate;

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