package com.autobots.automanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entity.Vehicle;
import com.autobots.automanager.entity.VehicleBrand;
import com.autobots.automanager.model.vehicle.VehicleAdderLink;
import com.autobots.automanager.model.vehicle.VehicleUpdater;
import com.autobots.automanager.repository.VehicleBrandRepository;
import com.autobots.automanager.repository.VehicleRepository;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private VehicleBrandRepository vehicleBrandRepository;
	@Autowired
	private VehicleAdderLink vehicleAdderLink;
	@Autowired
	private VehicleUpdater vehicleUpdater;

	@GetMapping("/")
	public ResponseEntity<List<Vehicle>> getVehicles() {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		if (vehicles.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		vehicleAdderLink.addLink(vehicles);
		return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Vehicle> getVehicle(@PathVariable long id) {
		Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
		if (vehicleOptional.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Vehicle vehicle = vehicleOptional.get();
		vehicleAdderLink.addLink(vehicle);
		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.FOUND);
	}

	@GetMapping("/brand/{brandName}")
	public ResponseEntity<List<Vehicle>> getVehicleByBrand(@PathVariable String brandName) {
		VehicleBrand vehicleBrand = vehicleBrandRepository.findByName(brandName);
		if (vehicleBrand == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		List<Vehicle> vehicles = vehicleRepository.findByBrand(vehicleBrand);

		if (vehicles.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		vehicleAdderLink.addLink(vehicles);
		return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.FOUND);
	}

	@PostMapping("/create")
	public ResponseEntity<HttpStatus> createVehicle(@RequestBody Vehicle vehicle) {
		if (vehicle.getId() != null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);
		}
		vehicleRepository.save(vehicle);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<HttpStatus> updateVehicle(@RequestBody Vehicle updatedVehicle) {
		Long id = updatedVehicle.getId();
		if (id == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
		if (vehicleOptional.isEmpty()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Vehicle vehicle = vehicleOptional.get();
		vehicleUpdater.update(vehicle, updatedVehicle);
		vehicleRepository.save(vehicle);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteVehicle(@PathVariable Long id) {
		Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
		if (vehicleOptional.isEmpty()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Vehicle vehicle = vehicleOptional.get();
		vehicleRepository.delete(vehicle);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}