package com.autobots.automanager.model.company;

import com.autobots.automanager.entity.Company;
import com.autobots.automanager.model.NullStringVerifier;
import org.springframework.stereotype.Component;

@Component
public class CompanyUpdater {
	private NullStringVerifier verifier = new NullStringVerifier();

	public void update(Company company, Company updatedCompany) {
		if (!verifier.verify(updatedCompany.getCorporateName())) {
			company.setCorporateName(updatedCompany.getCorporateName());
		}
		if (!verifier.verify(updatedCompany.getCommercialName())) {
			company.setCommercialName(updatedCompany.getCommercialName());
		}
		if (updatedCompany.getPhone() != null) {
			company.setPhone(updatedCompany.getPhone());
		}
		if (updatedCompany.getUsers() != null) {
			company.setUsers(updatedCompany.getUsers());
		}
		if (updatedCompany.getProducts() != null) {
			company.setProducts(updatedCompany.getProducts());
		}
		if (updatedCompany.getServices() != null) {
			company.setServices(updatedCompany.getServices());
		}
		if (updatedCompany.getSales() != null) {
			company.setSales(updatedCompany.getSales());
		}

		// Address
		if (!verifier.verify(updatedCompany.getState())) {
			company.setState(updatedCompany.getState());
		}
		if (!verifier.verify(updatedCompany.getCity())) {
			company.setCity(updatedCompany.getCity());
		}
		if (!verifier.verify(updatedCompany.getDistrict())) {
			company.setDistrict(updatedCompany.getDistrict());
		}
		if (!verifier.verify(updatedCompany.getStreet())) {
			company.setStreet(updatedCompany.getStreet());
		}
		if (updatedCompany.getNumber() != null) {
			company.setNumber(updatedCompany.getNumber());
		}
		if (!verifier.verify(updatedCompany.getComplement())) {
			company.setComplement(updatedCompany.getComplement());
		}
	}
}