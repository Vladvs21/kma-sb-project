package com.example.financial_manager.config;

import com.example.financial_manager.components.IncomeManagerImpl;
import com.example.financial_manager.managers.IncomeManager;
import com.example.financial_manager.mappers.IncomeMapper;
import com.example.financial_manager.repositories.IncomeRepository;
import com.example.financial_manager.securityConfig.AuthoritiesConstants;
import com.example.financial_manager.securityConfig.CustomFilter;
import com.example.financial_manager.securityConfig.RolesConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
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
