package com.example.demo3.exceptions;

public class CartItemNotExistException extends IllegalArgumentException {
    public CartItemNotExistException(String msg){
        super(msg);
    }
}
