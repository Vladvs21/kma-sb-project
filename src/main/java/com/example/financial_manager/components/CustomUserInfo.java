package com.example.financial_manager.components;

import com.example.financial_manager_starter.services.UserInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
public class CustomUserInfo implements UserInfoService {

    @Value("${user.role}")
    private String userRole;
    @Override
    public void printUserInfo() {
        System.out.println("User Role: " + userRole);
        System.out.println("Custom Info:");
        System.out.println("Name: "+ "Robert");
        System.out.println("Phone: "+ "0973405789");
    }
}
