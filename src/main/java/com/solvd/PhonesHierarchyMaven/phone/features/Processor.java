package main.java.com.solvd.PhonesHierarchyMaven.phone.features;

import java.util.Objects;

public class Processor {
    private String CPU;

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
                "CPU='" + CPU + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Processor processor = (Processor) o;
        return Objects.equals(CPU, processor.CPU);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CPU);
    }
}
