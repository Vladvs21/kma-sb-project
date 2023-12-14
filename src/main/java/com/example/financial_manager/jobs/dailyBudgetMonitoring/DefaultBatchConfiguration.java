package com.example.financial_manager.jobs.dailyBudgetMonitoring;

import com.example.financial_manager.dto.ExpenseDto;
import com.example.financial_manager.entities.ExpenseEntity;
import com.example.financial_manager.repositories.ExpenseRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Collections;
import java.util.HashMap;

//@Configuration
//@EnableBatchProcessing
//@EnableScheduling
//@AllArgsConstructor
public class DefaultBatchConfiguration {

//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private ExpenseRepository repository;
//
//    @Autowired
//    private JobLauncher jobLauncher;
//
//
//    @Bean
//    public ItemReader<ExpenseEntity> reader() {
//        int maxId = 45;
//
//        RepositoryItemReader<ExpenseEntity> reader = new RepositoryItemReader<>();
//        reader.setRepository(repository);
//        reader.setMethodName("findByIdLessThan");
//        reader.setArguments(Collections.singletonList(maxId));
//        reader.setPageSize(20);
//
//        HashMap<String, Sort.Direction> sorts = new HashMap<>();
//        sorts.put("expense_id", Sort.Direction.ASC);
//        reader.setSort(sorts);
//
//        return reader;
//    }
//
//    @Bean
//    public ItemProcessor<ExpenseEntity, ExpenseEntity> processor() {
//        return item -> item;
//    }
//
//    @Bean
//    public ItemWriter<ExpenseDto> writer() {
//        return items -> {
//            //items.forEach(System.out::println);
//            System.out.println("Done for " + items.size() + " elements");
//        };
//    }
//
//    @Bean
//    public Step step1(){
//        return stepBuilderFactory.get("step1")
//                .tasklet(dataPrepareTasklet())
//                .build();
//    }
//
//    @Bean
//    public Tasklet dataPrepareTasklet(){
//        return (contribution, chunkContext) -> {
//            for(int i = 0; i<100; i++){
//                ExpenseEntity expense = repository.save(new ExpenseEntity(null,100.0,"Spotify"));
//                System.out.println(expense);
//            }
//            return RepeatStatus.FINISHED;
//        };
//    }
//        @Bean
//        public Job job () {
//            return jobBuilderFactory.get("job")
//                    .incrementer(new RunIdIncrementer())
//                    .start(step1())
//                    .build();
//        }
//    @Scheduled(fixedDelay = 5000)
//    public void runJobOnSchedule() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
//        JobParameters jobParameters = new JobParametersBuilder()
//                .addLong("time", System.currentTimeMillis())
//                .toJobParameters();
//
//        JobExecution jobExecution = jobLauncher.run(job(), jobParameters);
//
//        System.out.println("Scheduled Batch Job Launched: " + jobExecution.getStatus());
//    }
    }




