package com.rizandoelrizo.spring.microservice.job.launcher.controller;

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
public class JobController {

    private final JobLauncher jobLauncher;

    private final Job sampleJob;

    private JobParameters jobParameters = new JobParametersBuilder()
            .addLong("run.id", 1L)
            .toJobParameters();

    @Autowired
    public JobController(JobLauncher jobLauncher, Job sampleJob) {
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
        jobLauncher.run(sampleJob, sampleJob.getJobParametersIncrementer().getNext(jobParameters));
        return "OK";
    }

//
//    @RequestMapping(value = "/tally-sheets/{tallySheetId}", method = RequestMethod.GET)
//    public TallySheet showTallySheet(@PathVariable String tallySheetId) {
//        return tallySheetService.getById(tallySheetId);
//    }
//
//    @RequestMapping(value = "/tally-sheets", method = RequestMethod.DELETE)
//    public void deleteAllTallySheets() {
//        tallySheetService.deleteAll();
//    }
//
//    @RequestMapping(value = "/tally-sheets/{tallySheetId}", method = RequestMethod.DELETE)
//    public boolean deleteTallySheet(@PathVariable String tallySheetId) {
//        return tallySheetService.deleteById(tallySheetId);
//    }

}
