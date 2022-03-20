package com.autobots.automanager.controller;

import java.util.List;

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
	public  ResponseEntity<List<Product>> getProducts() {
		List<Product> products = productRepository.findAll();
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		ResponseEntity<List<Product>> response = new ResponseEntity<>(status);
		if (!products.isEmpty()) {
			status = HttpStatus.FOUND;
			productAdderLink.addLink(products);
			response = new ResponseEntity<List<Product>>(products, status);
		}
		return response;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable long id) {
		Product product = productRepository.getById(id);

		HttpStatus status = HttpStatus.NOT_FOUND;
		ResponseEntity<Product> response = new ResponseEntity<>(status);
		if (product != null) {
			status = HttpStatus.FOUND;
			productAdderLink.addLink(product);
			response = new ResponseEntity<Product>(product, status);
		}	
		return response;
	}

	@PostMapping("/create")
	public ResponseEntity<HttpStatus> createProduct(@RequestBody Product product) {
		HttpStatus status = HttpStatus.CONFLICT;
		if(product.getId() == null){
			productRepository.save(product);
			status = HttpStatus.CREATED;
		}
		return new ResponseEntity<>(status);
	}

	@PutMapping("/update")
	public ResponseEntity<HttpStatus> updateProduct(@RequestBody Product updatedProduct) {
		Product product = productRepository.getById(updatedProduct.getId());

		HttpStatus status = HttpStatus.BAD_REQUEST;
		if(product != null){
			status = HttpStatus.OK;
			productUpdater.update(product, updatedProduct);
			productRepository.save(product);
		}
		return new ResponseEntity<>(status);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<HttpStatus> deleteProduct(@RequestBody Product deletedProduct) {
		Product product = productRepository.getById(deletedProduct.getId());
	
		HttpStatus status = HttpStatus.BAD_REQUEST;
		if(product != null){
			status = HttpStatus.OK;
			productRepository.delete(product);
		}
		return new ResponseEntity<>(status);
	}
}