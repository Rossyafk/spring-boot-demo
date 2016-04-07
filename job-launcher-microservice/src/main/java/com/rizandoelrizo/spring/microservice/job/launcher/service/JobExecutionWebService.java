package com.rizandoelrizo.spring.microservice.job.launcher.service;

import org.springframework.batch.core.JobExecution;

public interface JobExecutionWebService {

    void storeJobExecution(JobExecution jobExecution);

}
