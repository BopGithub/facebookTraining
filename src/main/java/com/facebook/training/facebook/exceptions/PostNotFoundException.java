package com.facebook.training.facebook.exceptions;

public class PostNotFoundException extends Exception{

    public PostNotFoundException(String post){

        super(post);
    }

}
