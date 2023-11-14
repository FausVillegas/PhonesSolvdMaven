package com.solvd.PhonesHierarchyMaven;

import com.solvd.PhonesHierarchyMaven.phone.*;
import com.solvd.PhonesHierarchyMaven.phone.customList.CustomLinkedList;
import com.solvd.PhonesHierarchyMaven.phone.exceptions.InvalidIntScanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        //with all the information
        Phone samsungS22 = new SmartPhone("Samsung", "S22", 4000, 30, 50, "USB-C", 6.1, "Octa-Core", 128, 8, "Android", true, 1111111111, 900, 130);
        GamingPhone asusRogPhone6DUltimate = new GamingPhone("ASUS", "ROGPhone6DUltimate", 6000, 40, 50, "USB-C", 6.78, "Mali-G710", 512, 16, "Android 12", true, true, 22222222, 1200, 140);
        Phone catS62Pro = new RuggedPhone("CAT", "S62 PRO", 4000, 0, 12, "USB-C", 5.7, "Snapdragon 660", 128, 6, "Android", false, "Military", 3333333, 700, 180);
        Phone catS62Pro2 = new RuggedPhone("CAT", "S62 PRO", 4000, 0, 12, "USB-C", 5.7, "Snapdragon 660", 128, 6, "Android", false, "Military", 3333333, 700, 180);
        Phone nokia5310 = new FeaturePhone("Nokia", "5310", 1200, 100, 5, "USB 1.1", 2.4, "MT6260A", 16, 0.016, true, false, 444444, 300, 100);

//        ArrayList<Phone> phonesList = new ArrayList<>();
//        phonesList.add(samsungS22);
//        phonesList.add(asusRogPhone6DUltimate);
//        phonesList.add(catS62Pro);
//        phonesList.add(catS62Pro2);
//        phonesList.add(nokia5310);
//
//        double averageRam = 0;
//        int phonesToCalculate=0;
//        try (Scanner scanner = new Scanner(System.in)){
//            LOGGER.info("Enter the number of phones you want to calculate");
//            phonesToCalculate = scanner.nextInt();
//            exceptionOccurs(Phone.getObjectsPhoneCreated(),phonesList,phonesToCalculate);
//        } catch(ArithmeticException e){
//            LOGGER.error("ArithmeticException: "+e.getMessage());
//        } catch(NullPointerException e){
//            LOGGER.error("NullPointerException: "+e.getMessage());
//        } catch (InvalidIntScanner e){
//            LOGGER.error("InvalidIntScanner: "+e.getMessage());
//        }
//        double totalRam = 0;
//        Phone p;
//        for (int i=0;i<phonesToCalculate;i++) {
//            p = phonesList.get(i);
//            if(p.getStorageMemory()==null) {
//                throw new NullPointerException("StorageMemory is null");
//            }
//            totalRam += p.getStorageMemory().getRAM();
//        }
//        averageRam = totalRam / phonesToCalculate;
//        LOGGER.info("averageRam of the first "+phonesToCalculate+" phones: "+averageRam);

        // ContactList
        samsungS22.saveContact("Faus",111);
        asusRogPhone6DUltimate.saveContact("ccccc",3333);
        asusRogPhone6DUltimate.saveContact("aaaaa",1111);
        asusRogPhone6DUltimate.saveContact("dddd",4444);
        asusRogPhone6DUltimate.saveContact("bbbb",2222);
        nokia5310.saveContact("Agus",3333);

        asusRogPhone6DUltimate.showContactList();

        // VideoGamesList
        asusRogPhone6DUltimate.installVideoGame("game2");
        asusRogPhone6DUltimate.installVideoGame("game1");

        asusRogPhone6DUltimate.showVideoGames();

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

        customLinkedListPhones.add(new SmartPhone("Samsung", "S22", 4000, 30, 50, "USB-C", 6.1, "Octa-Core", 128, 8, "Android", true, 1111111111, 900, 130 ));
        customLinkedListPhones.add(new GamingPhone("ASUS", "ROGPhone6DUltimate", 6000, 40, 50, "USB-C", 6.78, "Mali-G710", 512, 16, "Android 12", true, true, 22222222, 1200, 140));
        customLinkedListPhones.add(new SmartPhone("Samsung", "S23Ultra", 4500, 90, 60, "USB-C", 6.5, "Octa-Core", 512, 8, "Android", true, 77777777, 1200, 140 ));

        Iterator<Phone> iterator = customLinkedListPhones.iterator();
        LOGGER.info(iterator.hasNext());
        LOGGER.info(iterator.next());

        LOGGER.info(customLinkedListPhones.length());
        customLinkedListPhones.show();
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