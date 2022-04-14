package com.dumbturtl3.airbnb.exceptions;

public class AuthException extends RuntimeException{
    public AuthException(String message){
        super(message);
    }
}
