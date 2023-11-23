package main.java.com.solvd.PhonesHierarchyMaven.phone.features;

import main.java.com.solvd.PhonesHierarchyMaven.phone.exceptions.BatteryCapacityException;
import main.java.com.solvd.PhonesHierarchyMaven.phone.exceptions.BatteryStateException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Battery{
    private static final Logger LOGGER = LogManager.getLogger(Battery.class);
    private int capacityMah;
    private int batteryState;

    public Battery(int capacityMah, int batteryState) {
        this.capacityMah = capacityMah;
        this.batteryState = batteryState;
    }

    public int getCapacity() {
        return capacityMah;
    }

    public void setCapacity(int capacityMah) {
        try {
            if(capacityMah<=0)
                throw new BatteryCapacityException();
            this.capacityMah = capacityMah;
        }catch (BatteryCapacityException e) {
            LOGGER.error("InvalidBatteryCapacityException: "+e.getMessage());
        }
    }

    public int getBatteryState() {
        return batteryState;
    }

    public void setBatteryState(int batteryState) {
        try {
            if(batteryState<0 || batteryState>100)
                throw new BatteryStateException();
            this.batteryState = batteryState;
        }catch (BatteryCapacityException e) {
            LOGGER.error("InvalidBatteryStatusException: "+e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Battery{" +
                "capacityMah=" + capacityMah +
                ", batteryState=" + batteryState +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Battery battery = (Battery) o;
        return capacityMah == battery.capacityMah && batteryState == battery.batteryState;
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacityMah, batteryState);
    }
}
