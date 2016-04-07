package com.rizandoelrizo.spring.microservice.job.launcher.service;

import org.springframework.batch.core.*;
import org.springframework.batch.core.JobExecution;

public class JobListener implements JobExecutionListener {

    private final JobExecutionWebService jobExecutionWebService;

    public JobListener(JobExecutionWebService jobExecutionWebService) {
        this.jobExecutionWebService = jobExecutionWebService;
    }

    @Override
    public void beforeJob(JobExecution jobExecution) {
        jobExecutionWebService.storeJobExecution(jobExecution);
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        jobExecutionWebService.storeJobExecution(jobExecution);
    }

}
