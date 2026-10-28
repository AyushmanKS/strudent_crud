package in.strikes.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		System.out.println("CrudApplication.main() -> starting app");
		SpringApplication.run(CrudApplication.class, args);

		System.out.println("Hello world");
	}

}
