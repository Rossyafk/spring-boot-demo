package com.rizandoelrizo.spring.microservice.job.execution.web;

import com.rizandoelrizo.spring.microservice.job.execution.repository.JobExecution;
import com.rizandoelrizo.spring.microservice.job.execution.service.JobExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class JobExecutionController {

    private final JobExecutionService jobExecutionService;

    @Autowired
    public JobExecutionController(final JobExecutionService jobExecutionService) {
        this.jobExecutionService = jobExecutionService;
    }

    @RequestMapping(value = "/job-executions", method = RequestMethod.POST)
    public JobExecution createJobExecution(@RequestBody @Valid JobExecution jobExecution) {
        return jobExecutionService.save(jobExecution);
    }

    @RequestMapping(value = "/job-executions", method = RequestMethod.GET)
    public List<JobExecution> showJobExecutions() {
        return jobExecutionService.getAll();
    }

    @RequestMapping(value = "/job-executions/{jobExecutionId}", method = RequestMethod.GET)
    public JobExecution showJobExecution(@PathVariable Long jobExecutionId) {
        return jobExecutionService.getById(jobExecutionId);
    }

    @RequestMapping(value = "/job-executions", method = RequestMethod.DELETE)
    public void deleteJobExecutions() {
        jobExecutionService.deleteAll();
    }

    @RequestMapping(value = "/job-executions/{jobExecutionId}", method = RequestMethod.DELETE)
    public boolean deleteJobExecution(@PathVariable Long jobExecutionId) {
        return jobExecutionService.deleteById(jobExecutionId);
    }

}
