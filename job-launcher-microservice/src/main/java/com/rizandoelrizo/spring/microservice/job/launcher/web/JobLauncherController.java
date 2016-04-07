package com.rizandoelrizo.spring.microservice.job.launcher.web;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class JobLauncherController {

    private final JobLauncher jobLauncher;

    private final Job sampleJob;

    private JobParameters jobParameters = new JobParametersBuilder()
            .addLong("run.id", 1L)
            .toJobParameters();

    @Autowired
    public JobLauncherController(JobLauncher jobLauncher, Job sampleJob) {
        this.jobLauncher = jobLauncher;
        this.sampleJob = sampleJob;
    }

    @RequestMapping(value = "/jobs", method = RequestMethod.GET)
    public List<String> listAllJobs() {
        return Arrays.asList(sampleJob.getName());
    }

    @RequestMapping(value = "/launch", method = RequestMethod.GET)
    public String launch() throws Exception {
        jobParameters = sampleJob.getJobParametersIncrementer().getNext(jobParameters);
        jobLauncher.run(sampleJob, jobParameters);
        return "OK";
    }

}
