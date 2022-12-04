package com.musinsa.shop.common.exception;

import org.springframework.http.HttpStatus;

public class ThrottleException extends RuntimeException {

    private int code = HttpStatus.TOO_MANY_REQUESTS.value();

    public ThrottleException(){
        super("Many Request");
    }

    public ThrottleException(String message){
        super(message);
    }

    public ThrottleException(int code, String message){
        super(message);
        this.code = code;
    }

    public ThrottleException(int code, String message, Throwable cause){
        super(message, cause);
        this.code = code;
    }
}
