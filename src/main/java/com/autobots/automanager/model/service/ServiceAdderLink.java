package com.autobots.automanager.model.service;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controller.ServiceController;
import com.autobots.automanager.entity.Service;
import com.autobots.automanager.model.AdderLink;
import com.autobots.automanager.model.enums.ServiceType;

@Component
public class ServiceAdderLink implements AdderLink<Service> {
	@Override
	public void addLink(List<Service> services) {
		for (Service service : services) {
			long id = service.getId();
			Link ownLink = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(ServiceController.class)
							.getService(id))
					.withSelfRel();
			service.add(ownLink);
		}
	}

	@Override
	public void addLink(Service service) {
		Link servicesListLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ServiceController.class)
						.getServices())
				.withRel("services");
		service.add(servicesListLink);

		ServiceType[] serviceTypes = ServiceType.values();

		for (ServiceType type : serviceTypes) {
			Link serviceTypeListLink = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(
									ServiceController.class)
							.getServicesByType(type.toString()))
					.withRel(type.toString());
			service.add(serviceTypeListLink);
		}
	}
}