package com.example.demo.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.JwtAuthResponseDto;
import com.example.demo.dto.LoginRequestDto;
import com.example.demo.security.JwtService;

import lombok.RequiredArgsConstructor;

//@RestController
//@RequestMapping("/api/auth")
//@RequiredArgsConstructor
//public class AuthController {
//
//    private final AuthenticationManager authenticationManager;
//    private final JwtService jwtService;
//
//    @PostMapping("/login")
//    public JwtAuthResponseDto login(@RequestBody LoginRequestDto request) {
//
//        Authentication authentication =
//                authenticationManager.authenticate(
//                        new UsernamePasswordAuthenticationToken(
//                                request.getUsername(),
//                                request.getPassword()));
//
//        String token =
//                jwtService.generateToken(
//                        (org.springframework.security.core.userdetails.UserDetails)
//                                authentication.getPrincipal());
//
//        return new JwtAuthResponseDto(
//                token,
//                "Bearer",
//                request.getUsername());
//    }
//}

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @PostMapping("/login")
    public JwtAuthResponseDto login(
            @RequestBody LoginRequestDto request) {

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getUsername(),
                                request.getPassword()));

        String token =
                jwtService.generateToken(
                        (UserDetails) authentication.getPrincipal());

        return new JwtAuthResponseDto(
                token,
                "Bearer",
                request.getUsername());
    }
}