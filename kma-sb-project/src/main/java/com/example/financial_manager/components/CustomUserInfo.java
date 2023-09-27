package com.example.financial_manager.components;

import com.example.financial_manager_starter.services.UserInfoService;
import org.springframework.stereotype.Component;

@Component
public class CustomUserInfo implements UserInfoService {
    @Override
    public void printUserInfo() {
        System.out.println("Custom Info:");
        System.out.println("Name: "+ "Robert");
        System.out.println("Phone: "+ "0973405789");
    }
}
