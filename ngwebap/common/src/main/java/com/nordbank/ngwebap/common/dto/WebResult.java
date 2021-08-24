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

    @Override
    public String toString() {
        return new GsonBuilder().serializeNulls().disableHtmlEscaping().create().toJson(this);
        //return new Gson().toJson(this);
    }

    public static String GetResultString(Integer status, String message, Object result) {

        //return new WebResult(status, message, result).toString();
        String resultString = new WebResult(status, message, result).toString();
        
        // if(ESAPI.validator().isValidInput("WebResult", resultString, "Space", Integer.MAX_VALUE, false , false)){
            return resultString;
        // }else{
        //     return new WebResult(99, "Invalid Result", null).toString();
        // }
    }
    public static String GetResultString(Integer status, String message) {
        return GetResultString(status, message, null);
    }

    public static String GetSuccessResult(Object result) {
        // if(result==null){
            result = "";
        // }
        return GetResultString(0, "成功", result);
    }
    public static String GetSuccessResult() {
        return GetSuccessResult(null);
    }

    public static String GetFailResult(){
        return GetResultString(9, "Invalid Input", null);
    }
    public static String GetFailResult(String msg){
        return GetResultString(9, msg, null);
    }
    public static String GetSystemFailResult(){
        return GetResultString(99, "系統錯誤", null);
    }
}
