package com.nordbank.dockerspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DockerspringbootApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DockerspringbootApplication.class);

	}

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(DockerspringbootApplication.class);
		springApplication.addListeners(new SpringBuiltInEventsListener());
		springApplication.run(args);
	}

}
