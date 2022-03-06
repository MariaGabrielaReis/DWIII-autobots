package com.autobots.automanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entity.Vehicle;
import com.autobots.automanager.model.vehicle.VehicleUpdater;
import com.autobots.automanager.model.vehicle.VehiclePicker;
import com.autobots.automanager.repository.VehicleRepository;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private VehiclePicker vehiclePicker;
	@Autowired
	private VehicleUpdater vehicleUpdater;

	@GetMapping("/")
	public List<Vehicle> getVehicles() {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		return vehicles;
	}

	@GetMapping("/{id}")
	public Vehicle getVehicle(@PathVariable long id) {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		return vehiclePicker.select(vehicles, id);
	}

	@PostMapping("/create")
	public void createVehicle(@RequestBody Vehicle vehicle) {
		vehicleRepository.save(vehicle);
	}

	@PutMapping("/update")
	public void updateVehicle(@RequestBody Vehicle updatedVehicle) {
		Vehicle vehicle = vehicleRepository.getById(updatedVehicle.getId());
		vehicleUpdater.update(vehicle, updatedVehicle);
		vehicleRepository.save(vehicle);
	}

	@DeleteMapping("/delete")
	public void deleteVehicle(@RequestBody Vehicle deletedVehicle) {
		Vehicle vehicle = vehicleRepository.getById(deletedVehicle.getId());
		vehicleRepository.delete(vehicle);
	}
}
