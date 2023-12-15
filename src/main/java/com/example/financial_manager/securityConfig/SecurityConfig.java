package com.example.financial_manager.securityConfig;

import com.example.financial_manager.dto.UserDto;
import com.example.financial_manager.entities.UserEntity;
import com.example.financial_manager.managers.UserManager;
import com.example.financial_manager.repositories.UserRepository;
import com.example.financial_manager.services.MyUserDetailsService;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationEntryPointFailureHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.context.WebApplicationContext;


import javax.naming.Context;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

//    @Autowired
//    private UserManager userManager;

    @Autowired
    private  WebApplicationContext applicationContext;
//    @Autowired
//    private UserRepository userRepository;


//    private MyUserDetailsService myUserDetailsService;
//
//    @PostConstruct
//    public void completeSetup() {
//        myUserDetailsService = applicationContext.getBean(MyUserDetailsService.class);
//    }


    @Bean
    public  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorize) -> authorize
                        //.requestMatchers("/*").permitAll()
//                        .requestMatchers(GET,"user/**/expenses/view").hasAnyRole("ADMIN","USER")
//                        .requestMatchers(GET,"/expenses/**").hasAnyRole("ADMIN","USER")
//                        .requestMatchers(PUT,"/expenses/**").hasRole("ADMIN")
//                        .requestMatchers(POST,"/expenses/createExpanse").hasRole("ADMIN")
//                        .requestMatchers(DELETE,"/expenses/**").hasRole("ADMIN")
//                        .requestMatchers(GET,"/incomes").hasAnyRole("ADMIN","USER")
//                        .requestMatchers(GET,"/incomes/**").hasAnyRole("ADMIN","USER")
//                        .requestMatchers(PUT,"/incomes/**").hasRole("ADMIN")
//                        .requestMatchers(POST,"/incomes/createIncome").hasRole("ADMIN")
//                        .requestMatchers(DELETE,"/incomes/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
//                .httpBasic(Customizer.withDefaults())
                .formLogin(formLogin -> formLogin
                        .successHandler(new AuthenticationSuccessHandlerImpl())
                        .defaultSuccessUrl("/user/1/view",true)
                );
        http.logout((out) -> out.invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll())
//                .formLogin()
//                .successHandler()
//        Long  id = userRepository.findByUsername(authentication.getName()).getId();
        ;
 //        http.formLogin((form) -> form.defaultSuccessUrl("user/1/expenses/view",true));

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());

        return new ProviderManager(authenticationProvider);
    }

    @Bean
    public UserDetailsService userDetailsService() {
          UserDetails userDetails2 = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("1111")
                .roles("ADMIN")
                .build();
        UserDetails userDetails1 = User.withDefaultPasswordEncoder()
                .username("user")
                .password("1111")
                .roles("USER")
                .build();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(userDetails2, userDetails1);
        return manager;
    }

   @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
