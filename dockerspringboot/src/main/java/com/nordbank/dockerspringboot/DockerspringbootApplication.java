package com.nordbank.dockerspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DockerspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerspringbootApplication.class, args);
	}

}
// @SpringBootApplication
// public class DockerspringbootApplication extends SpringBootServletInitializer {

// 	@Override
// 	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
// 		return application.sources(DockerspringbootApplication.class);

// 	}

// 	public static void main(String[] args) {
// 		SpringApplication springApplication = new SpringApplication(DockerspringbootApplication.class);
// 		springApplication.addListeners(new SpringBuiltInEventsListener());
// 		springApplication.run(args);
// 	}

// }
