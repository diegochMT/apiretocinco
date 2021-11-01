package co.usa.retotres.retotres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EntityScan(basePackages = {"co.usa.retotres.retotres.model"})
@SpringBootApplication
@EnableConfigurationProperties
public class RetotresApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetotresApplication.class, args);
	}

}
