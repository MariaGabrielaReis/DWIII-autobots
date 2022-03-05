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

import com.autobots.automanager.entity.Customer;
import com.autobots.automanager.entity.VehicleBrand;
import com.autobots.automanager.model.enums.Regime;

import lombok.Data;

@Data
@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToMany(nullable = false)
	private Customer owner;
	@Column(unique = true, nullable = false)
	private String licensePlate;
	@OneToMany(nullable = false)
	private VehicleBrand brand;
	@Column(nullable = false)
	private String model;
	@Column(nullable = false)
	private Short year;
	@Column(nullable = false)
	private String engineData;
	@Column(nullable = false)
	private Long currentMileage;
	@Column(nullable = false)
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