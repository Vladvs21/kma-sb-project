package com.example.financial_manager.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .addFilter(new CustomFilter())
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers(HttpMethod.GET, "/**").hasRole(RolesConstants.ADMIN);
                    auth.requestMatchers(HttpMethod.POST, "/**").hasAuthority(AuthoritiesConstants.WRITE_PRIVILEGE);
                    auth.requestMatchers(HttpMethod.PUT, "/**").hasAuthority(AuthoritiesConstants.UPDATE_PRIVILEGE);
                    auth.requestMatchers(HttpMethod.DELETE, "/").hasAuthority(AuthoritiesConstants.DELETE_PRIVILEGE);
                    auth.anyRequest().authenticated();
                })
                .formLogin(withDefaults())
                .build();
    }

}