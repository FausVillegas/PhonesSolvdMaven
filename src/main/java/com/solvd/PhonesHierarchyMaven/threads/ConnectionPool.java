package main.java.com.solvd.PhonesHierarchyMaven.threads;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import java.sql.Connection;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
    private static final Logger LOGGER = LogManager.getLogger(ConnectionPool.class);
    private static List<Connection> connectionPool;
    private static List<Connection> usedConnections = new ArrayList<>();
    private static int INITIAL_POOL_SIZE = 5;

    public static ConnectionPool create(){
        connectionPool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            connectionPool.add(new Connection());
        }
        return new ConnectionPool();
    }

    // standard constructors

    synchronized public Connection getConnection() {
        LOGGER.info("Getting connection");
        if(connectionPool.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Connection connection = connectionPool.remove(connectionPool.size() - 1);
        usedConnections.add(connection);
        LOGGER.info("Got connection");
        return connection;
    }

    synchronized public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        if(!connectionPool.isEmpty())
            notify();
        return usedConnections.remove(connection);
    }

    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }
}
