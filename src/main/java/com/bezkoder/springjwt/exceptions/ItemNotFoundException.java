package com.bezkoder.springjwt.exceptions;

public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(Long id){
        super("Could not find the item with id "+ id);
    }
}
