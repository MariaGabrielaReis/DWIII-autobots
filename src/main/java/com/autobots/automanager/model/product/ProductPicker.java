package com.autobots.automanager.model.product;

import java.util.List;

import com.autobots.automanager.entity.Product;

import org.springframework.stereotype.Component;

@Component
public class ProductPicker {
	public Product select(List<Product> products, long id) {
		Product selected = null;
		for (Product product : products) {
			if (product.getId() == id) {
				selected = product;
			}
		}
		return selected;
	}
}