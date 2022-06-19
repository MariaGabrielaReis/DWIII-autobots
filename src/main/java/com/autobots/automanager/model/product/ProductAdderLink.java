package com.autobots.automanager.model.product;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import com.autobots.automanager.controller.ProductController;
import com.autobots.automanager.entity.Product;
import com.autobots.automanager.model.AdderLink;
import com.autobots.automanager.model.enums.ProductType;

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
		product.add(productsListLink);

		ProductType[] productTypes = ProductType.values();

		for (ProductType type : productTypes) {
			Link productTypeListLink = WebMvcLinkBuilder
					.linkTo(WebMvcLinkBuilder
							.methodOn(
									ProductController.class)
							.getProductsByType(type.toString()))
					.withRel(type.toString() + "s");
			product.add(productTypeListLink);
		}
	}
}