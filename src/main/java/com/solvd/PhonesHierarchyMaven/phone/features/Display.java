package com.solvd.PhonesHierarchyMaven.phone.features;

import java.util.Objects;

public class Display {
    private double inchesSize;

    public Display(double inchesSize) {
        this.inchesSize = inchesSize;
    }

    public double getInchesSize() {
        return inchesSize;
    }

    public void setInchesSize(float inchesSize) {
        this.inchesSize = inchesSize;
    }

    @Override
    public String toString() {
        return "Display{" +
                "size=" + inchesSize + '"' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Display display = (Display) o;
        return Double.compare(inchesSize, display.inchesSize) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(inchesSize);
    }
}
