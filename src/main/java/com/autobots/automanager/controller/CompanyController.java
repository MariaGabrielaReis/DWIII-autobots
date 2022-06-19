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

import com.autobots.automanager.entity.Company;
import com.autobots.automanager.entity.Product;
import com.autobots.automanager.entity.Sale;
import com.autobots.automanager.entity.Service;
import com.autobots.automanager.entity.User;
import com.autobots.automanager.model.company.CompanyAdderLink;
import com.autobots.automanager.model.company.CompanyUpdater;
import com.autobots.automanager.repository.CompanyRepository;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private CompanyAdderLink companyAdderLink;
	@Autowired
	private CompanyUpdater companyUpdater;

	@GetMapping("/")
	public ResponseEntity<List<Company>> getCompanies() {
		List<Company> companies = companyRepository.findAll();
		if (companies.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		companyAdderLink.addLink(companies);
		return new ResponseEntity<List<Company>>(companies, HttpStatus.FOUND);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompany(@PathVariable long id) {
		Optional<Company> companyOptional = companyRepository.findById(id);
		if (companyOptional.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Company company = companyOptional.get();
		companyAdderLink.addLink(company);
		return new ResponseEntity<Company>(company, HttpStatus.FOUND);
	}

	@PostMapping("/create")
	public ResponseEntity<HttpStatus> createCompany(@RequestBody Company company) {
		if (company.getId() != null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.CONFLICT);
		}
		companyRepository.save(company);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<HttpStatus> updateCompany(@RequestBody Company updatedCompany) {
		Long id = updatedCompany.getId();
		if (id == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Optional<Company> companyOptional = companyRepository.findById(id);
		if (companyOptional.isEmpty()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Company company = companyOptional.get();
		companyUpdater.update(company, updatedCompany);
		companyRepository.save(company);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@PutMapping("/addUserToCompany/{companyId}")
	public ResponseEntity<HttpStatus> addUserToCompany(@PathVariable long companyId, @RequestBody User user) {
		Optional<Company> companyOptional = companyRepository.findById(companyId);
		if (companyOptional.isEmpty()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Company company = companyOptional.get();
		List<User> companyUsers = company.getUsers();
		companyUsers.add(user);
		company.setUsers(companyUsers);
		companyRepository.save(company);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@PutMapping("/addProductToCompany/{companyId}")
	public ResponseEntity<HttpStatus> addProductToCompany(@PathVariable long companyId, @RequestBody Product product) {
		Optional<Company> companyOptional = companyRepository.findById(companyId);
		if (companyOptional.isEmpty()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Company company = companyOptional.get();
		List<Product> companyServices = company.getProducts();
		companyServices.add(product);
		company.setProducts(companyServices);
		companyRepository.save(company);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@PutMapping("/addServiceToCompany/{companyId}")
	public ResponseEntity<HttpStatus> addServiceToCompany(@PathVariable long companyId, @RequestBody Service service) {
		Optional<Company> companyOptional = companyRepository.findById(companyId);
		if (companyOptional.isEmpty()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Company company = companyOptional.get();
		List<Service> companyServices = company.getServices();
		companyServices.add(service);
		company.setServices(companyServices);
		companyRepository.save(company);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@PutMapping("/addSaleToCompany/{companyId}")
	public ResponseEntity<HttpStatus> addSaleToCompany(@PathVariable long companyId, @RequestBody Sale sale) {
		Optional<Company> companyOptional = companyRepository.findById(companyId);
		if (companyOptional.isEmpty()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Company company = companyOptional.get();
		List<Sale> companySales = company.getSales();
		companySales.add(sale);
		company.setSales(companySales);
		companyRepository.save(company);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<HttpStatus> deleteCompany(@PathVariable Long id) {
		Optional<Company> companyOptional = companyRepository.findById(id);
		if (companyOptional.isEmpty()) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		Company company = companyOptional.get();
		companyRepository.delete(company);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
