package com.autobots.automanager.model.company;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controller.CompanyController;
import com.autobots.automanager.entity.Company;
import com.autobots.automanager.model.AdderLink;

@Component
public class CompanyAdderLink implements AdderLink<Company> {
	@Override
	public void addLink(List<Company> companies) {
		for (Company company : companies) {
			long id = company.getId();
			Link ownLink = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(CompanyController.class)
							.getCompany(id))
					.withSelfRel();
			company.add(ownLink);
		}
	}

	@Override
	public void addLink(Company company) {
		Link companiesListLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(
								CompanyController.class)
						.getCompanies())
				.withRel("companies");
		company.add(companiesListLink);
	}
}