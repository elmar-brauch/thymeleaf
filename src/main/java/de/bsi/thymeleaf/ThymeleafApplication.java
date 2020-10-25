package de.bsi.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ThymeleafApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafApplication.class, args);
	}
}
