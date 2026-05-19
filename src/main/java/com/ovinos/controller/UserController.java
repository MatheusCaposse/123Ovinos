package com.ovinos.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.Authenticator;

@RestController
@RequestMapping
public class UserController {

    @GetMapping("/user")
    public Object user(Authentication authentication){

        return authentication.getPrincipal();
    }
}
