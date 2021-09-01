package com.nordbank.ngwebap.web.jwt;

import static com.nordbank.ngwebap.common.util.RequestUtil.getIpAddr;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nordbank.ngwebap.common.dto.WebResult;
import com.nordbank.ngwebap.common.dto.view.LoginView;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import nl.basjes.parse.useragent.UserAgent;
import nl.basjes.parse.useragent.UserAgentAnalyzer;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private final UserAgentAnalyzer uaa;

    public JWTLoginFilter(String url, AuthenticationManager authManager) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);

        uaa = UserAgentAnalyzer
        .newBuilder()
        .withAllFields()
        .build();
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException, ServletException {
        // Scanner s = new Scanner(req.getInputStream()).useDelimiter("\\A");
        // String result = s.hasNext() ? s.next() : "";
        // logger.info(result);
        LoginView loginAuth = new ObjectMapper().readValue(req.getInputStream(), LoginView.class);
        loginAuth.setIpAddress(getIpAddr(req));
        
        // UserAgent
        // - user_agent_string: 'Mozilla/5.0 (Linux; Android 7.0; Nexus 6 Build/NBD90Z) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.124 Mobile Safari/537.36'
        // DeviceClass                      : 'Phone'
        // DeviceName                       : 'Google Nexus 6'
        // DeviceBrand                      : 'Google'
        // OperatingSystemClass             : 'Mobile'
        // OperatingSystemName              : 'Android'
        // OperatingSystemVersion           : '7.0'
        // OperatingSystemVersionMajor      : '7'
        // OperatingSystemNameVersion       : 'Android 7.0'
        // OperatingSystemNameVersionMajor  : 'Android 7'
        // OperatingSystemVersionBuild      : 'NBD90Z'
        // LayoutEngineClass                : 'Browser'
        // LayoutEngineName                 : 'Blink'
        // LayoutEngineVersion              : '53.0'
        // LayoutEngineVersionMajor         : '53'
        // LayoutEngineNameVersion          : 'Blink 53.0'
        // LayoutEngineNameVersionMajor     : 'Blink 53'
        // AgentClass                       : 'Browser'
        // AgentName                        : 'Chrome'
        // AgentVersion                     : '53.0.2785.124'
        // AgentVersionMajor                : '53'
        // AgentNameVersion                 : 'Chrome 53.0.2785.124'
        // AgentNameVersionMajor            : 'Chrome 53'
        UserAgent userAgent = uaa.parse(req.getHeader("User-Agent"));
		String browser = userAgent.getValue("AgentNameVersionMajor");
		String platform = userAgent.getValue("DeviceClass");
        String os = userAgent.getValue("OperatingSystemNameVersionMajor");
        loginAuth.setBrowser(browser);
        loginAuth.setPlatform(platform);
        loginAuth.setOs(os);
        
        UsernamePasswordAuthenticationToken uToken = new UsernamePasswordAuthenticationToken(loginAuth, null);
        Authentication auth = getAuthenticationManager().authenticate(uToken);
        // 返回驗證TOKEN
        return auth;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {
        TokenAuthenticationService.addAuthentication(req, res, auth.getName());
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException failed) throws IOException, ServletException {
        response.setContentType("application/json;charset=UTF-8");
        response.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains; preload");
        response.setStatus(HttpServletResponse.SC_OK);
        String msg = failed.getMessage();
        // if(ESAPI.validator().isValidInput("unsuccessfulAuthentication", msg, "Space", Integer.MAX_VALUE, false)){
        //     response.getWriter().print(new WebResult(500, msg, "").toString());
        // }else{
            response.getWriter().print(new WebResult(500, "", "").toString());
        // }
    }
}