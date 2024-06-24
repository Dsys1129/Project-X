package io.biodome.lastspringwatt;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAdminServer
@SpringBootApplication
public class LastspringwattApplication {

	public static void main(String[] args) {
		SpringApplication.run(LastspringwattApplication.class, args);
	}

}
