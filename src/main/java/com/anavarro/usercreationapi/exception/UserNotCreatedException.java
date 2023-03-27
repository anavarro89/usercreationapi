package com.anavarro.usercreationapi.exception;

public class UserNotCreatedException extends RuntimeException{

    public UserNotCreatedException(){
        super();
    }

    public UserNotCreatedException(String message){
        super(message);
    }

}
