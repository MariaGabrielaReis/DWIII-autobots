package com.autobots.automanager.model.vehicle;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controller.VehicleBrandController;
import com.autobots.automanager.entity.VehicleBrand;
import com.autobots.automanager.model.AdderLink;

@Component
public class VehicleBrandAdderLink implements AdderLink<VehicleBrand> {
	@Override
	public void addLink(List<VehicleBrand> vehicleBrands) {
		for (VehicleBrand vehicleBrand : vehicleBrands) {
			long id = vehicleBrand.getId();
			Link ownLink = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(VehicleBrandController.class)
							.getVehicleBrand(id))
					.withSelfRel();
			vehicleBrand.add(ownLink);
		}
	}

	@Override
	public void addLink(VehicleBrand vehicleBrand) {
		Link vehicleBrandsListLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(VehicleBrandController.class)
						.getVehicleBrands())
				.withRel("vehicleBrands");

		vehicleBrand.add(vehicleBrandsListLink);
	}
}