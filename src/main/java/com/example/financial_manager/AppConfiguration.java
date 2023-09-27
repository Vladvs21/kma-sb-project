package com.example.financial_manager;

import com.example.financial_manager.components.ExpenseManagerImpl;
import com.example.financial_manager.components.IncomeManagerImpl;
import com.example.financial_manager.managers.ExpenseManager;
import com.example.financial_manager.managers.IncomeManager;
import com.example.financial_manager_starter.services.UserInfoService;
import com.example.financial_manager_starter.services.UserInfoServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfiguration {
    @Bean
    public ExpenseManager expenseManager(){
        return new ExpenseManagerImpl();
    }

    @Bean
    public IncomeManager incomeManager(){
        return new IncomeManagerImpl();
    }

    @Bean
    public FinanceManager financeManager() {
        return new FinanceManager(expenseManager(),incomeManager());
    }

    @Bean
    @ConditionalOnClass(UserInfoServiceImpl.class)
    @ConditionalOnMissingBean
    public UserInfoService userInfoService(){
        return new UserInfoServiceImpl("Bob","0664312456");
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
