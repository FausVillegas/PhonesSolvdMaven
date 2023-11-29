package main.java.com.solvd.PhonesHierarchyMaven.phone.features;

import main.java.com.solvd.PhonesHierarchyMaven.phone.enums.PeripheralType;
import main.java.com.solvd.PhonesHierarchyMaven.phone.interfaces.lambda_functions.IReceivesInformation;
import main.java.com.solvd.PhonesHierarchyMaven.phone.interfaces.lambda_functions.ISendsInformation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.GenericDeclaration;
import java.util.Objects;

public class StorageMemory implements IReceivesInformation<String>, ISendsInformation<String> {
    private static final Logger LOGGER = LogManager.getLogger(Battery.class);
    private int storage;
    private double RAM;

    private final PeripheralType peripheralType = PeripheralType.INPUT_OUTPUT;

    public StorageMemory(int storage, double RAM) {
        this.storage = storage;
        this.RAM = RAM;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public double getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public PeripheralType getPeripheralType() {
        return peripheralType;
    }

    @Override
    public String toString() {
        return "StorageMemory{" +
                "peripheralType= "+peripheralType.name()+
                "storage=" + storage + "GB" +
                ", RAM=" + RAM + "GB" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageMemory that = (StorageMemory) o;
        return storage == that.storage && Double.compare(RAM, that.RAM) == 0 && peripheralType == that.peripheralType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(storage, RAM, peripheralType);
    }

    @Override
    public void receivesInformation(String data) {
        LOGGER.info("The memory receives information: "+data);
    }

    @Override
    public void sendInformation(String data) {
        LOGGER.info("The memory sends the information: "+data);
    }
}
