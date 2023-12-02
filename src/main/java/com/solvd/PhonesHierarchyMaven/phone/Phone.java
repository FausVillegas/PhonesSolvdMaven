package main.java.com.solvd.PhonesHierarchyMaven.phone;

import main.java.com.solvd.PhonesHierarchyMaven.phone.enums.Brand;
import main.java.com.solvd.PhonesHierarchyMaven.phone.enums.ChargingConnection;
import main.java.com.solvd.PhonesHierarchyMaven.phone.exceptions.*;
import main.java.com.solvd.PhonesHierarchyMaven.phone.features.*;
import main.java.com.solvd.PhonesHierarchyMaven.phone.interfaces.*;
import main.java.com.solvd.PhonesHierarchyMaven.phone.interfaces.lambdafunctions.ICall;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.InvalidParameterException;
import java.util.*;

public abstract class Phone implements ICharge, ICall<String>, ISaveContact, ITakeAPicture, IRecordAVideo, ITurnOn {
    private static final Logger LOGGER = LogManager.getLogger(Phone.class);
    private static int ObjectsPhoneCreated;

    static {
        LOGGER.info("Phone/s created");
    }

    private Map<String, Long> contactList = new TreeMap<>();

    private List<String> picturesNamesList = new ArrayList<>();

    private List<String> videosNamesList = new ArrayList<>();

    private Set<String> apps = new HashSet<>();

    public Map<String, Long> getContactList() {
        return contactList;
    }

    public void setContactList(TreeMap<String, Long> contactList) {
        this.contactList = contactList;
    }

    public List<String> getPicturesNamesList() {
        return picturesNamesList;
    }

    public void setPicturesNamesList(List<String> picturesNamesList) {
        this.picturesNamesList = picturesNamesList;
    }

    public List<String> getVideosNamesList() {
        return videosNamesList;
    }

    public void setVideosNamesList(List<String> videosNamesList) {
        this.videosNamesList = videosNamesList;
    }

    public Set<String> getApps() {
        return apps;
    }

    public void setApps(Set<String> apps) {
        this.apps = apps;
    }
    public abstract void charge();

    @Override
    public void saveContact(String contactName, long contactNumber) {
        contactList.put(contactName,contactNumber);
    }

    public void showContactList(){
        LOGGER.info("ContactList "+model+" "+brandEnum.getName()+": ");
        contactList.forEach((k,v) -> LOGGER.info(k+": "+v));
    }

    public void showPicturesNamesList(){
        LOGGER.info("PicturesNamesList "+model+" "+brandEnum.getName()+": ");
        picturesNamesList.forEach(LOGGER::info);
    }

    public void showVideosNamesList(){
        LOGGER.info("VideosNamesList "+model+" "+brandEnum.getName()+": ");
        videosNamesList.forEach(LOGGER::info);
    }

    public void showApps() {
        LOGGER.info("Apps "+brandEnum.getName()+" "+model+": ");
        apps.forEach(LOGGER::info);
    }

    private ChargingConnection chargingConnectionEnum;
    private Brand brandEnum;
    private final String model;
    private Battery battery;
    private Camera camera;
    private Display display;
    private Processor processor;
    private StorageMemory storageMemory;

    protected long phoneNumber;
    protected double price;
    protected double weight;

    public static void exceptionOccurs(int batteryCapacity, int batteryState, int cameraResolution, double price, double weight) {
        if(batteryCapacity<=0)
            throw new BatteryCapacityException();
        if(batteryState<0 || batteryState>100)
            throw new BatteryStateException();
        if(cameraResolution<=0)
            throw new InvalidCameraResolution();
        if(price<0)
            throw new InvalidPriceException();
        if(weight<=0)
            throw new InvalidWeightException();
    }

