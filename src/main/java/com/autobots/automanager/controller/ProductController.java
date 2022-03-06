package com.autobots.automanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entity.Product;
import com.autobots.automanager.model.product.ProductUpdater;
import com.autobots.automanager.model.product.ProductPicker;
import com.autobots.automanager.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductPicker productPicker;
	@Autowired
	private ProductUpdater productUpdater;

	@GetMapping("/")
	public List<Product> getproducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable long id) {
		List<Product> products = productRepository.findAll();
		return productPicker.select(products, id);
	}

	@PostMapping("/create")
	public void createProduct(@RequestBody Product product) {
		productRepository.save(product);
	}

	@PutMapping("/update")
	public void updateProduct(@RequestBody Product updatedProduct) {
		Product product = productRepository.getById(updatedProduct.getId());
		productUpdater.update(product, updatedProduct);
		productRepository.save(product);
	}

	@DeleteMapping("/delete")
	public void deleteProduct(@RequestBody Product deletedProduct) {
		Product product = productRepository.getById(deletedProduct.getId());
		productRepository.delete(product);
	}
}
