package main.java.com.solvd.PhonesHierarchyMaven.phone.exceptions;

public class InvalidIntScanner extends Exception{
    public InvalidIntScanner(String message){
        super(message);
    }
    public InvalidIntScanner(){
        super("The scanner int value is invalid");
    }
}
