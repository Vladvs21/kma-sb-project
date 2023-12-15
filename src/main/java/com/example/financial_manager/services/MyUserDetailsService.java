package com.example.financial_manager.services;

import com.example.financial_manager.entities.UserEntity;
import com.example.financial_manager.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private WebApplicationContext applicationContext;

    private UserRepository userRepository;

    @PostConstruct
    public void completeSetup() {
        userRepository = applicationContext.getBean(UserRepository.class);
    }

    @Override
    public UserDetails loadUserByUsername(final String username) {
        final UserEntity appUser = userRepository.findByUsername(username);
        if (appUser == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(appUser);
    }
}
