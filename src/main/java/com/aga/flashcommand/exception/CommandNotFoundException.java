package com.aga.flashcommand.exception;

public class CommandNotFoundException extends RuntimeException{
    public CommandNotFoundException(String message){
        super(message);
    }

}
