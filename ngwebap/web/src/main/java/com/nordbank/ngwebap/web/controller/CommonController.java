package com.nordbank.ngwebap.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommonController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @RequestMapping("/**")
    public String all(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = false) String reqBody) {
        String uri = request.getRequestURI();
        return uri;
    }
}
