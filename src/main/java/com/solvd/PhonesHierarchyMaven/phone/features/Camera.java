package main.java.com.solvd.PhonesHierarchyMaven.phone.features;

import main.java.com.solvd.PhonesHierarchyMaven.phone.enums.PeripheralType;
import main.java.com.solvd.PhonesHierarchyMaven.phone.exceptions.InvalidCameraResolution;
import main.java.com.solvd.PhonesHierarchyMaven.phone.interfaces.lambdafunctions.IReceivesInformation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Camera implements IReceivesInformation<String> {
    private static final Logger LOGGER = LogManager.getLogger(Camera.class);
    private final PeripheralType peripheralType = PeripheralType.INPUT;
    private int rearCameraResolutionMP;

    public Camera(int rearCameraResolutionMP) {
        this.rearCameraResolutionMP = rearCameraResolutionMP;
    }

    public int getRearCameraResolutionMP() {
        return rearCameraResolutionMP;
    }

    public void setRearCameraResolutionMP(int rearCameraResolutionMP) {
        try {
            this.rearCameraResolutionMP = rearCameraResolutionMP;
        }catch (InvalidCameraResolution e){
            LOGGER.error("InvalidCameraResolution"+e.getMessage());
        }
    }

    public PeripheralType getPeripheralType() {
        return peripheralType;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "peripheralType= "+ peripheralType.name() +
                "rearCameraResolution=" + rearCameraResolutionMP + "MP" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camera camera = (Camera) o;
        return rearCameraResolutionMP == camera.rearCameraResolutionMP && peripheralType == camera.peripheralType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(peripheralType, rearCameraResolutionMP);
    }

    @Override
    public void receivesInformation(String data) {
        LOGGER.info("The camera receives photo: "+data);
    }
}
