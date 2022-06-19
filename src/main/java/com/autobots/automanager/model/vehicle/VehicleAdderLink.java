package com.autobots.automanager.model.vehicle;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controller.VehicleBrandController;
import com.autobots.automanager.controller.VehicleController;
import com.autobots.automanager.entity.Vehicle;
import com.autobots.automanager.model.AdderLink;

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
		vehicle.add(vehiclesListLink);

		String vehicleBrandName = vehicle.getBrand().getName();
		Link vehicleBrandLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(
								VehicleController.class)
						.getVehicleByBrand(
								vehicleBrandName))
				.withRel("vehicleBrand");
		vehicle.add(vehicleBrandLink);

		Link vehicleBrandsListLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(VehicleBrandController.class)
						.getVehicleBrands())
				.withRel("vehicleBrands");
		vehicle.add(vehicleBrandsListLink);
	}
}