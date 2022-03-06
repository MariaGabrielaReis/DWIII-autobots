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

import com.autobots.automanager.entity.VehicleBrand;
import com.autobots.automanager.model.vehicle.VehicleBrandUpdater;
import com.autobots.automanager.model.vehicle.VehicleBrandPicker;
import com.autobots.automanager.repository.VehicleBrandRepository;

@RestController
@RequestMapping("/vehicle/brands")
public class VehicleBrandController {
	@Autowired
	private VehicleBrandRepository vehicleBrandRepository;
	@Autowired
	private VehicleBrandPicker vehicleBrandPicker;
	@Autowired
	private VehicleBrandUpdater vehicleBrandUpdater;

	@GetMapping("/")
	public List<VehicleBrand> getVehicleBrands() {
		List<VehicleBrand> vehicleBrands = vehicleBrandRepository.findAll();
		return vehicleBrands;
	}

	@GetMapping("/{id}")
	public VehicleBrand getVehicleBrand(@PathVariable long id) {
		List<VehicleBrand> vehicleBrands = vehicleBrandRepository.findAll();
		return vehicleBrandPicker.select(vehicleBrands, id);
	}

	@PostMapping("/create")
	public void createVehicleBrand(@RequestBody VehicleBrand vehicleBrand) {
		vehicleBrandRepository.save(vehicleBrand);
	}

	@PutMapping("/update")
	public void updateVehicleBrand(@RequestBody VehicleBrand updatedVehicleBrand) {
		VehicleBrand vehicleBrand = vehicleBrandRepository.getById(updatedVehicleBrand.getId());
		vehicleBrandUpdater.update(vehicleBrand, updatedVehicleBrand);
		vehicleBrandRepository.save(vehicleBrand);
	}

	@DeleteMapping("/delete")
	public void deleteVehicleBrand(@RequestBody VehicleBrand deletedVehicleBrand) {
		VehicleBrand vehicleBrand = vehicleBrandRepository.getById(deletedVehicleBrand.getId());
		vehicleBrandRepository.delete(vehicleBrand);
	}
}
