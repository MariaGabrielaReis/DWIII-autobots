package com.autobots.automanager.entity;

package com.autobots.automanager.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class VehicleBrand  extends RepresentationModel<VehicleBrand>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private List<ProductBrand> approvedOilBrands;

	// Brands of filter approved
	@Column(nullable = false)
	private List<ProductBrand> approvedAirFilterBrands;
	@Column(nullable = false)
	private List<ProductBrand> approvedOilFilterBrands;
	@Column(nullable = false)
	private List<ProductBrand> approvedFuelFilterBrands;
	@Column(nullable = false)
	private List<ProductBrand> approvedCabinFilterBrands;
}