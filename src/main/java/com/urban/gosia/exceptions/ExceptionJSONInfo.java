package com.urban.gosia.exceptions;

public class ExceptionJSONInfo {
    private String message;

    public ExceptionJSONInfo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}