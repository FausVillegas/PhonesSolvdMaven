package main.java.com.solvd.PhonesHierarchyMaven.phone.features;

import main.java.com.solvd.PhonesHierarchyMaven.phone.enums.PeripheralType;
import main.java.com.solvd.PhonesHierarchyMaven.phone.interfaces.lambda_functions.IReceivesInformation;
import main.java.com.solvd.PhonesHierarchyMaven.phone.interfaces.lambda_functions.ISendsInformation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Processor implements IReceivesInformation<String>, ISendsInformation<String> {
    private static final Logger LOGGER = LogManager.getLogger(Battery.class);
    private String CPU;

    private final PeripheralType peripheralType = PeripheralType.INPUT_OUTPUT;

    public Processor(String CPU) {
        this.CPU = CPU;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    @Override
    public String toString() {
        return "Processor{" +
                "peripheralType= "+peripheralType.name()+
                "CPU='" + CPU + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Processor processor = (Processor) o;
        return Objects.equals(CPU, processor.CPU) && peripheralType == processor.peripheralType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(CPU, peripheralType);
    }

    @Override
    public void receivesInformation(String data) {
        System.out.println("The processor receives information:"+data);
    }

    @Override
    public void sendInformation(String data) {
        LOGGER.info("The processor sends the information: "+data);
    }
}
