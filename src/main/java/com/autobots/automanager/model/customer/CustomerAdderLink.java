package com.autobots.automanager.model.customer;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controller.CustomerController;
import com.autobots.automanager.entity.Customer;
import com.autobots.automanager.model.AdderLink;

@Component
public class CustomerAdderLink implements AdderLink<Customer> {
	@Override
	public void addLink(List<Customer> customers) {
		for (Customer customer : customers) {
			long id = customer.getId();
			Link ownLink = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(CustomerController.class)
							.getCustomer(id))
					.withSelfRel();
			customer.add(ownLink);
		}
	}

	@Override
	public void addLink(Customer customer) {
		Link customersListLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(CustomerController.class)
						.getCustomers())
				.withRel("customers");
		customer.add(customersListLink);
	}
}