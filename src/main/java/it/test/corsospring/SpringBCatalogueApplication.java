package it.test.corsospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "it.test.corsospring.repository")
@SpringBootApplication
public class SpringBCatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBCatalogueApplication.class, args);
	}

}
