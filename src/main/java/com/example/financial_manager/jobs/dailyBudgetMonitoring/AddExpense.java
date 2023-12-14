package com.example.financial_manager.jobs.dailyBudgetMonitoring;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddExpense implements Tasklet {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("MyTaskOne start..");

        System.out.println("MyTask:execute: executing tasklet - "+format.format(Calendar.getInstance().getTime()));

        System.out.println("MyTaskOne done..");
        return RepeatStatus.FINISHED;
    }

}
