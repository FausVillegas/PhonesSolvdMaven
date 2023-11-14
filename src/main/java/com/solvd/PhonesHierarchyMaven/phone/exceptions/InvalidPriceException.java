package com.solvd.PhonesHierarchyMaven.phone.exceptions;

public class InvalidPriceException extends RuntimeException{
    public InvalidPriceException(String message){
        super(message);
    }
    public InvalidPriceException(){
        super("The phone price must be a number greater than 0");
    }
}
