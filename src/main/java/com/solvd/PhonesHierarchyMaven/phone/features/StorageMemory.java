package com.solvd.PhonesHierarchyMaven.phone.features;

import java.util.Objects;

public class StorageMemory {
    private int storage;
    private double RAM;

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

    @Override
    public String toString() {
        return "StorageMemory{" +
                "storage=" + storage + "GB" +
                ", RAM=" + RAM + "GB" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StorageMemory that = (StorageMemory) o;
        return storage == that.storage && Double.compare(RAM, that.RAM) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(storage, RAM);
    }
}
