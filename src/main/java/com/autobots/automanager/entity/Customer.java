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

import lombok.Data;

@Data
@Entity
public class Customer {
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
	private Date birthDate;
	@Column(nullable = false)
	private Date registrationDate;
	
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
	private Int number;
	@Column(nullable = true)
	private Int zipCode;
	@Column(nullable = true)
	private String complement;
}