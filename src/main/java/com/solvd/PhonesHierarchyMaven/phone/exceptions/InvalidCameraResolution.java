package main.java.com.solvd.PhonesHierarchyMaven.phone.exceptions;

public class InvalidCameraResolution extends RuntimeException{
    public InvalidCameraResolution(String message){
        super(message);
    }
    public InvalidCameraResolution(){
        super("The camera resolution must be a number greater than 0");
    }
}
