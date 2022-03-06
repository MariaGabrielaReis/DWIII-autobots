package com.autobots.automanager.model.vehicle;

import java.util.List;

import com.autobots.automanager.entity.VehicleBrand;

import org.springframework.stereotype.Component;

@Component
public class VehicleBrandPicker {
	public VehicleBrand select(List<VehicleBrand> vehicleBrands, long id) {
		VehicleBrand selected = null;
		for (VehicleBrand vehicleBrand : vehicleBrands) {
			if (vehicleBrand.getId() == id) {
				selected = vehicleBrand;
			}
		}
		return selected;
	}
}