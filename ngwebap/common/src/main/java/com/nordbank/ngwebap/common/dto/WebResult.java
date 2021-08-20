package com.nordbank.ngwebap.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
public class WebResult {
    Integer status;
    String message;
    Object result;
}
