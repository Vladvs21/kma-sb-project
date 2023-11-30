package com.example.financial_manager.scheduledTasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import com.example.financial_manager.services.CurrencyApiService;
import org.springframework.stereotype.Component;

@Component
public class CurrencyAPIAvailabilityMonitoring {
    
    private static final Logger logger = LoggerFactory.getLogger(CurrencyAPIAvailabilityMonitoring.class);

    @Scheduled(fixedDelay = 60*1000) // minute after prev run finished
    public void run() {
        CurrencyApiService apiService = new CurrencyApiService();
        try {
            apiService.fetchCurrencyRates().getRates();
            logger.info("API service available");
        } catch (Exception e) {
            logger.error("API service unavailable");
        }
    }

    
}