    public Phone(Brand brandEnum, ChargingConnection chargingConnectionEnum, String model, int batteryCapacity, int batteryState, int cameraResolutionMP, double displayInchesSize, String CPU, int storageGB, double ramGB,
                 long phoneNumber, double price, double weight) {
        this.chargingConnectionEnum = chargingConnectionEnum;
        this.brandEnum = brandEnum;

        this.model = model;
        try {
            exceptionOccurs(batteryCapacity, batteryState, cameraResolutionMP, price, weight);
        }catch (BatteryCapacityException e){
            LOGGER.error("InvalidBatteryCapacityException: "+e.getMessage());
        }catch (BatteryStateException e){
            LOGGER.error("InvalidBatteryStateException: "+e.getMessage());
        }catch (InvalidPriceException e){
            LOGGER.error("InvalidPriceException: "+e.getMessage());
        }catch (InvalidWeightException e){
            LOGGER.error("InvalidWeightException: "+e.getMessage());
        }catch (InvalidParameterException e){
            LOGGER.error(e.getMessage());
        }
        this.battery = new Battery(batteryCapacity, batteryState);
        this.camera = new Camera(cameraResolutionMP);
        this.display = new Display(displayInchesSize);
        this.processor = new Processor(CPU);
        this.storageMemory = new StorageMemory(storageGB, ramGB);
        this.phoneNumber = phoneNumber;
        this.price = price;
        this.weight = weight;
        ObjectsPhoneCreated++;
    }

    public ChargingConnection getChargingConnectionEnum() {
        return (ChargingConnection) chargingConnectionEnum;
    }
    public Brand getBrandEnum() {
        return (Brand) brandEnum;
    }

    public Phone(Brand brandEnum, String model, String CPU) {
        this.brandEnum = brandEnum;
        this.model = model;
        this.processor = new Processor(CPU);
        ObjectsPhoneCreated++;
    }

    public static int getObjectsPhoneCreated() {
        return ObjectsPhoneCreated;
    }

    public String getModel() {
        return model;
    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public StorageMemory getStorageMemory() {
        return storageMemory;
    }

    public void setStorageMemory(StorageMemory storageMemory) {
        this.storageMemory = storageMemory;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        try {
            this.price = price;
        }catch (InvalidPriceException e) {
            LOGGER.error("InvalidPriceException: "+e.getMessage());
        }
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        try {
            this.weight = weight;
        }catch (InvalidWeightException e) {
            LOGGER.error("InvalidWeightException: "+e.getMessage());
        }
    }

    protected void printNumber(){
        LOGGER.info("Phone number: "+phoneNumber);
    }
    protected boolean priceHigherThan1000(){
        return price>1000;
    }

    public abstract void alarm();

    @Override
    public String toString() {
        return "Phone " + brandEnum.getName() + " " + model + "\n" +
                "\t" + battery + "\n" +
                "\t" + camera.toString()+ "\n" +
                "\t" + chargingConnectionEnum.getConnection() + "\n" +
                "\t" + display.toString() + "\n" +
                "\t" + processor.toString() + "\n" +
                "\t" + storageMemory.toString() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return phoneNumber == phone.phoneNumber && Double.compare(price, phone.price) == 0 && Double.compare(weight, phone.weight) == 0 && Objects.equals(contactList, phone.contactList) && Objects.equals(picturesNamesList, phone.picturesNamesList) && Objects.equals(videosNamesList, phone.videosNamesList) && Objects.equals(apps, phone.apps) && chargingConnectionEnum == phone.chargingConnectionEnum && brandEnum == phone.brandEnum && Objects.equals(model, phone.model) && Objects.equals(battery, phone.battery) && Objects.equals(camera, phone.camera) && Objects.equals(display, phone.display) && Objects.equals(processor, phone.processor) && Objects.equals(storageMemory, phone.storageMemory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactList, picturesNamesList, videosNamesList, apps, chargingConnectionEnum, brandEnum, model, battery, camera, display, processor, storageMemory, phoneNumber, price, weight);
    }

    public abstract void printExtraInformation();

    public abstract void expensivePhone();

    public final String phoneName(){
        return brandEnum.getName()+" "+model;
    }

    public void installApp(String appName){
        LOGGER.info("App "+appName+" installed in "+brandEnum.getName()+" "+model);
        apps.add(appName);
    }
}
