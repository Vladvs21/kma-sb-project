package com.example.financial_manager.scheduledTasks;

import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.financial_manager.FinanceManager;
import com.example.financial_manager.FinancialManagerApplication;

@Component
@AllArgsConstructor
public class DailyBudgetMonitoring {

    private final ApplicationContext applicationContext;
    @Scheduled(cron = "0 0 0 * * *") // every day at 00:00:00
    public void run() throws JobInstanceAlreadyCompleteException, JobExecutionAlreadyRunningException, JobParametersInvalidException, JobRestartException {
        JobLauncher jobLauncher = applicationContext.getBean(JobLauncher.class);
        Job job = applicationContext.getBean(Job.class);
        jobLauncher.run(job, new JobParameters());
    }

}
