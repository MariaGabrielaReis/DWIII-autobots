package com.autobots.automanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entity.Product;
import com.autobots.automanager.entity.Sale;
import com.autobots.automanager.entity.Service;
import com.autobots.automanager.model.sale.SaleAdderLink;
import com.autobots.automanager.repository.SaleRepository;

@RestController
@RequestMapping("/sales")
public class SaleController {
	@Autowired
	private SaleRepository saleRepository;
	@Autowired
	private SaleAdderLink saleAdderLink;

	@GetMapping("/")
	public ResponseEntity<List<Sale>> getSales() {
		List<Sale> sales = saleRepository.findAll();
		if (sales.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		saleAdderLink.addLink(sales);
		return new ResponseEntity<List<Sale>>(sales, HttpStatus.FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Sale> getSale(@PathVariable long id) {
		Optional<Sale> saleOptional = saleRepository.findById(id);
		if (saleOptional.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Sale sale = saleOptional.get();
		saleAdderLink.addLink(sale);
		return new ResponseEntity<Sale>(sale, HttpStatus.FOUND);
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<List<Sale>> getSalesByEmployeeId(@PathVariable long id) {
		List<Sale> sales = saleRepository.findByEmployeeId(id);
		if (sales.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		saleAdderLink.addLink(sales);
		return new ResponseEntity<List<Sale>>(sales, HttpStatus.FOUND);
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<List<Sale>> getSalesByCustomerId(@PathVariable long id) {
		List<Sale> sales = saleRepository.findByCustomerId(id);
		if (sales.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		saleAdderLink.addLink(sales);
		return new ResponseEntity<List<Sale>>(sales, HttpStatus.FOUND);
	}

	@PostMapping("/create")
	public ResponseEntity<HttpStatus> createProduct(@RequestBody Sale sale) {
		if (sale.getId() != null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);
		}

		Sale saleWithTotal = _calculateTotalValue(sale);

		saleRepository.save(saleWithTotal);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}

	public Sale _calculateTotalValue(Sale sale) {
		Double totalValue = 0.0;

		if (sale.getProducts() != null) {
			for (Product product : sale.getProducts()) {
				totalValue += product.getPrice();
			}
		}
		if (sale.getServices() != null) {
			for (Service service : sale.getServices()) {
				totalValue += service.getPrice();
			}
		}

		sale.setTotal(totalValue);

		if (sale.getDiscont() != null) {
			sale.setTotalWithDiscont(totalValue - sale.getDiscont());
		}

		return sale;
	}
}
