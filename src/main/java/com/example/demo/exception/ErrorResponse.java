package com.example.demo.exception;

// 属性要有getter, 异常处理的返回体才能正常返回
public class ErrorResponse {
    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    private String errorCode;

    private String errorMsg;

    public ErrorResponse(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
