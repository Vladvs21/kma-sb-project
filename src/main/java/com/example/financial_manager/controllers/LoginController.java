package com.example.financial_manager.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final AuthenticationManager authenticationManager;

   @PostMapping("/login")
    public ModelAndView login(@RequestBody LoginRequest loginRequest) {
        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(loginRequest.username(), loginRequest.password());
        Authentication authenticationResponse =
                this.authenticationManager.authenticate(authenticationRequest);
        if(authenticationResponse.isAuthenticated()){
            return new ModelAndView("redirect:/user/{userId}/expenses/view");
        }else{
            return new ModelAndView("redirect:/login");
        }

    }

    public record LoginRequest(String username, String password) {
    }
}