package main.java.com.solvd.PhonesHierarchyMaven.phone.exceptions;

public class BatteryCapacityException extends RuntimeException{
    public BatteryCapacityException(String message){
        super(message);
    }
    public BatteryCapacityException(){
        super("BatteryCapacity must be greater than 0");
    }
}
