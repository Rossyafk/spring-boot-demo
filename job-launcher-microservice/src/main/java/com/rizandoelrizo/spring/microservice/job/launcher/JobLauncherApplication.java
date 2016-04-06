package com.rizandoelrizo.spring.microservice.job.launcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses =
		com.rizandoelrizo.spring.microservice.job.launcher.configuration.PackageMarker.class)
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class JobLauncherApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobLauncherApplication.class, args);
	}

}
