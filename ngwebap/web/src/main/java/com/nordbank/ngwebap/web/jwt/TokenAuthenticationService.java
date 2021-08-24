package com.nordbank.ngwebap.web.jwt;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.nimbusds.jose.crypto.DirectDecrypter;
import com.nimbusds.jwt.EncryptedJWT;
import com.nordbank.ngwebap.common.SystemConst;
import com.nordbank.ngwebap.common.dto.WebResult;
import com.nordbank.ngwebap.common.dto.response.CaseResp;
import com.nordbank.ngwebap.common.dto.response.CaseRespInit;
import com.nordbank.ngwebap.common.util.TokenService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public class TokenAuthenticationService {

    protected static Logger logger = LoggerFactory.getLogger(TokenAuthenticationService.class);

    public static void addAuthentication(HttpServletRequest request, HttpServletResponse response, String principal) {
        try {
            
            Gson gson = new Gson();
            CaseResp caseResp = gson.fromJson(principal, CaseResp.class);
            String jwt = TokenService.addAuthentication(gson.toJson(caseResp.getLoginResp()));          

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Strict-Transport-Security", "max-age=31536000; includeSubDomains; preload");
            response.setStatus(HttpServletResponse.SC_OK);
            CaseRespInit resp = new CaseRespInit(jwt);
            PrintWriter pw = response.getWriter();            
            pw.print(WebResult.GetSuccessResult(resp));

        } catch (Exception e) {
            logger.error("Unknown exception", e);
        }
    }

    static Authentication getAuthentication(HttpServletRequest request) throws Exception {
        String token = request.getHeader(SystemConst.HEADER_STRING);
        String header = null;
        if (token != null) {
            String jwt = token.substring(SystemConst.TOKEN_PREFIX.length());
            EncryptedJWT jweObject = EncryptedJWT.parse(jwt);
            jweObject.decrypt(new DirectDecrypter(SystemConst.key));
            header = jweObject.getJWTClaimsSet().getSubject();
            return (header != null&&!header.equals("")) ? new UsernamePasswordAuthenticationToken(header, null, null) : null;
        }
        return null;
    }

}