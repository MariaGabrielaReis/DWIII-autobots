package com.autobots.automanager.model.customer;

import java.util.List;

import com.autobots.automanager.entity.Customer;

import org.springframework.stereotype.Component;

@Component
public class CustomerPicker {
	public Customer select(List<Customer> customers, long id) {
		Customer selected = null;
		for (Customer customer : customers) {
			if (customer.getId() == id) {
				selected = customer;
			}
		}
		return selected;
	}
}