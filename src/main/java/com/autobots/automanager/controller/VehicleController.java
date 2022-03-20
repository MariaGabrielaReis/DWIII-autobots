package com.autobots.automanager.controller;

import java.util.List;

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
import com.autobots.automanager.model.vehicle.VehicleAdderLink;
import com.autobots.automanager.model.vehicle.VehicleUpdater;
import com.autobots.automanager.repository.VehicleRepository;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {
	@Autowired
	private VehicleRepository vehicleRepository;
	@Autowired
	private VehicleAdderLink vehicleAdderLink;
	@Autowired
	private VehicleUpdater vehicleUpdater;

	@GetMapping("/")
	public ResponseEntity<List<Vehicle>> getVehicles() {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		ResponseEntity<List<Vehicle>> response = new ResponseEntity<>(status);
		if (!vehicles.isEmpty()) {
			status = HttpStatus.FOUND;
			vehicleAdderLink.addLink(vehicles);
			response = new ResponseEntity<List<Vehicle>>(vehicles, status);
		}	
		return response;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Vehicle> getVehicle(@PathVariable long id) {
		Vehicle vehicle = vehicleRepository.getById(id);
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		ResponseEntity<Vehicle> response = new ResponseEntity<>(status);
		if (vehicle != null) {
			status = HttpStatus.FOUND;
			vehicleAdderLink.addLink(vehicle);
			response = new ResponseEntity<Vehicle>(vehicle, status);
		}	
		return response;
	}

	@PostMapping("/create")
	public ResponseEntity<HttpStatus> createVehicle(@RequestBody Vehicle vehicle) {
		HttpStatus status = HttpStatus.CONFLICT;
		if(vehicle.getId() == null){
			vehicleRepository.save(vehicle);
			status = HttpStatus.CREATED;
		}
		return new ResponseEntity<>(status);
	}

	@PutMapping("/update")
	public ResponseEntity<HttpStatus> updateVehicle(@RequestBody Vehicle updatedVehicle) {
		Vehicle vehicle = vehicleRepository.getById(updatedVehicle.getId());

		HttpStatus status = HttpStatus.BAD_REQUEST;
		if(vehicle != null){
			status = HttpStatus.OK;
			vehicleUpdater.update(vehicle, updatedVehicle);
			vehicleRepository.save(vehicle);
		}
		return new ResponseEntity<>(status);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<HttpStatus> deleteVehicle(@RequestBody Vehicle deletedVehicle) {
		Vehicle vehicle = vehicleRepository.getById(deletedVehicle.getId());

		HttpStatus status = HttpStatus.BAD_REQUEST;
		if(vehicle != null){
			status = HttpStatus.OK;
			vehicleRepository.delete(vehicle);
		}
		return new ResponseEntity<>(status);
	}
}