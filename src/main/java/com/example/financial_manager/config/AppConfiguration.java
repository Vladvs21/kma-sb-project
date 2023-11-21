package com.example.financial_manager.config;

import com.example.financial_manager.components.IncomeManagerImpl;
import com.example.financial_manager.managers.IncomeManager;
import com.example.financial_manager.mappers.IncomeMapper;
import com.example.financial_manager.repositories.IncomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@PropertySource("classpath:application.properties")
@RequiredArgsConstructor
public class AppConfiguration{

    private final IncomeRepository incomeRepository;
    private final IncomeMapper incomeMapper;
    @Bean
    @ConditionalOnProperty(name = "currency.default", havingValue = "USD")
    public IncomeManager incomeManagerUSD(){
        return new IncomeManagerImpl(incomeMapper,incomeRepository,"USD");
    }

    @Bean
    @ConditionalOnProperty(name = "currency.default", havingValue = "EUR")
    public IncomeManager incomeManagerEUR(){
        return new IncomeManagerImpl(incomeMapper,incomeRepository,"EUR");
    }
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
