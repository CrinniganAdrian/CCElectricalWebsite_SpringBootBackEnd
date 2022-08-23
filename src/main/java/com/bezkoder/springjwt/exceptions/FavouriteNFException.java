package com.bezkoder.springjwt.exceptions;

public class FavouriteNFException extends RuntimeException{
    public FavouriteNFException(Long id){
        super("Could not find the favourite with id "+ id);
    }
}
