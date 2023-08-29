package com.example.blogwithsecurity.ApiUtils;

public class ApiException extends RuntimeException{

    public ApiException(String errMessage){
        super(errMessage);
    }
}