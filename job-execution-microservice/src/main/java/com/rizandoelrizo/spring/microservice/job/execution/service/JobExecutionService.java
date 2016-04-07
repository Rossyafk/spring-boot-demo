package com.rizandoelrizo.spring.microservice.job.execution.service;


import com.rizandoelrizo.spring.microservice.job.execution.repository.JobExecution;

import java.util.List;

public interface JobExecutionService {

    JobExecution save(JobExecution jobExecution);

    List<JobExecution> getAll();

    JobExecution getById(Long id);

    void deleteAll();

    boolean deleteById(Long id);

}

