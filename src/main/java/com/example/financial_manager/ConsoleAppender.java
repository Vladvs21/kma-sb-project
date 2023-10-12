package com.example.financial_manager;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

public class ConsoleAppender extends AppenderBase<ILoggingEvent>{

    @Override
    protected void append(ILoggingEvent event) {

        System.out.println(LocalDate.now() + " : " + LocalTime.now() + " -- " + event.toString());

    }

}