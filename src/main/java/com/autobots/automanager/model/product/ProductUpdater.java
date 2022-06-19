package com.autobots.automanager.model.product;

import com.autobots.automanager.entity.Product;
import com.autobots.automanager.model.NullStringVerifier;
import org.springframework.stereotype.Component;

@Component
public class ProductUpdater {
	private NullStringVerifier verifier = new NullStringVerifier();

	public void update(Product product, Product updatedProduct) {
		if (!verifier.verify(updatedProduct.getName())) {
			product.setName(updatedProduct.getName());
		}
		if (updatedProduct.getCategory() != null) {
			product.setCategory(updatedProduct.getCategory());
		}
		if (updatedProduct.getType() != null) {
			product.setType(updatedProduct.getType());
		}
		if (updatedProduct.getBrand() != null) {
			product.setBrand(updatedProduct.getBrand());
		}
		if (updatedProduct.getPrice() != null) {
			product.setPrice(updatedProduct.getPrice());
		}
		if (updatedProduct.getQuantity() != null) {
			product.setQuantity(updatedProduct.getQuantity());
		}
	}
}