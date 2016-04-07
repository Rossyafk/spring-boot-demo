package com.rizandoelrizo.spring.microservice.job.launcher.web;

import com.fasterxml.jackson.annotation.JsonRootName;
import org.springframework.batch.core.JobExecution;

import java.util.List;
import java.util.stream.Collectors;

@JsonRootName("JobScheduled")
public class JobScheduled {

    private Long jobInstanceId;

    private String jobName;

    private List<String> jobParameters;

    public Long getJobInstanceId() {
        return jobInstanceId;
    }

    public void setJobInstanceId(Long jobInstanceId) {
        this.jobInstanceId = jobInstanceId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public List<String> getJobParameters() {
        return jobParameters;
    }

    public void setJobParameters(List<String> jobParameters) {
        this.jobParameters = jobParameters;
    }

    public static JobScheduled of(JobExecution run) {
        JobScheduled jobScheduled = new JobScheduled();
        jobScheduled.setJobInstanceId(run.getJobId());
        jobScheduled.setJobName(run.getJobInstance().getJobName());

        List<String> parameters = run.getJobParameters().getParameters().entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue().toString())
                .collect(Collectors.toList());
        jobScheduled.setJobParameters(parameters);
        return jobScheduled;
    }
}
