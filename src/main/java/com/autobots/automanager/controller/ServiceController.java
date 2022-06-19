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

import com.autobots.automanager.entity.Service;
import com.autobots.automanager.model.enums.ServiceType;
import com.autobots.automanager.model.service.ServiceAdderLink;
import com.autobots.automanager.model.service.ServiceUpdater;
import com.autobots.automanager.repository.ServiceRepository;

@RestController
@RequestMapping("/services")
public class ServiceController {
	@Autowired
	private ServiceRepository serviceRepository;
	@Autowired
	private ServiceAdderLink serviceAdderLink;
	@Autowired
	private ServiceUpdater serviceUpdater;

	@GetMapping("/")
	public ResponseEntity<List<Service>> getServices() {
		List<Service> services = serviceRepository.findAll();
		if (services.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		serviceAdderLink.addLink(services);
		return new ResponseEntity<List<Service>>(services, HttpStatus.FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Service> getService(@PathVariable long id) {
		Optional<Service> serviceOptional = serviceRepository.findById(id);
		if (serviceOptional.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Service service = serviceOptional.get();
		serviceAdderLink.addLink(service);
		return new ResponseEntity<Service>(service, HttpStatus.FOUND);
	}

	@GetMapping("/type/{typeName}")
	public ResponseEntity<List<Service>> getServicesByType(@PathVariable String typeName) {
		List<Service> services;

		switch (typeName) {
			case "avaliation":
				services = serviceRepository.findByType(ServiceType.avaliation);
				break;
			case "oilChange":
				services = serviceRepository.findByType(ServiceType.oilChange);
				break;
			case "filterChange":
				services = serviceRepository.findByType(ServiceType.filterChange);
				break;
			case "airConditioningCleaning":
				services = serviceRepository.findByType(ServiceType.airConditioningCleaning);
				break;
			case "simpleWash":
				services = serviceRepository.findByType(ServiceType.simpleWash);
				break;
			case "completeWash":
				services = serviceRepository.findByType(ServiceType.completeWash);
				break;
			case "maintenance":
				services = serviceRepository.findByType(ServiceType.maintenance);
				break;
			case "other":
				services = serviceRepository.findByType(ServiceType.other);
				break;

			default:
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		if (services.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		serviceAdderLink.addLink(services);
		return new ResponseEntity<List<Service>>(services, HttpStatus.FOUND);
	}

	@PostMapping("/create")
	public ResponseEntity<HttpStatus> createService(@RequestBody Service service) {
		if (service.getId() != null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);
		}
		serviceRepository.save(service);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<HttpStatus> updateService(@RequestBody Service updatedService) {
		Long id = updatedService.getId();
		if (id == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Optional<Service> serviceOptional = serviceRepository.findById(id);
		if (serviceOptional.isEmpty()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Service service = serviceOptional.get();
		serviceUpdater.update(service, updatedService);
		serviceRepository.save(service);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteService(@PathVariable Long id) {
		Optional<Service> serviceOptional = serviceRepository.findById(id);
		if (serviceOptional.isEmpty()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Service service = serviceOptional.get();
		serviceRepository.delete(service);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
