package com.example.financial_manager_starter.services;

public class UserInfoServiceImpl implements UserInfoService{
    private String name;
    private String phoneNumber;
    @Override
    public void printUserInfo() {
        System.out.println("Name: "+ name);
        System.out.println("Phone: "+ phoneNumber);
    }
    public UserInfoServiceImpl(String name, String phoneNumber){
        this.phoneNumber = phoneNumber;
        this.name = name;
    }
}
