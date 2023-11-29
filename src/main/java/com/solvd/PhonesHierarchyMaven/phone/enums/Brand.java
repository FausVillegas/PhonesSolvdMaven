package main.java.com.solvd.PhonesHierarchyMaven.phone.enums;

public enum Brand {
    SAMSUNG("Samsung"),
    IPHONE("IPhone"),
    ASUS("Asus"),
    CAT("CAT"),
    NOKIA("Nokia"),
    MOTOROLA("Motorola");

    private final String name;
    Brand(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
