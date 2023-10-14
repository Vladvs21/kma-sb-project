package com.example.financial_manager;

import com.example.financial_manager.components.IncomeManagerImpl;
import com.example.financial_manager.managers.IncomeManager;
import com.example.financial_manager.repositories.IncomeRepository;
import com.example.financial_manager_starter.services.UserInfoService;
import com.example.financial_manager_starter.services.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
//@EnableJpaRepositories
@PropertySource("classpath:application.properties")
public class AppConfiguration {

    @Autowired
    private IncomeRepository incomeRepository;
    @Bean
    @ConditionalOnProperty(name = "currency.default", havingValue = "USD")
    public IncomeManager incomeManagerUSD(){
        return new IncomeManagerImpl(incomeRepository,"USD");
    }

    @Bean
    @ConditionalOnProperty(name = "currency.default", havingValue = "EUR")
    public IncomeManager incomeManagerEUR(){
        return new IncomeManagerImpl(incomeRepository,"EUR");
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
