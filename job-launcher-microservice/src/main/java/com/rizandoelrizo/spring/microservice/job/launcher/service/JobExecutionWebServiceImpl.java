package com.rizandoelrizo.spring.microservice.job.launcher.service;


import org.springframework.batch.core.JobExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class JobExecutionWebServiceImpl implements JobExecutionWebService {

    private RestTemplate restTemplate;

    private String serviceUrl;

    @Autowired
    public JobExecutionWebServiceImpl(RestTemplate restTemplate, String serviceUrl) {
        this.restTemplate = restTemplate;
        this.serviceUrl = serviceUrl;
    }

    @Override
    public void storeJobExecution(JobExecution jobExecution) {
        JobExecutionRecord jobExecutionRecord = JobExecutionRecord
                .of(jobExecution.getJobParameters().getLong("run.id"),
                        jobExecution.getJobInstance().getJobName(),
                        jobExecution.getStatus().toString());
        jobExecutionRecord = restTemplate.postForObject(serviceUrl, jobExecutionRecord, JobExecutionRecord.class);
    }

}
