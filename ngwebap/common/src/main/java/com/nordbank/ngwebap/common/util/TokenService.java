package com.nordbank.ngwebap.common.util;

import java.util.Date;

import com.nimbusds.jose.EncryptionMethod;
import com.nimbusds.jose.JWEAlgorithm;
import com.nimbusds.jose.JWEHeader;
import com.nimbusds.jose.crypto.DirectEncrypter;
import com.nimbusds.jwt.EncryptedJWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nordbank.ngwebap.common.SystemConst;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenService {
    

    protected static Logger logger = LoggerFactory.getLogger(TokenService.class);

    public static String addAuthentication(String json) {

        String jwt = "";
        try {

            // Create the header
            JWEHeader header = new JWEHeader(JWEAlgorithm.DIR, EncryptionMethod.A128GCM);

            JWTClaimsSet.Builder claimsSet = new JWTClaimsSet.Builder();
            
            claimsSet.subject(json);

            claimsSet.expirationTime(new Date(System.currentTimeMillis() + SystemConst.EXPIRATIONTIME));
            // claimsSet.notBeforeTime(new Date());

            // create the EncryptedJWT object
            EncryptedJWT jweObject = new EncryptedJWT(header, claimsSet.build());

            jweObject.encrypt(new DirectEncrypter(SystemConst.key));

            // Serialise to compact JOSE form...
            jwt = jweObject.serialize();
            return jwt;

        } catch (Exception e) {
            logger.error("Unknown exception", e);
            return jwt;
        }

    }

}