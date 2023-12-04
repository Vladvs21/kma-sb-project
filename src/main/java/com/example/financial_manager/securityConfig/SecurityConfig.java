package com.example.financial_manager.securityConfig;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{

    //private final JwtAuthFilter jwtAuthFilter;

    @Bean
    public static SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
                        //.requestMatchers("/*").permitAll()
                        .requestMatchers(GET,"/expenses").hasAnyRole("ADMIN","USER")
                        .requestMatchers(GET,"/expenses/**").hasAnyRole("ADMIN","USER")
                        .requestMatchers(PUT,"/expenses/**").hasRole("ADMIN")
                        .requestMatchers(POST,"/expenses/createExpanse").hasRole("ADMIN")
                        .requestMatchers(DELETE,"/expenses/**").hasRole("ADMIN")
                        .requestMatchers(GET,"/incomes").hasAnyRole("ADMIN","USER")
                        .requestMatchers(GET,"/incomes/**").hasAnyRole("ADMIN","USER")
                        .requestMatchers(PUT,"/incomes/**").hasRole("ADMIN")
                        .requestMatchers(POST,"/incomes/createIncome").hasRole("ADMIN")
                        .requestMatchers(DELETE,"/incomes/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
        ;

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            UserDetailsService userDetailsService,
            PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder);

        return new ProviderManager(authenticationProvider);
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        UserDetails userDetails2 = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("1111")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(userDetails2,userDetails);
    }

   @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
