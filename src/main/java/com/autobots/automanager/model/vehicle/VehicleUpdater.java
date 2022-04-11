package com.autobots.automanager.model.vehicle;

import com.autobots.automanager.entity.Vehicle;
import com.autobots.automanager.model.NullStringVerifier;
import org.springframework.stereotype.Component;

@Component
public class VehicleUpdater {
	private NullStringVerifier verifier = new NullStringVerifier();

	public void update(Vehicle vechicle, Vehicle updatedVechicle) {
		if (updatedVechicle.getOwner() != null) {
			vechicle.setOwner(updatedVechicle.getOwner());
		}
		if (!verifier.verify(updatedVechicle.getLicensePlate())) {
			vechicle.setLicensePlate(updatedVechicle.getLicensePlate());
		}
		if (updatedVechicle.getBrand() != null) {
			vechicle.setBrand(updatedVechicle.getBrand());
		}
		if (!verifier.verify(updatedVechicle.getModel())) {
			vechicle.setModel(updatedVechicle.getModel());
		}
		if (updatedVechicle.getYear() != null) {
			vechicle.setYear(updatedVechicle.getYear());
		}
		if (!verifier.verify(updatedVechicle.getEngineData())) {
			vechicle.setEngineData(updatedVechicle.getEngineData());
		}
		if (updatedVechicle.getCurrentMileage() != null) {
			vechicle.setCurrentMileage(updatedVechicle.getCurrentMileage());
		}
		if (updatedVechicle.getRegime() != null) {
			vechicle.setRegime(updatedVechicle.getRegime());
		}
		if (!verifier.verify(updatedVechicle.getApprovedOilViscosity())) {
			vechicle.setApprovedOilViscosity(updatedVechicle.getApprovedOilViscosity());
		}
		if (!verifier.verify(updatedVechicle.getApprovedAirFilterCode())) {
			vechicle.setApprovedAirFilterCode(updatedVechicle.getApprovedAirFilterCode());
		}
		if (!verifier.verify(updatedVechicle.getApprovedOilFilterCode())) {
			vechicle.setApprovedOilFilterCode(updatedVechicle.getApprovedOilFilterCode());
		}
		if (!verifier.verify(updatedVechicle.getApprovedFuelFilterCode())) {
			vechicle.setApprovedFuelFilterCode(updatedVechicle.getApprovedFuelFilterCode());
		}
		if (!verifier.verify(updatedVechicle.getApprovedCabinFilterCode())) {
			vechicle.setApprovedCabinFilterCode(updatedVechicle.getApprovedCabinFilterCode());
		}
	}
}