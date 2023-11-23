package main.java.com.solvd.PhonesHierarchyMaven.phone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class GamingPhone extends SmartPhone{
    private static final Logger LOGGER = LogManager.getLogger(RuggedPhone.class);
    private boolean gamingMode;
    private Set<String> videoGames = new HashSet<>();

    public void installVideoGame(String nameGame){
        videoGames.add(nameGame);
    }

    public void showVideoGames(){
        LOGGER.info("List of video games");
        for (String game: videoGames) {
            LOGGER.info(game);
        }
    }

    public Set<String> getVideoGames() {
        return videoGames;
    }

    public void setVideoGames(Set<String> videoGames) {
        this.videoGames = videoGames;
    }

    public GamingPhone(String brand, String model, int batteryCapacity, int batteryState, int cameraResolutionMP, String chargeConnectivity, double displayInchesSize, String CPU, int storageGB, int ramGB, String operatingSystem, boolean dualSim, boolean gamingMode, long phoneNumber, double price, double weight) {
        super(brand, model, batteryCapacity, batteryState, cameraResolutionMP, chargeConnectivity, displayInchesSize, CPU, storageGB, ramGB, operatingSystem, dualSim, phoneNumber, price, weight);
        this.gamingMode = gamingMode;
    }
    public GamingPhone(String brand, String model, String CPU, String operatingSystem) {
        super(brand, model, CPU, operatingSystem);
    }

    public boolean hasGamingMode() {
        return gamingMode;
    }

    public void setGamingMode(boolean gamingMode) {
        this.gamingMode = gamingMode;
    }

    @Override
    public void alarm() {
        LOGGER.info("Alarm from GamingPhone: "+this.phoneName());
    }

    @Override
    public String toString() {
        return super.toString() +
                "\tGamingMode=" + gamingMode + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GamingPhone that = (GamingPhone) o;
        return gamingMode == that.gamingMode;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gamingMode);
    }

    @Override
    public void call() {
        LOGGER.info("Calling from GamingPhone");
    }

    @Override
    public void charge() {
        if(this.getBattery().getBatteryState()==100)
            LOGGER.info("The GamingPhone battery is fully charged");
        else
            LOGGER.info("Charging GamingPhone");
    }

    @Override
    public void saveContact(String contactName, long contactNumber) {
        this.getContactList().put(contactName,contactNumber);
        LOGGER.info("Contact saved in GamingPhone: "+contactName+" "+contactNumber);
    }

    @Override
    public void takeAPicture(String pictureName) {
        this.getPicturesNamesList().add(pictureName);
        LOGGER.info("Photo taken from a GamingPhone: "+pictureName);
    }

    @Override
    public void turnOn() {
        if(this.getBattery().getBatteryState()>0)
            LOGGER.info("The GamingPhone turned on");
        else
            LOGGER.info("The GamingPhone is not charged");
    }

    @Override
    public void recordAVideo(String videoName) {
        this.getVideosNamesList().add(videoName);
        LOGGER.info("Video recorded from a GamingPhone: "+videoName);
    }
}
