package com.rizandoelrizo.spring.microservice.job.launcher.configuration;

import com.rizandoelrizo.spring.microservice.job.launcher.controller.JobController;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@Import(BatchConfiguration.class)
public class WebMvcConfiguration {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job sampleJob;

    @Bean
    public JobController jobController(){
        return new JobController(this.jobLauncher, this.sampleJob);
    }

}
