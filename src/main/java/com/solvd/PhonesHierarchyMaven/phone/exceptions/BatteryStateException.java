package com.solvd.PhonesHierarchyMaven.phone.exceptions;

public class BatteryStateException extends RuntimeException{
    public BatteryStateException(String message){
        super(message);
    }
    public BatteryStateException(){
        super("Battery state must be greater than 0 and less than 100");
    }
}
