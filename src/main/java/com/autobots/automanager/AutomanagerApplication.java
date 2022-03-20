package com.autobots.automanager;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.autobots.automanager.entity.Customer;
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
			newCustomer.setPhone(21981234576L);
			newCustomer.setState("Rio de Janeiro");
			newCustomer.setCity("Rio de Janeiro");
			newCustomer.setDistrict("Botafogo");
			newCustomer.setStreet("Av. Pasteur");
			newCustomer.setNumber(154);
			newCustomer.setZipCode(22290240);
			newCustomer.setComplement("Centro Corporativo SOMA, só passa com crachá");
			customerRepository.save(newCustomer);

			// Customer 2
			calendar.set(2002, 05, 21);
			newCustomer.setName("Wallace SoUzA");
			newCustomer.setRegistrationDate(Calendar.getInstance().getTime());
			newCustomer.setBirthDate(calendar.getTime());
			newCustomer.setNickname("Gol do Flamengo");
			newCustomer.setState("São Paulo");
			newCustomer.setCity("Monteiro Lobato");
			newCustomer.setDistrict("Pamonha");
			newCustomer.setStreet("Rua do Milho");
			newCustomer.setNumber(1111);
			newCustomer.setZipCode(11111111);
			newCustomer.setComplement("Não tem campainha, pode gritar");
	
			customerRepository.save(newCustomer);
		}
	}
}