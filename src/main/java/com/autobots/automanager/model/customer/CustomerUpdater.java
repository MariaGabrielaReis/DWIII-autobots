package com.autobots.automanager.model.customer;

import com.autobots.automanager.entity.Customer;

public class CustomerUpdater {
	private NullStringVerifier verifier = new NullStringVerifier();
	private AddressUpdater addressUpdater = new AddressUpdater();
	private PhoneUpdater phoneUpdater = new PhoneUpdater();

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
			address.setState(updatedCustomer.getState());
		}
		if (!verifier.verify(updatedCustomer.getCity())) {
			address.setCity(updatedCustomer.getCity());
		}
		if (!verifier.verify(updatedCustomer.getDistrict())) {
			address.setDistrict(updatedCustomer.getDistrict());
		}
		if (!verifier.verify(updatedCustomer.getStreet())) {
			address.setStreet(updatedCustomer.getStreet());
		}
		if (!verifier.verify(updatedCustomer.getNumber())) {
			address.setNumber(updatedCustomer.getNumber());
		}
		if (!verifier.verify(updatedCustomer.getComplement())) {
			address.setComplement(updatedCustomer.getComplement());
		}
	}
}
