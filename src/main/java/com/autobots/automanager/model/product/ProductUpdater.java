package com.autobots.automanager.model.product;

import com.autobots.automanager.entity.Product;

public class ProductUpdater {
	private NullStringVerifier verifier = new NullStringVerifier();

	public void update(Product product, Product updatedProduct) {
		if (!verifier.verify(updatedProduct.getName())) {
			Product.setName(updatedProduct.getName());
		}
		if (updatedProduct.getType() != null) {
			Product.setType(updatedProduct.getType());
		}
		if (updatedProduct.getBrand() != null) {
			Product.setBrand(updatedProduct.getBrand());
		}
		if (updatedProduct.getPrice() != null) {
			Product.setPrice(updatedProduct.getPrice());
		}
		if (updatedProduct.getQuantity() != null) {
			Product.setQuantity(updatedProduct.getQuantity());
		}
	}
}
