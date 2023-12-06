package main.java.com.solvd.PhonesHierarchyMaven.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Connection {
    private static final Logger LOGGER = LogManager.getLogger(Connection.class.getName());
    public Connection() {
        LOGGER.info("New connection");
    }
}
