package com.autobots.automanager.modelos;

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
		product.add(productsListLink);
	}
}