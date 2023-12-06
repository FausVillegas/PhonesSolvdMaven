package main.java.com.solvd.PhonesHierarchyMaven.threads;

//import java.sql.Connection;

import static java.lang.Thread.sleep;

public class ConnectionThread implements Runnable{

    ConnectionPool connectionPool;
    public ConnectionThread(ConnectionPool connectionPool){
        this.connectionPool = connectionPool;
    }
    @Override
    public void run() {
        Connection connection = connectionPool.getConnection();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        connectionPool.releaseConnection(connection);
    }
}
