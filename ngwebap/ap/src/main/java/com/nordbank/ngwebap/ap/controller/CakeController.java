package com.nordbank.ngwebap.ap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cake")
public class CakeController {
    
    @GetMapping("/alive")
    public String getAlive() {
        return "{status: '0', message: 'GET /cake/alive', result: {}}";
    }

    @PostMapping("/alive")
    public String postAlive() {
        return "{status: '0', message: 'POST /cake/alive', result: {}}";
    }
}
