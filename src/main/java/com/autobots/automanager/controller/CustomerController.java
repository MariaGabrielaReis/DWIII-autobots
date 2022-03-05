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

import com.autobots.automanager.entity.Customer;
import com.autobots.automanager.model.CustomerUpdater;
import com.autobots.automanager.model.CustomerPicker;
import com.autobots.automanager.repository.CustomerRepository;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CustomerPicker customerPicker;

	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable long id) {
		List<Customer> customers = customerRepository.findAll();
		return customerPicker.select(customers, id);
	}

	@GetMapping("/")
	public List<Customer> getCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers;
	}

	@PostMapping("/create")
	public void createCustomer(@RequestBody Customer customer) {
		customerRepository.save(customer);
	}

	@PutMapping("/update")
	public void updateCustomer(@RequestBody Customer updatedCustomer) {
		Customer customer = customerRepository.getById(updatedCustomer.getId());
		CustomerUpdater customerUpdater = new CustomerUpdater();
		customerUpdater.update(customer, updatedCustomer);
		customerRepository.save(customer);
	}

	@DeleteMapping("/delete")
	public void deleteCustomer(@RequestBody Customer deletedCustomer) {
		Customer customer = customerRepository.getById(deletedCustomer.getId());
		customerRepository.delete(customer);
	}
}
