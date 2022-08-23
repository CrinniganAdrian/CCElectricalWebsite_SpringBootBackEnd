package com.bezkoder.springjwt.exceptions;

public class ItemNFException extends RuntimeException{
    public ItemNFException(Long id){
        super("Could not find the item with id "+ id);
    }
}
