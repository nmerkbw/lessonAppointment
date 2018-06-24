package com.ssm.exception;

/**
 * 预约异常
 * */
public class AppoinException extends RuntimeException {

    public AppoinException(String message) {

        super(message);
    }

    public AppoinException(String message, Throwable cause) {

        super(message, cause);
    }
}
