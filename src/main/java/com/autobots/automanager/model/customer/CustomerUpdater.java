package com.autobots.automanager.model.customer;

import com.autobots.automanager.entity.Customer;
import com.autobots.automanager.model.NullStringVerifier;
import org.springframework.stereotype.Component;

@Component
public class CustomerUpdater {
	private NullStringVerifier verifier = new NullStringVerifier();

	public void update(Customer customer, Customer updatedCustomer) {
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
		if (!verifier.verify(updatedCustomer.getEmail())) {
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