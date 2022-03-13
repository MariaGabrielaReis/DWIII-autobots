package com.autobots.automanager.modelos;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controller.VehicleController;
import com.autobots.automanager.controller.VehicleBrandController;
import com.autobots.automanager.entity.Vehicle;

@Component
public class VehicleAdderLink implements AdderLink<Vehicle> {
	@Override
	public void addLink(List<Vehicle> vehicles) {
		for (Vehicle vehicle : vehicles) {
			long id = vehicle.getId();
			Link ownLink = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(VehicleController.class)
							.getVehicle(id))
					.withSelfRel();
			vehicle.add(ownLink);
		}
	}

	@Override
	public void addLink(Vehicle vehicle) {
		Link vehiclesListLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(VehicleController.class)
						.getVehicles())
				.withRel("vehicles");

		long vehicleBrandId = vehicle.getVehicleBrand().getId();
		Link vehicleBrandLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(VehicleBrandController.class)
						.getVehicleBrand(vehicleBrandId))
				.withRel("vehicleBrand");

		Link vehicleBrandsListLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(VehicleBrandController.class)
						.getVehicleBrands())
				.withRel("vehicleBrands");

		vehicle.add(vehiclesListLink);
		vehicle.add(vehicleBrandLink);
		vehicle.add(vehicleBrandsListLink);
	}
}