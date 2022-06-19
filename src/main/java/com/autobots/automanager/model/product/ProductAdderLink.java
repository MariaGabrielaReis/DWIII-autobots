package com.autobots.automanager.model.product;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controller.ProductController;
import com.autobots.automanager.entity.Product;
import com.autobots.automanager.model.AdderLink;

@Component
public class ProductAdderLink implements AdderLink<Product> {
	@Override
	public void addLink(List<Product> products) {
		for (Product product : products) {
			long id = product.getId();
			Link ownLink = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(ProductController.class)
							.getProduct(id))
					.withSelfRel();
			product.add(ownLink);
		}
	}

	@Override
	public void addLink(Product product) {
		Link productsListLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ProductController.class)
						.getProducts())
				.withRel("products");

		Link productTypeFilterListLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ProductController.class)
						.getProductsByType("filter"))
				.withRel("filters");

		Link productTypeLampListLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ProductController.class)
						.getProductsByType("lamp"))
				.withRel("lamps");

		Link productTypeOilListLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ProductController.class)
						.getProductsByType("oil"))
				.withRel("oils");

		Link productTypeOtherListLink = WebMvcLinkBuilder
				.linkTo(WebMvcLinkBuilder
						.methodOn(ProductController.class)
						.getProductsByType("other"))
				.withRel("others");

		product.add(productsListLink);
		product.add(productTypeFilterListLink);
		product.add(productTypeLampListLink);
		product.add(productTypeOilListLink);
		product.add(productTypeOtherListLink);
	}
}