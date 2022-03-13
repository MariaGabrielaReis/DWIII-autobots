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
	public List<Customer> getCustomers() {
		List<Customer> customers = customerRepository.findAll();

		HttpStatus status = HttpStatus.NOT_FOUND;
		// PODE DAR ERRO, TIPO DE LISTA, MAS E SE NÃO TIVER LISTA???
		ResponseEntity<List<Customer>> response = new ResponseEntity<>(status);
		if (customers.isNotEmpty()) {
			status = HttpStatus.FOUND;
			customerAdderLink.addLink(customers);
			response = new ResponseEntity<List<Customer>>(customers, status);
		}	
		return response;
	}

	@GetMapping("/{id}")
	public Customer getCustomer(@PathVariable long id) {
		Customer customer = customerRepository.getById(id);

		HttpStatus status = HttpStatus.NOT_FOUND;
		// PODE DAR ERRO, TIPO "CLIENTE", MAS E SE NÃO TIVER CLIENTE???
		ResponseEntity<Customer> response = new ResponseEntity<>(status);
		if (customer != null) {
			status = HttpStatus.FOUND;
			customerAdderLink.addLink(customer);
			response = new ResponseEntity<Customer>(customer, status);
		}	
		return response;
	}

	@PostMapping("/create")
	public void createCustomer(@RequestBody Customer customer) {
		HttpStatus status = HttpStatus.CONFLICT;
		if(customer.getId() == null){
			customerRepository.save(customer);
			status = HttpStatus.CREATED;
		}
		return new ResponseEntity<>(status);
	}

	@PutMapping("/update")
	public void updateCustomer(@RequestBody Customer updatedCustomer) {
		Customer customer = customerRepository.getById(updatedCustomer.getId());

		HttpStatus status = HttpStatus.BAD_REQUEST;
		if(customer != null){
			status = HttpStatus.OK;
			customerUpdater.update(customer, updatedCustomer);
			customerRepository.save(customer);
		}
		return new ResponseEntity<>(status);
	}

	@DeleteMapping("/delete")
	public void deleteCustomer(@RequestBody Customer deletedCustomer) {
		Customer customer = customerRepository.getById(deletedCustomer.getId());

		HttpStatus status = HttpStatus.BAD_REQUEST;
		if(customer != null){
			status = HttpStatus.OK;
			customerRepository.delete(customer);
		}
		return new ResponseEntity<>(status);
	}
}
