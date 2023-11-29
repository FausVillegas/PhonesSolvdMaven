package main.java.com.solvd.PhonesHierarchyMaven.phone.features;

import main.java.com.solvd.PhonesHierarchyMaven.phone.enums.PeripheralType;
import main.java.com.solvd.PhonesHierarchyMaven.phone.interfaces.lambda_functions.ISendsInformation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.impl.Log4jContextFactory;

import java.util.Objects;

public class Display implements ISendsInformation<String> {
    private static final Logger LOGGER = LogManager.getLogger(Battery.class);
    private double inchesSize;
    private final PeripheralType peripheralType = PeripheralType.OUTPUT;
    public Display(double inchesSize) {
        this.inchesSize = inchesSize;
    }

    public double getInchesSize() {
        return inchesSize;
    }

    public void setInchesSize(float inchesSize) {
        this.inchesSize = inchesSize;
    }

    public PeripheralType getPeripheralType() {
        return peripheralType;
    }

    @Override
    public String toString() {
        return "Display{" +
                "peripheralType= "+ peripheralType.name()+
                "size=" + inchesSize + '"' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Display display = (Display) o;
        return Double.compare(inchesSize, display.inchesSize) == 0 && peripheralType == display.peripheralType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inchesSize, peripheralType);
    }

    @Override
    public void sendInformation(String data) {
        LOGGER.info("The display sends the information: "+data);
    }
}
