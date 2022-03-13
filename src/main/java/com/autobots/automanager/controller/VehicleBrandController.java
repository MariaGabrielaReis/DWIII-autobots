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

import com.autobots.automanager.entity.VehicleBrand;
import com.autobots.automanager.model.vehicle.VehicleBrandAdderLink;
import com.autobots.automanager.model.vehicle.VehicleBrandUpdater;
import com.autobots.automanager.repository.VehicleBrandRepository;

@RestController
@RequestMapping("/vehicle/brands")
public class VehicleBrandController {
	@Autowired
	private VehicleBrandRepository vehicleBrandRepository;
	@Autowired
	private VehicleBrandAdderLink vehicleBrandAdderLink;
	@Autowired
	private VehicleBrandUpdater vehicleBrandUpdater;

	@GetMapping("/")
	public List<VehicleBrand> getVehicleBrands() {
		List<VehicleBrand> vehicleBrands = vehicleBrandRepository.findAll();
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		// PODE DAR ERRO, TIPO DE LISTA, MAS E SE NÃO TIVER LISTA???
		ResponseEntity<List<VehicleBrand>> response = new ResponseEntity<>(status);
		if (vehicleBrands.isNotEmpty()) {
			status = HttpStatus.FOUND;
			vehicleBrandAdderLink.addLink(vehicleBrands);
			response = new ResponseEntity<List<VehicleBrand>>(vehicleBrands, status);
		}	
		return response;
	}

	@GetMapping("/{id}")
	public VehicleBrand getVehicleBrand(@PathVariable long id) {
		VehicleBrand vehicleBrand = vehicleBrandRepository.getById(id);
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		// PODE DAR ERRO, TIPO "VehicleBrand", MAS E SE NÃO TIVER CLIENTE???
		ResponseEntity<VehicleBrand> response = new ResponseEntity<>(status);
		if (vehicleBrand != null) {
			status = HttpStatus.FOUND;
			vehicleBrandAdderLink.addLink(vehicleBrand);
			response = new ResponseEntity<VehicleBrand>(vehicleBrand, status);
		}	
		return response;
	}

	@PostMapping("/create")
	public void createVehicleBrand(@RequestBody VehicleBrand vehicleBrand) {
		HttpStatus status = HttpStatus.CONFLICT;
		if(vehicleBrand.getId() == null){
			vehicleBrandRepository.save(vehicleBrand);
			status = HttpStatus.CREATED;
		}
		return new ResponseEntity<>(status);
	}

	@PutMapping("/update")
	public void updateVehicleBrand(@RequestBody VehicleBrand updatedVehicleBrand) {
		VehicleBrand vehicleBrand = vehicleBrandRepository.getById(updatedVehicleBrand.getId());
		
		HttpStatus status = HttpStatus.BAD_REQUEST;
		if(vehicleBrand != null){
			status = HttpStatus.OK;
			vehicleBrandUpdater.update(vehicleBrand, updatedVehicleBrand);
			vehicleBrandRepository.save(vehicleBrand);
		}
		return new ResponseEntity<>(status);
	}

	@DeleteMapping("/delete")
	public void deleteVehicleBrand(@RequestBody VehicleBrand deletedVehicleBrand) {
		VehicleBrand vehicleBrand = vehicleBrandRepository.getById(deletedVehicleBrand.getId());

		HttpStatus status = HttpStatus.BAD_REQUEST;
		if(vehicleBrand != null){
			status = HttpStatus.OK;
			vehicleBrandRepository.delete(vehicleBrand);
		}
		return new ResponseEntity<>(status);
	}
}
