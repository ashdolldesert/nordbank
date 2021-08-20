package com.nordbank.ngwebap.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UrlPathHelper;

import org.springframework.util.StringUtils;

@RestController
public class CommonController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @RequestMapping("/**")
    public String all(HttpServletRequest request, HttpServletResponse response, UsernamePasswordAuthenticationToken userAuth, @RequestBody(required = false) String reqBody) {
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
            return api(request, response, userAuth, reqBody, method, path);
        } else if (path.startsWith("/publicApi")) {
            return publicApi(request, response, reqBody, method, path);
        } else {
            return path;
        }
    }

    /**
     * @RequestMapping("/api")
     */
    public String api(HttpServletRequest request, HttpServletResponse response, UsernamePasswordAuthenticationToken userAuth, String reqBody, String method, String path) {
        if (method.equals("GET")) {
            String result = this.httpDao.getAPResponseByGetMethod(path, userAuth);
            if (result.equals("")) {
                result = new WebResult(101, "System is maintaining. Please try again later.", "").toString();
            } else if (result.equals("404")) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return "";
            }
            return result;
        } else if (method.equals("POST")) {
            String requestString = handleRequest(reqBody);
            String result = this.httpDao.getAPResponse(path, requestString, userAuth);
            if (result.equals("")) {
                result = new WebResult(101, "System is maintaining. Please try again later.", "").toString();
            } else if (result.equals("404")) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return "";
            }
        return result;
        }
        return "api";
    }

    /**
     * @RequestMapping("/publicApi")
     */
    public String publicApi(HttpServletRequest request, HttpServletResponse response, String reqBody, String method, String path) {
        if (method.equals("GET")) {
            String result = this.httpDao.getAPResponseNoAuthByGetMethod(path);
            if (result.equals("")) {
                result = new WebResult(101, "System is maintaining. Please try again later.", "").toString();
            } else if (result.equals("404")) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return "";
            }
            return result;
        } else if (method.equals("POST")) {
            String requestString = handleRequest(reqBody);
            String result = this.httpDao.getAPResponseNoAuth(path, requestString);
            if (result.equals("")) {
                result = new WebResult(101, "System is maintaining. Please try again later.", "").toString();
            } else if (result.equals("404")) {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
                return "";
            }
            return result;
        }
        return "publicApi";
    }

    public String handleRequest(String requestString) {
        if (requestString == null || requestString.trim().equals("")) {
            
        }
        // TODO: ESAPI.validator().isValidInput(this.getClass().getName(), requestString, "Space", Integer.MAX_VALUE,false);
        return requestString;
    }

    public String handleResponse(String responseStrinig) {
        return responseStrinig;
    }
}
