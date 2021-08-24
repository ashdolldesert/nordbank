package com.nordbank.ngwebap.common.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResp {
    private String uniqId = "";
    private String idno = "";
    private String ipAddress = "";
}
