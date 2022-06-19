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

import com.autobots.automanager.entity.User;
import com.autobots.automanager.model.enums.UserRole;
import com.autobots.automanager.model.user.UserAdderLink;
import com.autobots.automanager.model.user.UserUpdater;
import com.autobots.automanager.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserAdderLink userAdderLink;
	@Autowired
	private UserUpdater userUpdater;

	@GetMapping("/")
	public ResponseEntity<List<User>> getUsers() {
		List<User> users = userRepository.findAll();
		if (users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userAdderLink.addLink(users);
		return new ResponseEntity<List<User>>(users, HttpStatus.FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable long id) {
		Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		User user = userOptional.get();
		userAdderLink.addLink(user);
		return new ResponseEntity<User>(user, HttpStatus.FOUND);
	}

	@GetMapping("/customers")
	public ResponseEntity<List<User>> getCustomers() {
		List<User> customers = userRepository.findByRole(UserRole.customer);
		if (customers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userAdderLink.addLink(customers);
		return new ResponseEntity<List<User>>(customers, HttpStatus.FOUND);
	}

	@GetMapping("/employees")
	public ResponseEntity<List<User>> getEmployees() {
		List<User> employees = userRepository.findByRole(UserRole.employee);
		if (employees.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userAdderLink.addLink(employees);
		return new ResponseEntity<List<User>>(employees, HttpStatus.FOUND);
	}

	@GetMapping("/suppliers")
	public ResponseEntity<List<User>> getSuppliers() {
		List<User> suppliers = userRepository.findByRole(UserRole.supplier);
		if (suppliers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userAdderLink.addLink(suppliers);
		return new ResponseEntity<List<User>>(suppliers, HttpStatus.FOUND);
	}

	@PostMapping("/create")
	public ResponseEntity<HttpStatus> createUser(@RequestBody User user) {
		if (user.getId() != null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);
		}
		userRepository.save(user);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<HttpStatus> updateUser(@RequestBody User updatedUser) {
		Long id = updatedUser.getId();
		if (id == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isEmpty()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		User user = userOptional.get();
		userUpdater.update(user, updatedUser);
		userRepository.save(user);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long id) {
		Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isEmpty()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		User user = userOptional.get();
		userRepository.delete(user);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}