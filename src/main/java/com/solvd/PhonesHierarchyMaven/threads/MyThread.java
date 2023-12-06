package main.java.com.solvd.PhonesHierarchyMaven.threads;

import main.java.com.solvd.PhonesHierarchyMaven.phone.SmartPhone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyThread extends Thread{
    private static final Logger LOGGER = LogManager.getLogger(MyThread.class);
    @Override
    public void run(){
        for(int i=0;i<7;i++){
            LOGGER.info(Thread.currentThread().getName()+" "+i);
        }
    }
}
