package main.java.com.solvd.PhonesHierarchyMaven.phone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class SmartPhone extends Phone{
    private static final Logger LOGGER = LogManager.getLogger(SmartPhone.class);
    private String operatingSystem;
    private boolean dualSim;

    public SmartPhone(String brand, String model, int batteryCapacity, int batteryState, int cameraResolutionMP, String chargeConnectivity, double displayInchesSize, String CPU, int storageGB, int ramGB, String operatingSystem, boolean dualSim,long phoneNumber, double price, double weight) {
        super(brand, model, batteryCapacity, batteryState, cameraResolutionMP, chargeConnectivity, displayInchesSize, CPU, storageGB, ramGB, phoneNumber, price, weight);
        this.operatingSystem = operatingSystem;
        this.dualSim = dualSim;
    }
    public SmartPhone(String brand, String model, String CPU, String operatingSystem) {
        super(brand, model, CPU);
        this.operatingSystem = operatingSystem;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public boolean hasDualSim() {
        return dualSim;
    }

    public void setDualSim(boolean dualSim) {
        this.dualSim = dualSim;
    }

    public void printExtraInformation(){
        LOGGER.info("The price of the SmartPhone "+this.phoneName()+": $"+price+" - The weight is: "+weight+"g");
        this.printNumber();
    }

    public void expensivePhone(){
        if(priceHigherThan1000()){
            LOGGER.info("The price of the SmartPhone is higher than $1000");
        }else{
            LOGGER.info("The price of the SmartPhone is equals to or lower than $1000");
        }
    }

    @Override
    public void alarm() {
        LOGGER.info("Alarm from SmartPhone: "+this.phoneName());
    }

    @Override
    public String toString() {
        return super.toString()+
                "\t" + "OperatingSystem=" + operatingSystem + '\n' +
                "\t" + "DualSim=" + dualSim + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmartPhone that = (SmartPhone) o;
        return dualSim == that.dualSim && Objects.equals(operatingSystem, that.operatingSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), operatingSystem, dualSim);
    }

    @Override
    public void call() {
        LOGGER.info("Calling from SmartPhone");
    }

    @Override
    public void charge() {
        if(this.getBattery().getBatteryState()==100)
            LOGGER.info("The SmartPhone battery is fully charged");
        else
            LOGGER.info("Charging SmartPhone");
    }

    @Override
    public void saveContact(String contactName, long contactNumber) {
        super.saveContact(contactName,contactNumber);
        LOGGER.info("Contact saved in SmartPhone: "+contactName+" "+contactNumber);
    }

    @Override
    public void takeAPicture(String pictureName) {
        this.getPicturesNamesList().add(pictureName);
        LOGGER.info("Photo taken from a SmartPhone: "+pictureName);
    }
    @Override
    public void recordAVideo(String videoName) {
        this.getVideosNamesList().add(videoName);
        LOGGER.info("Video recorded from a SmartPhone: "+videoName);
    }

    @Override
    public void turnOn() {
        if(this.getBattery().getBatteryState()>0)
            LOGGER.info("The SmartPhone turned on");
        else
            LOGGER.info("The SmartPhone is not charged");
    }

}
