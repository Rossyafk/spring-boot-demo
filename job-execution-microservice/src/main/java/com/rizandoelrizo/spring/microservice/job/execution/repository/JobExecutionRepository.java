package com.rizandoelrizo.spring.microservice.job.execution.repository;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JobExecution Repository.
 */
public interface JobExecutionRepository extends JpaRepository<JobExecutionRecord, Long>{

}
