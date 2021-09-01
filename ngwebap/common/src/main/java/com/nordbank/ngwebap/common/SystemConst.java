package com.nordbank.ngwebap.common;

public class SystemConst {
    /** jwt effective time: 5 days */
    public static final long EXPIRATIONTIME = 432_000_000;
    public static final byte[] key = "nordbank2021char".getBytes();
    public static final String TOKEN_PREFIX = "Bearer";
    public static final String HEADER_STRING = "Authorization";
}
