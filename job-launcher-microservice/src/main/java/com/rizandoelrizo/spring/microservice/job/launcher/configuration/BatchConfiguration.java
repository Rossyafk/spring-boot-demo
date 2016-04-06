package com.rizandoelrizo.spring.microservice.job.launcher.configuration;

import org.springframework.batch.core.Job;
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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

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
                .build();
    }

}
