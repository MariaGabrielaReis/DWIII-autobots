package com.autobots.automanager.model.vehicle;

import com.autobots.automanager.entity.VehicleBrand;
import com.autobots.automanager.model.NullStringVerifier;
import org.springframework.stereotype.Component;

@Component
public class VehicleBrandUpdater {
	private NullStringVerifier verifier = new NullStringVerifier();

	public void update(VehicleBrand vechicleBrand, VehicleBrand updatedVechicleBrand) {
		if (!verifier.verify(updatedVechicleBrand.getName())) {
			vechicleBrand.setName(updatedVechicleBrand.getName());
		}
		if (updatedVechicleBrand.getApprovedOilBrands() != null) {
			vechicleBrand.setApprovedOilBrands(updatedVechicleBrand.getApprovedOilBrands());
		}
		if (updatedVechicleBrand.getApprovedAirFilterBrands() != null) {
			vechicleBrand.setApprovedAirFilterBrands(updatedVechicleBrand.getApprovedAirFilterBrands());
		}
		if (updatedVechicleBrand.getApprovedOilFilterBrands() != null) {
			vechicleBrand.setApprovedOilFilterBrands(updatedVechicleBrand.getApprovedOilFilterBrands());
		}
		if (updatedVechicleBrand.getApprovedFuelFilterBrands() != null) {
			vechicleBrand.setApprovedFuelFilterBrands(updatedVechicleBrand.getApprovedFuelFilterBrands());
		}
		if (updatedVechicleBrand.getApprovedCabinFilterBrands() != null) {
			vechicleBrand.setApprovedCabinFilterBrands(updatedVechicleBrand.getApprovedCabinFilterBrands());
		}
	}
}
