package com.facebook.training.facebook.exceptions;

public class CommentNotFoundException extends Exception {

    public CommentNotFoundException(String comment){

        super(comment);
    }
}
