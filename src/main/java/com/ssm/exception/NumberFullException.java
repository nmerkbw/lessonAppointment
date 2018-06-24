package com.ssm.exception;

/**
 * 选课人数满员异常
 * */
public class NumberFullException extends AppoinException {

    public NumberFullException(String message) {

        super(message);
    }

    public NumberFullException(String message, Throwable cause) {

        super(message, cause);
    }
}
