package com.autobots.automanager.model.user;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controller.SaleController;
import com.autobots.automanager.controller.UserController;
import com.autobots.automanager.entity.User;
import com.autobots.automanager.model.AdderLink;
import com.autobots.automanager.model.enums.UserRole;

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
		Link usersListLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(UserController.class)
						.getUsers())
				.withRel("users");
		user.add(usersListLink);

		if (UserRole.employee == user.getRole()) {
			Link userSalesListLink = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(SaleController.class)
							.getSalesByEmployeeId(
									user.getId()))
					.withRel("userSales");
			user.add(userSalesListLink);

		} else if (UserRole.customer == user.getRole()) {
			Link userSalesListLink = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(SaleController.class)
							.getSalesByCustomerId(
									user.getId()))
					.withRel("userSales");
			user.add(userSalesListLink);
		}

		UserRole[] userRoles = UserRole.values();

		for (UserRole role : userRoles) {
			Link userRolesListLink = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(
									UserController.class)
							.getUserByRole(role.toString()))
					.withRel(role.toString() + "s");
			user.add(userRolesListLink);
		}
	}
}