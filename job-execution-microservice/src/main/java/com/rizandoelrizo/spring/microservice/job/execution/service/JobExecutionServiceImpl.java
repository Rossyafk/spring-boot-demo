package com.rizandoelrizo.spring.microservice.job.execution.service;


import com.rizandoelrizo.spring.microservice.job.execution.repository.JobExecutionRecord;
import com.rizandoelrizo.spring.microservice.job.execution.repository.JobExecutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobExecutionServiceImpl implements JobExecutionService {

    private final JobExecutionRepository jobExecutionRepository;

    @Autowired
    public JobExecutionServiceImpl(final JobExecutionRepository jobExecutionRepository) {
        this.jobExecutionRepository = jobExecutionRepository;
    }

    @Transactional
    public JobExecutionRecord save(JobExecutionRecord tallySheet) {
        return jobExecutionRepository.save(tallySheet);
    }

    @Transactional
    public List<JobExecutionRecord> getAll() {
        return jobExecutionRepository.findAll();
    }

    @Transactional
    public JobExecutionRecord getById(Long id) {
        return jobExecutionRepository.findOne(id);
    }

    @Transactional
    public void deleteAll() {
        jobExecutionRepository.deleteAll();
    }

    @Transactional
    public boolean deleteById(Long id) {

        boolean deleted = false;

        if (jobExecutionRepository.exists(id)) {
            jobExecutionRepository.delete(id);
            deleted = true;
        }

        return deleted;
    }

}
