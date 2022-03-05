package com.autobots.automanager;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.autobots.automanager.entity.Customer;
import com.autobots.automanager.entity.Address;
import com.autobots.automanager.entity.Phone;
import com.autobots.automanager.repository.CustomerRepository;

@SpringBootApplication
public class AutomanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutomanagerApplication.class, args);
	}

	@Component
	public static class Runner implements ApplicationRunner {
		@Autowired
		public CustomerRepository customerRepository;

		@Override
		public void run(ApplicationArguments args) throws Exception {
			Calendar calendar = Calendar.getInstance();
			calendar.set(2000, 07, 21);

			// Customer 1
			Customer newCustomer = new Customer();
			newCustomer.setName("Maria Gabriela Reis");
			newCustomer.setRegistrationDate(Calendar.getInstance().getTime());
			newCustomer.setBirthDate(calendar.getTime());
			newCustomer.setNickname("Maby");

			Phone phone = new Phone();
			phone.setDdd("21");
			phone.setNumber("981234576");
			newCustomer.getPhones().add(phone);

			Address address = new Address();
			address.setState("Rio de Janeiro");
			address.setCity("Rio de Janeiro");
			address.setDistrict("Botafogo");
			address.setStreet("Av. Pasteur");
			address.setNumber("154");
			address.setZipCode("22290-240");
			address.setComplement("Centro Corporativo SOMA, só passa com crachá");
			newCustomer.setAddress(address);

			customerRepository.save(newCustomer);

			// Customer 2
			calendar.set(2002, 05, 21);
			newCustomer.setName("Wallace SoUzA");
			newCustomer.setRegistrationDate(Calendar.getInstance().getTime());
			newCustomer.setBirthDate(calendar.getTime());
			newCustomer.setNickname("Gol do Flamengo");

			Address address = new Address();
			address.setState("São Paulo");
			address.setCity("Monteiro Lobato");
			address.setDistrict("Pamonha");
			address.setStreet("Rua do Milho");
			address.setNumber("1111");
			address.setZipCode("11111-111");
			address.setComplement("Não tem campainha, pode gritar");
			newCustomer.setAddress(address);
	
			customerRepository.save(newCustomer);
		}
	}
}
