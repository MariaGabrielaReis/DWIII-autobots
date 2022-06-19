package com.autobots.automanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.hateoas.RepresentationModel;

import com.autobots.automanager.model.enums.ProductBrand;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class VehicleBrand extends RepresentationModel<VehicleBrand> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Enumerated(EnumType.ORDINAL)
	private ProductBrand approvedOilBrands;

	// Brands of filter approved
	@Enumerated(EnumType.ORDINAL)
	private ProductBrand approvedAirFilterBrands;
	@Enumerated(EnumType.ORDINAL)
	private ProductBrand approvedOilFilterBrands;
	@Enumerated(EnumType.ORDINAL)
	private ProductBrand approvedFuelFilterBrands;
	@Enumerated(EnumType.ORDINAL)
	private ProductBrand approvedCabinFilterBrands;
}