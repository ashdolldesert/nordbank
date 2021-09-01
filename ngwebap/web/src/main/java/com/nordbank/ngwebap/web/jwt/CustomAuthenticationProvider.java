package com.nordbank.ngwebap.web.jwt;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.nordbank.ngwebap.common.dto.WebResult;
import com.nordbank.ngwebap.common.dto.response.CaseResp;
import com.nordbank.ngwebap.common.dto.view.LoginView;
import com.nordbank.ngwebap.web.dao.HttpDao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private HttpDao httpDao;

    
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public CustomAuthenticationProvider(ApplicationContext appContext) {
        appContext.getAutowireCapableBeanFactory().autowireBean(this);
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        LoginView ac = (LoginView) authentication.getPrincipal();
        Gson gson = new Gson();
        String reqString = gson.toJson(ac);
        if (ac == null) {
            throw new BadCredentialsException("Authentication Failed.");
        } else {
            String resp = httpDao.getAPResponseNoAuth("login", reqString);
            logger.info("### ap resp:" + resp);
            WebResult result = gson.fromJson(resp, WebResult.class);
            if (result.getStatus() == 0 && !result.getResult().equals("")) {
                String principal = gson.toJson(result.getResult());
                CaseResp caseResp = gson.fromJson(principal, CaseResp.class);
                if (!caseResp.getLoginResp().getUniqId().equals("")) {
                    ArrayList<GrantedAuthority> authorities = new ArrayList<>();
                    Authentication auth = new UsernamePasswordAuthenticationToken(principal, null,
                            authorities);
                    return auth;
                } else {
                    throw new BadCredentialsException(result.getMessage());
                }
            } else {
                throw new BadCredentialsException(result.getMessage());
            }

        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}