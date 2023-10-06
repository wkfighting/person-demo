package com.example.demo.exception;

public enum ErrorCode {
    PARAMS_ERROR("1001", "invalid params.");
    private final String errorCode;
    private final String errorMsg;

    ErrorCode(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
