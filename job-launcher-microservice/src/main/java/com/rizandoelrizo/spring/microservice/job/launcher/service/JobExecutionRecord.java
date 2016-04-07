package com.rizandoelrizo.spring.microservice.job.launcher.service;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("JobExecution")
public class JobExecutionRecord {

    private Long id;

    private Long jobId;

    private String jobName;

    private String jobStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public static JobExecutionRecord of(Long jobId, String jobName, String jobStatus) {
        JobExecutionRecord jobExecutionRecord = new JobExecutionRecord();
        jobExecutionRecord.setJobId(jobId);
        jobExecutionRecord.setJobName(jobName);
        jobExecutionRecord.setJobStatus(jobStatus);
        return jobExecutionRecord;
    }
}
