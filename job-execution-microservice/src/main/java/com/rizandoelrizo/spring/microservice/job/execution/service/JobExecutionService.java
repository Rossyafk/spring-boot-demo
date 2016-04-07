package com.rizandoelrizo.spring.microservice.job.execution.service;


import com.rizandoelrizo.spring.microservice.job.execution.repository.JobExecutionRecord;

import java.util.List;

public interface JobExecutionService {

    JobExecutionRecord save(JobExecutionRecord jobExecutionRecord);

    List<JobExecutionRecord> getAll();

    JobExecutionRecord getById(Long id);

    void deleteAll();

    boolean deleteById(Long id);

}

