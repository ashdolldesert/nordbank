package com.nordbank.ngwebap.common.dto.view;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginView {
  
    private String uniqType;
    private String idno;
    private String birthday ;
    private String phone;
    private String ipAddress ;
    private String browser ;
    private String platform ;
    private String os ;

}