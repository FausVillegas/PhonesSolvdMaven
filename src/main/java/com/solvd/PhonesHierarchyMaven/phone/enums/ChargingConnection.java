package main.java.com.solvd.PhonesHierarchyMaven.phone.enums;

public enum ChargingConnection {
    MICROUSB("MicroUSB"),
    USBC("USB-C"),
    LIGHTNING("Lightning");

    private final String connection;
    ChargingConnection(String connection) {
        this.connection = connection;
    }

    public String getConnection() {
        return connection;
    }
}
