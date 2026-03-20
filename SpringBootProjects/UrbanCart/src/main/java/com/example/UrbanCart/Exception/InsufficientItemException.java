package com.example.UrbanCart.Exception;

public class InsufficientItemException extends  RuntimeException{
    public InsufficientItemException(String message) {
        super(message);
    }
}
