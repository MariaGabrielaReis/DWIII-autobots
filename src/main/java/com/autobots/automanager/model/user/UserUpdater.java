package com.autobots.automanager.model.user;

import com.autobots.automanager.entity.User;
import com.autobots.automanager.model.NullStringVerifier;
import org.springframework.stereotype.Component;

@Component
public class UserUpdater {
	private NullStringVerifier verifier = new NullStringVerifier();

	public void update(User customer, User updatedCustomer) {
		if (updatedCustomer.getRole() != null) {
			customer.setRole(updatedCustomer.getRole());
		}
		if (!verifier.verify(updatedCustomer.getName())) {
			customer.setName(updatedCustomer.getName());
		}
		if (!verifier.verify(updatedCustomer.getNickname())) {
			customer.setNickname(updatedCustomer.getNickname());
		}
		if (updatedCustomer.getCpf() != null) {
			customer.setCpf(updatedCustomer.getCpf());
		}
		if (updatedCustomer.getRg() != null) {
			customer.setRg(updatedCustomer.getRg());
		}
		if (updatedCustomer.getPhone() != null) {
			customer.setPhone(updatedCustomer.getPhone());
		}
		if (updatedCustomer.getEmail() != null) {
			customer.setEmail(updatedCustomer.getEmail());
		}
		if (updatedCustomer.getBirthDate() != null) {
			customer.setBirthDate(updatedCustomer.getBirthDate());
		}

		// Address
		if (!verifier.verify(updatedCustomer.getState())) {
			customer.setState(updatedCustomer.getState());
		}
		if (!verifier.verify(updatedCustomer.getCity())) {
			customer.setCity(updatedCustomer.getCity());
		}
		if (!verifier.verify(updatedCustomer.getDistrict())) {
			customer.setDistrict(updatedCustomer.getDistrict());
		}
		if (!verifier.verify(updatedCustomer.getStreet())) {
			customer.setStreet(updatedCustomer.getStreet());
		}
		if (updatedCustomer.getNumber() != null) {
			customer.setNumber(updatedCustomer.getNumber());
		}
		if (!verifier.verify(updatedCustomer.getComplement())) {
			customer.setComplement(updatedCustomer.getComplement());
		}
	}
}