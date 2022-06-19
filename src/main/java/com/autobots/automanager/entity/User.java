package com.autobots.automanager.entity;

import java.time.LocalDateTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.autobots.automanager.model.enums.DocumentType;
import com.autobots.automanager.model.enums.UserRole;

import org.springframework.hateoas.RepresentationModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends RepresentationModel<User> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Enumerated(EnumType.ORDINAL)
	private UserRole role;
	@Column(nullable = false)
	private String name;
	@Column(nullable = true)
	private String nickname;
	@Enumerated(EnumType.ORDINAL)
	private DocumentType documentType;
	@Column(nullable = true)
	private String documentValue;
	@Column(nullable = true)
	private Long phone;
	@Column(nullable = false)
	private String email;
	@Column(nullable = true)
	private LocalDateTime birthDate;
	@Column(nullable = true)
	private LocalDateTime registrationDate;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Credential credential;

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