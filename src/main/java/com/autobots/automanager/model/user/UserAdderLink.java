package com.autobots.automanager.model.user;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controller.UserController;
import com.autobots.automanager.entity.User;
import com.autobots.automanager.model.AdderLink;

@Component
public class UserAdderLink implements AdderLink<User> {
	@Override
	public void addLink(List<User> users) {
		for (User user : users) {
			long id = user.getId();
			Link ownLink = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(UserController.class)
							.getUser(id))
					.withSelfRel();
			user.add(ownLink);
		}
	}

	@Override
	public void addLink(User user) {
		Link allUsersListLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(UserController.class)
						.getUsers())
				.withRel("allUsers");

		Link usersCustomersListLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(UserController.class)
						.getCustomers())
				.withRel("customers");

		Link usersEmployeesListLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(UserController.class)
						.getEmployees())
				.withRel("employees");

		Link usersSuppliersListLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(UserController.class)
						.getSuppliers())
				.withRel("suppliers");

		user.add(allUsersListLink);
		user.add(usersCustomersListLink);
		user.add(usersEmployeesListLink);
		user.add(usersSuppliersListLink);
	}
}