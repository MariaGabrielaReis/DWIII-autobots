package com.autobots.automanager.model.service;

import com.autobots.automanager.entity.Service;
import com.autobots.automanager.model.NullStringVerifier;
import org.springframework.stereotype.Component;

@Component
public class ServiceUpdater {
	private NullStringVerifier verifier = new NullStringVerifier();

	public void update(Service service, Service updatedService) {
		if (!verifier.verify(updatedService.getName())) {
			service.setName(updatedService.getName());
		}
		if (!verifier.verify(updatedService.getDescription())) {
			service.setDescription(updatedService.getDescription());
		}
		if (updatedService.getType() != null) {
			service.setType(updatedService.getType());
		}
		if (updatedService.getPrice() != null) {
			service.setPrice(updatedService.getPrice());
		}
	}
}