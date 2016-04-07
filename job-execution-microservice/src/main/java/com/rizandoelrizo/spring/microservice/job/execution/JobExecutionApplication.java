package com.rizandoelrizo.spring.microservice.job.execution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Entry point class.
 */
@SpringBootApplication
public class JobExecutionApplication extends SpringBootServletInitializer {

	/**
	 * Embedded execution.
	 */
	public static void main(String[] args) {
		SpringApplication.run(JobExecutionApplication.class, args);
	}

	/**
	 * External deploy execution.
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JobExecutionApplication.class);
	}

}
