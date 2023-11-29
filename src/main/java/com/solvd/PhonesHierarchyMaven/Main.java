package main.java.com.solvd.PhonesHierarchyMaven;

import main.java.com.solvd.PhonesHierarchyMaven.phone.customList.CustomLinkedList;
import main.java.com.solvd.PhonesHierarchyMaven.phone.enums.Brand;
import main.java.com.solvd.PhonesHierarchyMaven.phone.enums.ChargingConnection;
import main.java.com.solvd.PhonesHierarchyMaven.phone.exceptions.InvalidIntScanner;
import main.java.com.solvd.PhonesHierarchyMaven.phone.*;
import main.java.com.solvd.PhonesHierarchyMaven.phone.interfaces.lambda_functions.ICall;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        //with all the information
        Phone samsungS22 = new SmartPhone(Brand.SAMSUNG,ChargingConnection.USBC, "S22", 4000, 30, 50, 6.1, "Octa-Core", 128, 8, "Android", true, 1111111111, 900, 130);
        GamingPhone asusRogPhone6DUltimate = new GamingPhone(Brand.ASUS,ChargingConnection.USBC, "ROGPhone6DUltimate", 6000, 40, 50, 6.78, "Mali-G710", 512, 16, "Android 12", true, true, 22222222, 1200, 140);
        Phone catS62Pro = new RuggedPhone(Brand.CAT, ChargingConnection.USBC, "S62 PRO", 4000, 0, 12, 5.7, "Snapdragon 660", 128, 6, "Android", false, "Military", 3333333, 700, 180);
        Phone catS62Pro2 = new RuggedPhone(Brand.CAT,ChargingConnection.USBC, "S62 PRO", 4000, 0, 12, 5.7, "Snapdragon 660", 128, 6, "Android", false, "Military", 3333333, 700, 180);
        Phone nokia5310 = new FeaturePhone(Brand.NOKIA,ChargingConnection.MICROUSB, "5310", 1200, 100, 5, 2.4, "MT6260A", 16, 0.016, true, false, 444444, 300, 100);

        ArrayList<Phone> phonesList = new ArrayList<>();
        phonesList.add(samsungS22);
        phonesList.add(asusRogPhone6DUltimate);
        phonesList.add(catS62Pro);
        phonesList.add(catS62Pro2);
        phonesList.add(nokia5310);

