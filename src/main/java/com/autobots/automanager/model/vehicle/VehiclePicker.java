package com.autobots.automanager.model.vehicle;

import java.util.List;

import com.autobots.automanager.entity.Vehicle;

import org.springframework.stereotype.Component;

@Component
public class VehiclePicker {
	public Vehicle select(List<Vehicle> vehicles, String licensePlate) {
		Vehicle selected = null;
		for (Vehicle vehicle : vehicles) {
			if (vehicle.getLicencePlate() == licensePlate) {
				selected = vehicle;
			}
		}
		return selected;
	}
}