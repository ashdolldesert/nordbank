package com.nordbank.ngwebap.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UrlPathHelper;

@RestController
public class CommonController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @RequestMapping("/**")
    public String all(HttpServletRequest request, HttpServletResponse response, @RequestBody(required = false) String reqBody) {
        String path = new UrlPathHelper().getPathWithinApplication(request);
        String method = request.getMethod();
        boolean isGET = method.equals("GET");
        boolean isPOST = method.equals("POST");
        boolean isPUT = method.equals("PUT");
        boolean isHEAD = method.equals("HEAD");
        boolean isDELETE = method.equals("DELETE");
        boolean isPATCH = method.equals("PATCH");
        boolean isOPTIONS = method.equals("OPTIONS");
        if (path.startsWith("/api")) {
            return api(request, response, reqBody, method, path);
        } else if (path.startsWith("/publicApi")) {
            return publicApi(request, response, reqBody, method, path);
        } else {
            return path;
        }
    }

    /**
     * @RequestMapping("/api")
     */
    public String api(HttpServletRequest request, HttpServletResponse response, String reqBody, String method, String path) {
        // TODO        
        return "api";
    }

    /**
     * @RequestMapping("/publicApi")
     */
    public String publicApi(HttpServletRequest request, HttpServletResponse response, String reqBody, String method, String path) {
        // TODO
        return "publicApi";
    }
}
