package com.digitallab.sigac;

import com.digitallab.sigac.models.Student;
import com.digitallab.sigac.repositories.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.RepositoryDefinition;

@EntityScan("com.digitallab.sigac.models")
@SpringBootApplication
public class SigacApplication {
	public static void main(String[] args) {

		SpringApplication.run(SigacApplication.class, args);

	}

	


}
