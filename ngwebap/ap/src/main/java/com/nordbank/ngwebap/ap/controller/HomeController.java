package com.nordbank.ngwebap.ap.controller;

import com.nordbank.ngwebap.common.dto.WebResult;
import com.nordbank.ngwebap.common.dto.response.CaseResp;
import com.nordbank.ngwebap.common.dto.response.LoginResp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "{status: '0', message: '', result: {}}";
    }

    @RequestMapping("/login")
    public String login() {
        CaseResp resp = new CaseResp();
        LoginResp loginResp = new LoginResp();
        loginResp.setUniqId("LOAN0000000000000");
        loginResp.setIdno("A123123123");
        loginResp.setIpAddress("127.0.0.1");
        resp.setLoginResp(loginResp);
        return WebResult.GetResultString(0, "成功", resp);
        // return "{status: '0', message: 'login', result: {}}";
    }
}