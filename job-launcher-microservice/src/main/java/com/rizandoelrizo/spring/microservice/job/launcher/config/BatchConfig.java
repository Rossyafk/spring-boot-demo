package com.rizandoelrizo.spring.microservice.job.launcher.config;

import com.rizandoelrizo.spring.microservice.job.launcher.service.JobExecutionWebService;
import com.rizandoelrizo.spring.microservice.job.launcher.service.JobExecutionWebServiceImpl;
import com.rizandoelrizo.spring.microservice.job.launcher.service.JobListener;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Value("${service.execution.url}")
    public String executionServiceUrl;

    @Bean
    @StepScope
    public ItemReader<String> sampleReader() {
        List<String> integers = IntStream.rangeClosed(1, 1000)
                .boxed()
                .map(String::valueOf)
                .collect(Collectors.toList());

        return new ListItemReader<>(integers);
    }

    @Bean
    public ItemWriter<String> sampleWriter() {
        return System.out::println;
    }

    @Bean
    public Step sampleStep() {
        return stepBuilderFactory.get("sampleStep")
                .<String, String> chunk(10)
                .reader(sampleReader())
                .writer(sampleWriter())
                .build();
    }

    @Bean
    public Job sampleJob() {
        return jobBuilderFactory.get("sampleJob")
                .incrementer(new RunIdIncrementer())
                .flow(sampleStep())
                .end()
                .listener(jobExecutionListener())
                .build();
    }

    @Bean
    public JobExecutionWebService jobExecutionWebService() {
        return new JobExecutionWebServiceImpl(new RestTemplate(), executionServiceUrl);
    }

    @Bean
    public JobExecutionListener jobExecutionListener() {
        return new JobListener(jobExecutionWebService());
    }

}
