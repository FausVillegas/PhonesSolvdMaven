package main.java.com.solvd.PhonesHierarchyMaven.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RunnableThread implements Runnable{
    private static final Logger LOGGER = LogManager.getLogger(Runnable.class);

    @Override
    public void run() {
        for(int i=0;i<5;i++){
            LOGGER.info(Thread.currentThread().getName()+" "+i);
        }
    }
}
