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

import com.autobots.automanager.entity.VehicleBrand;
import com.autobots.automanager.model.vehicle.VehicleBrandAdderLink;
import com.autobots.automanager.model.vehicle.VehicleBrandUpdater;
import com.autobots.automanager.repository.VehicleBrandRepository;

@RestController
@RequestMapping("/vehicles/brands")
public class VehicleBrandController {
	@Autowired
	private VehicleBrandRepository vehicleBrandRepository;
	@Autowired
	private VehicleBrandAdderLink vehicleBrandAdderLink;
	@Autowired
	private VehicleBrandUpdater vehicleBrandUpdater;

	@GetMapping("/")
	public ResponseEntity<List<VehicleBrand>> getVehicleBrands() {
		List<VehicleBrand> vehicleBrands = vehicleBrandRepository.findAll();
		if (vehicleBrands.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		vehicleBrandAdderLink.addLink(vehicleBrands);
		return new ResponseEntity<List<VehicleBrand>>(vehicleBrands, HttpStatus.FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<VehicleBrand> getVehicleBrand(@PathVariable long id) {
		Optional<VehicleBrand> vehicleBrandOptional = vehicleBrandRepository.findById(id);
		if (vehicleBrandOptional.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		VehicleBrand vehicleBrand = vehicleBrandOptional.get();
		vehicleBrandAdderLink.addLink(vehicleBrand);
		return new ResponseEntity<VehicleBrand>(vehicleBrand, HttpStatus.FOUND);
	}

	@PostMapping("/create")
	public ResponseEntity<HttpStatus> createVehicleBrand(@RequestBody VehicleBrand vehicleBrand) {
		if (vehicleBrand.getId() != null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);
		}
		vehicleBrandRepository.save(vehicleBrand);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<HttpStatus> updateVehicleBrand(@RequestBody VehicleBrand updatedVehicleBrand) {
		Long id = updatedVehicleBrand.getId();
		if (id == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Optional<VehicleBrand> vehicleBrandOptional = vehicleBrandRepository.findById(id);
		if (vehicleBrandOptional.isEmpty()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		VehicleBrand vehicleBrand = vehicleBrandOptional.get();
		vehicleBrandUpdater.update(vehicleBrand, updatedVehicleBrand);
		vehicleBrandRepository.save(vehicleBrand);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteVehicleBrand(@PathVariable Long id) {
		Optional<VehicleBrand> vehicleBrandOptional = vehicleBrandRepository.findById(id);
		if (vehicleBrandOptional.isEmpty()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		VehicleBrand vehicleBrand = vehicleBrandOptional.get();
		vehicleBrandRepository.delete(vehicleBrand);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}