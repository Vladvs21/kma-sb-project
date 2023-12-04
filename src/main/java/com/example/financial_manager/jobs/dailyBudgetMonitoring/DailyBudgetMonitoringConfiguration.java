package com.example.financial_manager.jobs.dailyBudgetMonitoring;

import com.example.financial_manager.FinanceManager;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.support.JdbcTransactionManager;

@AllArgsConstructor
@Configuration
@EnableBatchProcessing
public class DailyBudgetMonitoringConfiguration {

    private final ApplicationContext applicationContext;

    @Bean
    public Step getBudgetStep(JobRepository jobRepository, JdbcTransactionManager transactionManager) {
        return new StepBuilder("getBudgetStep", jobRepository)
                .tasklet((contribution, chunkContext) ->
                    {
                        FinanceManager financeManager = applicationContext.getBean(FinanceManager.class);
                        double budget = financeManager.calculateBudget();

                        ExecutionContext jobExecutionContext = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext();
                        jobExecutionContext.put("budget", budget);

                        return RepeatStatus.FINISHED;
                    },
                    transactionManager
                )
                .build();
    }

    @Bean
    public Step sendMailStep(JobRepository jobRepository, JdbcTransactionManager transactionManager) {
        return new StepBuilder("sendMailStep", jobRepository)
                .tasklet((contribution, chunkContext) ->
                    {
                        ExecutionContext jobExecutionContext = chunkContext.getStepContext().getStepExecution().getJobExecution().getExecutionContext();
                        double budget = jobExecutionContext.getDouble("budget");

                        System.out.println("Budget: " + budget); // send info notification to client

                        return RepeatStatus.FINISHED;
                    },
                    transactionManager
                )
                .build();
    }

    @Bean
    public Job dailyBudgetMonitoringJob(JobRepository jobRepository, Step getBudgetStep, Step sendMailStep) {
        return new JobBuilder("dailyBudgetMonitoringJob", jobRepository)
                .start(getBudgetStep)
                .next(sendMailStep)
                .build();
    }

}
