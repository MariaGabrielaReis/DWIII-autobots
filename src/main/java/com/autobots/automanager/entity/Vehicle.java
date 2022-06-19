package com.autobots.automanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.hateoas.RepresentationModel;

import com.autobots.automanager.model.enums.Regime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Vehicle extends RepresentationModel<Vehicle> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne(optional = false)
	private User owner;
	@Column(unique = true, nullable = false)
	private String licensePlate;
	@OneToOne
	private VehicleBrand brand;
	@Column(nullable = false)
	private String model;
	@Column(nullable = false)
	private Short year;
	@Column(nullable = false)
	private String engineData;
	@Column(nullable = false)
	private Long currentMileage;
	@Enumerated(EnumType.ORDINAL)
	private Regime regime;
	@Column(nullable = false)
	private String approvedOilViscosity;

	// Filters
	@Column(nullable = false)
	private String approvedAirFilterCode;
	@Column(nullable = false)
	private String approvedOilFilterCode;
	@Column(nullable = false)
	private String approvedFuelFilterCode;
	@Column(nullable = false)
	private String approvedCabinFilterCode;
}