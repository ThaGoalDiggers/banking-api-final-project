package com.bobby.bankingapifinal.dto;

public class SuccessDetails {


    private Integer code;
    private String message;

    private Object object;


    public SuccessDetails() {
    }

    public SuccessDetails(Integer code, String message, Object object) {
        this.code = code;
        this.message = message;
        this.object = object;
    }

    public SuccessDetails(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
