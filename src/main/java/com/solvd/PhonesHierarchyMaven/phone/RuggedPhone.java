package main.java.com.solvd.PhonesHierarchyMaven.phone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public final class RuggedPhone extends SmartPhone{
    private static final Logger LOGGER = LogManager.getLogger(RuggedPhone.class);
    private String typeRuggedPhone;

    public RuggedPhone(String brand, String model, int batteryCapacity, int batteryState, int cameraResolutionMP, String chargeConnectivity, double displayInchesSize, String CPU, int storageGB, int ramGB, String operatingSystem, boolean dualSim, String typeRuggedPhone, long phoneNumber, double price, double weight) {
        super(brand, model, batteryCapacity, batteryState, cameraResolutionMP, chargeConnectivity, displayInchesSize, CPU, storageGB, ramGB, operatingSystem, dualSim, phoneNumber, price, weight);
        this.typeRuggedPhone = typeRuggedPhone;
    }
    public RuggedPhone(String brand, String model, String CPU, String operatingSystem, String typeRuggedPhone) {
        super(brand, model, CPU, operatingSystem);
        this.typeRuggedPhone = typeRuggedPhone;
    }

    public String getTypeRuggedPhone() {
        return typeRuggedPhone;
    }

    public void setTypeRuggedPhone(String typeRuggedPhone) {
        this.typeRuggedPhone = typeRuggedPhone;
    }

    @Override
    public void alarm() {
        LOGGER.info("Alarm from RuggedPhone: "+this.getBrand()+" "+this.getModel());
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tType of RuggerPhone='" + typeRuggedPhone + "' \n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RuggedPhone that = (RuggedPhone) o;
        return Objects.equals(typeRuggedPhone, that.typeRuggedPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), typeRuggedPhone);
    }

    @Override
    public void call() {
        LOGGER.info("Calling from RuggedPhone");
    }

    @Override
    public void charge() {
        if(this.getBattery().getBatteryState()==100)
            LOGGER.info("The RuggedPhone battery is fully charged");
        else
            LOGGER.info("Charging RuggedPhone");
    }

    @Override
    public void saveContact(String contactName, long contactNumber) {
        this.getContactList().put(contactName,contactNumber);
        LOGGER.info("Contact saved in RuggedPhone: "+contactName+" "+contactNumber);
    }

    @Override
    public void takeAPicture(String pictureName) {
        this.getPicturesNamesList().add(pictureName);
        LOGGER.info("Photo taken from a RuggedPhone: "+pictureName);
    }

    @Override
    public void turnOn() {
        if(this.getBattery().getBatteryState()>0)
            LOGGER.info("The RuggedPhone turned on");
        else
            LOGGER.info("The RuggedPhone is not charged");
    }

    @Override
    public void recordAVideo(String videoName) {
        this.getVideosNamesList().add(videoName);
        LOGGER.info("Video recorded from a RuggedPhone: "+videoName);
    }
}
