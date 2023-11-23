package main.java.com.solvd.PhonesHierarchyMaven.phone.features;

import main.java.com.solvd.PhonesHierarchyMaven.phone.exceptions.InvalidCameraResolution;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Camera {
    private static final Logger LOGGER = LogManager.getLogger(Camera.class);
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

    @Override
    public String toString() {
        return "Camera{" +
                "rearCameraResolution=" + rearCameraResolutionMP + "MP" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camera camera = (Camera) o;
        return rearCameraResolutionMP == camera.rearCameraResolutionMP;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rearCameraResolutionMP);
    }
}
