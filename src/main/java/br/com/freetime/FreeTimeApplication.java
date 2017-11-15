package br.com.freetime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableAutoConfiguration(exclude = { JacksonAutoConfiguration.class })
public class FreeTimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreeTimeApplication.class, args);
	}
	
	@GetMapping("/")
	public String x(){
		return "Hello Word!!!";
	}
}
