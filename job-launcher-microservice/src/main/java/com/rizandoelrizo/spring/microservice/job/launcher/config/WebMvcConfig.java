package com.rizandoelrizo.spring.microservice.job.launcher.config;

import com.rizandoelrizo.spring.microservice.job.launcher.web.JobLauncherController;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@Import(BatchConfig.class)
public class WebMvcConfig {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job sampleJob;

    @Bean
    public JobLauncherController jobController(){
        return new JobLauncherController(this.jobLauncher, this.sampleJob);
    }

}
