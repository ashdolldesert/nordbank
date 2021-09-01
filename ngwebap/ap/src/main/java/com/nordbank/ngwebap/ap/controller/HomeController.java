package com.nordbank.ngwebap.ap.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/")
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "{status: '0', message: '', result: {}}";
    }

    @GetMapping("/login")
    public String login() {
        return "{status: '0', message: 'login', result: {}}";
    }
}