//        collections(samsungS22,asusRogPhone6DUltimate,catS62Pro,catS62Pro2,nokia5310);
//
//        calculateAverageRam(phonesList);
//
//        fileUtils();

        //lambda functions

        //Consumer
        Set<String> brandsList = phonesList.stream().map(x -> x.getBrandEnum().getName()).collect(Collectors.toSet());
        Consumer<String> print = (String str) -> LOGGER.info(str);
        brandsList.forEach(print);

        //Predicate
        String brandToSearch = "CAT";
        Predicate<String> containBrand = x -> x.contains(brandToSearch);
        LOGGER.info(containBrand.test(brandsList.toString()));

        //Function
        double pricesSum = phonesList.stream().mapToDouble(x -> x.getPrice()).sum();
        Function<Double,Double> averagePrice = (Double x) -> x / phonesList.size();
        LOGGER.info(averagePrice.apply(pricesSum));

        //Supplier
        Supplier<Integer> phonesWithoutBatteryAmount = () -> {
            return (int) phonesList.stream().filter(p -> p.getBattery().getBatteryState()==0).count();
        };
        LOGGER.info(phonesWithoutBatteryAmount.get());

        //Runnable
        Runnable printPhonesData = () -> {
            for (Phone phone : phonesList) {
                print.accept(phone.toString());
            }
        };
        printPhonesData.run();

        
        samsungS22.callTo("Fausto Villegas");
        samsungS22.getStorageMemory().receivesInformation("Information received");
        samsungS22.getStorageMemory().sendInformation("Information sent");

        //Enums
        LOGGER.info(samsungS22.getBrandEnum().getName());
        LOGGER.info(samsungS22.getChargingConnectionEnum().getConnection());
        LOGGER.info(samsungS22.getCamera().getPeripheralType().getDescription());

    }

    public static void fileUtils(){
        // The files strings.txt and output.txt are in the directory: resources
        File stringsFile = new File("src/main/resources/strings.txt");

        String content = null;
        try {
            content = FileUtils.readFileToString(stringsFile,"UTF-8");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        content = content.replaceAll("[^A-Za-z ]", "");

        String[] words = StringUtils.split(content);

        Set<String> uniqueWords = new HashSet<>();
        for(String word : words){
            uniqueWords.add(word.toLowerCase());
        }

        try {
            FileUtils.writeStringToFile(new File("src/main/resources/output.txt"),"Total unique words: "+uniqueWords.size()+"\n", Charset.defaultCharset(),false);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void collections(Phone samsungS22, Phone asusRogPhone6DUltimate, Phone catS62Pro, Phone catS62Pro2, Phone nokia5310){
        // ContactList
        samsungS22.saveContact("Faus",111);
        asusRogPhone6DUltimate.saveContact("ccccc",3333);
        asusRogPhone6DUltimate.saveContact("aaaaa",1111);
        asusRogPhone6DUltimate.saveContact("dddd",4444);
        asusRogPhone6DUltimate.saveContact("bbbb",2222);
        nokia5310.saveContact("Agus",3333);

        asusRogPhone6DUltimate.showContactList();

        // VideoGamesList
        ((GamingPhone)asusRogPhone6DUltimate).installVideoGame("game2");
        ((GamingPhone)asusRogPhone6DUltimate).installVideoGame("game1");

        ((GamingPhone)asusRogPhone6DUltimate).showVideoGames();

        // PicturesNamesList
        samsungS22.takeAPicture("pic3");
        samsungS22.takeAPicture("pic1");
        nokia5310.takeAPicture("pic1");

        samsungS22.showPicturesNamesList();

        // VideosNamesList
        asusRogPhone6DUltimate.recordAVideo("video1");
        asusRogPhone6DUltimate.recordAVideo("video3");
        asusRogPhone6DUltimate.recordAVideo("video2");
        catS62Pro.recordAVideo("video3");

        asusRogPhone6DUltimate.showVideosNamesList();

        // AppList
        samsungS22.installApp("Ig");
        samsungS22.installApp("YouTube");
        samsungS22.installApp("WhatsApp");

        samsungS22.showApps();

        // CustomLinkedList
        CustomLinkedList<Phone> customLinkedListPhones = new CustomLinkedList<>();

        customLinkedListPhones.add(new SmartPhone(Brand.SAMSUNG, ChargingConnection.USBC,"S22", 4000, 30, 50, 6.1, "Octa-Core", 128, 8, "Android", true, 1111111111, 900, 130 ));
        customLinkedListPhones.add(new GamingPhone(Brand.ASUS,ChargingConnection.USBC, "ROGPhone6DUltimate", 6000, 40, 50, 6.78, "Mali-G710", 512, 16, "Android 12", true, true, 22222222, 1200, 140));
        customLinkedListPhones.add(new SmartPhone(Brand.SAMSUNG, ChargingConnection.USBC, "S23Ultra", 4500, 90, 60, 6.5, "Octa-Core", 512, 8, "Android", true, 77777777, 1200, 140 ));

        Iterator<Phone> iterator = customLinkedListPhones.iterator();
        LOGGER.info(iterator.hasNext());
        LOGGER.info(iterator.next());

        LOGGER.info(customLinkedListPhones.length());
        customLinkedListPhones.show();
    }
    public static void calculateAverageRam(ArrayList<Phone> phonesList){

        double averageRam = 0;
        int phonesToCalculate=0;
        try (Scanner scanner = new Scanner(System.in)){
            LOGGER.info("Enter the number of phones you want to calculate");
            phonesToCalculate = scanner.nextInt();
            exceptionOccurs(Phone.getObjectsPhoneCreated(),phonesList,phonesToCalculate);
        } catch(ArithmeticException e){
            LOGGER.error("ArithmeticException: "+e.getMessage());
        } catch(NullPointerException e){
            LOGGER.error("NullPointerException: "+e.getMessage());
        } catch (InvalidIntScanner e){
            LOGGER.error("InvalidIntScanner: "+e.getMessage());
        }
        double totalRam = 0;
        Phone p;
        for (int i=0;i<phonesToCalculate;i++) {
            p = phonesList.get(i);
            if(p.getStorageMemory()==null) {
                throw new NullPointerException("StorageMemory is null");
            }
            totalRam += p.getStorageMemory().getRAM();
        }
        averageRam = totalRam / phonesToCalculate;
        LOGGER.info("averageRam of the first "+phonesToCalculate+" phones: "+averageRam);
    }

    public static void exceptionOccurs(int p, ArrayList<Phone> pl, int ptc) throws InvalidIntScanner{
        if(p==0)
            throw new ArithmeticException("Division by zero (No Phone objects created)");
        if(pl.isEmpty())
            throw new NullPointerException("The phones list is empty");
        if(ptc>p || ptc<=0)
            throw new InvalidIntScanner("Invalid value of phonesToCalculate (It must be greater than 0 and less than totalPhones)");
    }
}