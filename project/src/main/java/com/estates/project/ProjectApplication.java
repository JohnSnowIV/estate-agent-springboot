package com.estates.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ProjectApplication {

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {

			@Bean
			public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
				http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest()
								.permitAll());
				return http.build();
			}
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*")
						.allowedMethods("GET", "POST", "PATCH", "PUT", "DELETE")
						.allowedHeaders("Access-Control-Request-Headers", "Access-Control-Request-Method", "X-Requested-With", "Access-Control-Allow-Headers");
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

}
