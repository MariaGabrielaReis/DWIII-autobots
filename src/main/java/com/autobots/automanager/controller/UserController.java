package com.autobots.automanager.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autobots.automanager.entity.Credential;
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

	@GetMapping("/role/{roleName}")
	public ResponseEntity<List<User>> getUserByRole(@PathVariable String roleName) {
		List<User> customers;

		switch (roleName) {
			case "customer":
				customers = userRepository.findByRole(UserRole.customer);
				break;
			case "employee":
				customers = userRepository.findByRole(UserRole.employee);
				break;
			case "supplier":
				customers = userRepository.findByRole(UserRole.supplier);
				break;
			default:
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		if (customers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		userAdderLink.addLink(customers);
		return new ResponseEntity<List<User>>(customers, HttpStatus.FOUND);
	}

	@PostMapping("/create")
	public ResponseEntity<HttpStatus> createUser(@RequestBody User user) {
		if (user.getId() != null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);
		}

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		try {
			Credential credential = new Credential();
			credential.setLogin(user.getCredential().getLogin());
			String password = encoder.encode(user.getCredential().getPassword());
			credential.setPassword(password);
			user.setCredential(credential);
			userRepository.save(user);
			return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
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