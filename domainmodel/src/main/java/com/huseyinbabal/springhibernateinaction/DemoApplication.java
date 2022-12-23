package com.huseyinbabal.springhibernateinaction;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(final CustomerRepository customerRepository) {
		return args -> {
			Customer customer = new Customer();
			customer.setName("john");
			customerRepository.save(customer);

			System.out.println(customerRepository.findAll());
		};
	}

}

interface CustomerRepository extends CrudRepository<Customer, Integer>{}

@Entity
@Data
class Customer {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
}

