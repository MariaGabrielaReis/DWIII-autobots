package com.autobots.automanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entity.Product;
import com.autobots.automanager.model.enums.ProductType;
import com.autobots.automanager.model.product.ProductAdderLink;
import com.autobots.automanager.model.product.ProductUpdater;
import com.autobots.automanager.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductAdderLink productAdderLink;
	@Autowired
	private ProductUpdater productUpdater;

	@GetMapping("/")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> products = productRepository.findAll();
		if (products.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		productAdderLink.addLink(products);
		return new ResponseEntity<List<Product>>(products, HttpStatus.FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable long id) {
		Optional<Product> productOptional = productRepository.findById(id);
		if (productOptional.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Product product = productOptional.get();
		productAdderLink.addLink(product);
		return new ResponseEntity<Product>(product, HttpStatus.FOUND);
	}

	@GetMapping("/type/{typeName}")
	public ResponseEntity<List<Product>> getProductsByType(@PathVariable String typeName) {
		List<Product> products;

		switch (typeName) {
			case "filter":
				products = productRepository.findByType(ProductType.filter);
				break;
			case "lamp":
				products = productRepository.findByType(ProductType.lamp);
				break;
			case "oil":
				products = productRepository.findByType(ProductType.oil);
				break;
			case "other":
				products = productRepository.findByType(ProductType.other);
				break;
			default:
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		if (products.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		productAdderLink.addLink(products);
		return new ResponseEntity<List<Product>>(products, HttpStatus.FOUND);
	}

	@PostMapping("/create")
	public ResponseEntity<HttpStatus> createProduct(@RequestBody Product product) {
		if (product.getId() != null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);
		}
		productRepository.save(product);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<HttpStatus> updateProduct(@RequestBody Product updatedProduct) {
		Long id = updatedProduct.getId();
		if (id == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Optional<Product> productOptional = productRepository.findById(id);
		if (productOptional.isEmpty()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Product product = productOptional.get();
		productUpdater.update(product, updatedProduct);
		productRepository.save(product);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable Long id) {
		Optional<Product> productOptional = productRepository.findById(id);
		if (productOptional.isEmpty()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Product product = productOptional.get();
		productRepository.delete(product);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
