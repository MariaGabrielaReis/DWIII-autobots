package com.autobots.automanager.model.sale;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controller.SaleController;
import com.autobots.automanager.entity.Sale;
import com.autobots.automanager.model.AdderLink;

@Component
public class SaleAdderLink implements AdderLink<Sale> {
	@Override
	public void addLink(List<Sale> sales) {
		for (Sale sale : sales) {
			long id = sale.getId();
			Link ownLink = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(
									SaleController.class)
							.getSale(id))
					.withSelfRel();
			sale.add(ownLink);
		}
	}

	@Override
	public void addLink(Sale sale) {
		Link salesListLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(SaleController.class)
						.getSales())
				.withRel("sales");

		sale.add(salesListLink);
	}
}