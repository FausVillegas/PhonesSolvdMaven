package main.java.com.solvd.PhonesHierarchyMaven.phone.enums;

public enum PeripheralType {
    OUTPUT("Send information"),
    INPUT("Receives information"),
    INPUT_OUTPUT("Send and receive information");
    private final String description;
    PeripheralType(String description) {
        this.description = description;
    }
    public String getDescription(){
        return description;
    }
}
