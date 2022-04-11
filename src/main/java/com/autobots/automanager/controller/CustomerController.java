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

import com.autobots.automanager.entity.Customer;
import com.autobots.automanager.model.customer.CustomerAdderLink;
import com.autobots.automanager.model.customer.CustomerUpdater;
import com.autobots.automanager.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CustomerAdderLink customerAdderLink;
	@Autowired
	private CustomerUpdater customerUpdater;

	@GetMapping("/")
	public ResponseEntity<List<Customer>> getCustomers() {
		List<Customer> customers = customerRepository.findAll();
		if (customers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		customerAdderLink.addLink(customers);
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Customer> getCustomer(@PathVariable long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		if (customerOptional.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Customer customer = customerOptional.get();
		customerAdderLink.addLink(customer);
		return new ResponseEntity<Customer>(customer, HttpStatus.FOUND);
	}

	@PostMapping("/create")
	public ResponseEntity<HttpStatus> createCustomer(@RequestBody Customer customer) {
		if (customer.getId() != null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);
		}
		customerRepository.save(customer);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<HttpStatus> updateCustomer(@RequestBody Customer updatedCustomer) {
		Long id = updatedCustomer.getId();
		if (id == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Optional<Customer> customerOptional = customerRepository.findById(id);
		if (customerOptional.isEmpty()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Customer customer = customerOptional.get();
		customerUpdater.update(customer, updatedCustomer);
		customerRepository.save(customer);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		if (customerOptional.isEmpty()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Customer customer = customerOptional.get();
		customerRepository.delete(customer);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}