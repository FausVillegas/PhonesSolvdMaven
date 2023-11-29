package main.java.com.solvd.PhonesHierarchyMaven.phone;

import main.java.com.solvd.PhonesHierarchyMaven.phone.enums.Brand;
import main.java.com.solvd.PhonesHierarchyMaven.phone.enums.ChargingConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public final class FeaturePhone extends Phone {
    private static final Logger LOGGER = LogManager.getLogger(RuggedPhone.class);
    private boolean physicalKeyboard;
    private boolean internetCapability;

    public FeaturePhone(Brand brandEnum,ChargingConnection chargingConnectionEnum,
                        String model, int batteryCapacity, int batteryState, int cameraResolutionMP, double displayInchesSize, String CPU, int storageGB, double ramGB, boolean physicalKeyboard, boolean internetCapability, long phoneNumber, double price, double weight) {
        super(brandEnum,chargingConnectionEnum, model, batteryCapacity, batteryState, cameraResolutionMP, displayInchesSize, CPU, storageGB, ramGB, phoneNumber, price, weight);
        this.physicalKeyboard = physicalKeyboard;
        this.internetCapability = internetCapability;
    }
    public FeaturePhone(Brand brand, String model, String CPU, boolean internetCapability ) {
        super(brand, model, CPU);
        this.internetCapability = internetCapability;
    }

    public boolean hasPhysicalKeyboard() {
        return physicalKeyboard;
    }

    public void setPhysicalKeyboard(boolean physicalKeyboard) {
        this.physicalKeyboard = physicalKeyboard;
    }

    public boolean hasInternetCapability() {
        return internetCapability;
    }

    public void setInternetCapability(boolean internetCapability) {
        this.internetCapability = internetCapability;
    }

    public void printExtraInformation(){
        LOGGER.info("The price of the FeaturePhone "+this.phoneName()+": $"+price+" - "+"The weight is: "+weight+"g");
        this.printNumber();
    }

    public void expensivePhone(){
        if(priceHigherThan1000()){
            LOGGER.info("The price of the FeaturePhone is higher than $1000");
        }else{
            LOGGER.info("The price of the FeaturePhone is equals to or lower than $1000");
        }
    }

    @Override
    public void alarm() {
        LOGGER.info("Alarm from FeaturePhone: "+this.phoneName());
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tPhysicalKeyboard=" + physicalKeyboard + "\n" +
                "\tInternetCapability=" + internetCapability ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FeaturePhone that = (FeaturePhone) o;
        return physicalKeyboard == that.physicalKeyboard && internetCapability == that.internetCapability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), physicalKeyboard, internetCapability);
    }

    @Override
    public void callTo(String contact) {
        LOGGER.info("Calling from FeaturePhone to "+contact);
    }

    @Override
    public void charge() {
        if(this.getBattery().getBatteryState()==100)
            LOGGER.info("The FeaturePhone battery is fully charged");
        else
            LOGGER.info("Charging FeaturePhone");
    }

    @Override
    public void saveContact(String contactName, long contactNumber) {
        super.saveContact(contactName,contactNumber);
        LOGGER.info("Contact saved in FeaturePhone: "+contactName+" "+contactNumber);
    }

    @Override
    public void takeAPicture(String pictureName) {
        this.getPicturesNamesList().add(pictureName);
        LOGGER.info("Photo taken from a FeaturePhone: "+pictureName);
    }

    @Override
    public void turnOn() {
        if(this.getBattery().getBatteryState()>0)
            LOGGER.info("The FeaturePhone turned on");
        else
            LOGGER.info("The FeaturePhone is not charged");
    }

    @Override
    public void recordAVideo(String videoName) {
        this.getVideosNamesList().add(videoName);
        LOGGER.info("Video recorded from a FeaturePhone: "+videoName);
    }
}
