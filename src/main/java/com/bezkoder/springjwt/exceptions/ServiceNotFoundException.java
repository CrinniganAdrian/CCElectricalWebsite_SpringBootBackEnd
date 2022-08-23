package com.bezkoder.springjwt.exceptions;

public class ServiceNotFoundException extends RuntimeException{
    public ServiceNotFoundException(Long id){
        super("Could not find the cervice with id "+ id);
    }
}
