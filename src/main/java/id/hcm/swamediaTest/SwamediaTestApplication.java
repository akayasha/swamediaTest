package id.hcm.swamediaTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SwamediaTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwamediaTestApplication.class, args);
	}

}
