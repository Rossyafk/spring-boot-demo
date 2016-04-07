package com.rizandoelrizo.spring.microservice.job.execution.web;

import com.rizandoelrizo.spring.microservice.job.execution.repository.JobExecutionRecord;
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
    public JobExecutionRecord createJobExecution(@RequestBody @Valid JobExecutionRecord jobExecutionRecord) {
        return jobExecutionService.save(jobExecutionRecord);
    }

    @RequestMapping(value = "/job-executions", method = RequestMethod.GET)
    public List<JobExecutionRecord> showJobExecutions() {
        return jobExecutionService.getAll();
    }

    @RequestMapping(value = "/job-executions/{jobExecutionId}", method = RequestMethod.GET)
    public JobExecutionRecord showJobExecution(@PathVariable Long jobExecutionId) {
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
