package main.java.com.solvd.PhonesHierarchyMaven.phone.exceptions;

public class InvalidWeightException extends RuntimeException{
    public InvalidWeightException(String message){
        super(message);
    }
    public InvalidWeightException(){
        super("The phone weight must be a number greater than 0");
    }
}
