package com.letschat.ecf;

import com.letschat.ecf.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class EcfApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcfApplication.class, args);
	}

}
