package com.example.financial_manager.securityConfig;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//@Repository
public class UserDao {
    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User(
                    "user1",
                    "1111",
                    Collections.singleton(new SimpleGrantedAuthority("USER"))
            ),
            new User(
                    "user2",
                    "1234",
                    Collections.singleton(new SimpleGrantedAuthority("USER"))
            ),
            new User(
                    "admin",
                    "1111",
                    Collections.singleton(new SimpleGrantedAuthority("ADMIN"))
            )
    );

    public List<UserDetails> getUsers(){
        return APPLICATION_USERS;
    }
    public UserDetails findUserByUsername(String username){
        return APPLICATION_USERS
                .stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No such user"));
    }
}
