package com.example.financial_manager.securityConfig.jwt;

import com.example.financial_manager.securityConfig.UserDao;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

//@Component
//@RequiredArgsConstructor
public class JwtAuthFilter {//extends OncePerRequestFilter {


//    private final UserDao userDao;
//    private final JwtUtil jwtUtil;
//    @Override
//    protected void doFilterInternal(@NotNull HttpServletRequest request,
//                                    @NotNull HttpServletResponse response,
//                                    @NotNull FilterChain filterChain) throws ServletException, IOException {
//        final String authHeader = request.getHeader(AUTHORIZATION);
//        final String userLogin;
//        final String jwtToken;
//
//        if(authHeader == null || authHeader.startsWith("Bearer")){
//            filterChain.doFilter(request, response);
//            return;
//        }
//        jwtToken = authHeader.substring(7);
//        userLogin = jwtUtil.extractUsername(jwtToken);
//        if(userLogin != null && SecurityContextHolder.getContext().getAuthentication() == null){
//            UserDetails userDetails = userDao.findUserByUsername(userLogin);
//            final boolean isTokenValid = jwtUtil.validateToken(jwtToken,userDetails);
//            if(isTokenValid){
//                UsernamePasswordAuthenticationToken authenticationToken =
//                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//            }
//            filterChain.doFilter(request,response);
//        }
//    }
}
