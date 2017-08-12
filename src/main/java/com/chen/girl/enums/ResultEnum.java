package com.chen.girl.enums;

public enum ResultEnum {

    UNKNOWN_ERROR(-1,"ERROR"),
    SUCCESS(0, "SUCCESS!"),
    PRIMARY_SCHOOL(100,"可能还在上小学"),
    MIDDLE_SCHOOL(101,"可能还在上中学"),

    ;


    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
