package com.bezkoder.springjwt.exceptions;

public class UserNFException extends RuntimeException{
    public UserNFException(Long id){
        super("Could not find the user with id "+ id);
    }
}
