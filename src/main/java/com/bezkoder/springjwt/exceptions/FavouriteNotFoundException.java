package com.bezkoder.springjwt.exceptions;

public class FavouriteNotFoundException extends RuntimeException{
    public FavouriteNotFoundException(Long id){
        super("Could not find the favourite with id "+ id);
    }
}
