package com.pranayharjai.hotelmanagement;

import org.h2.tools.Server;
import java.sql.SQLException;
public class Main {

    private static final Server server = new Server();
    public static void main(String[] args) throws SQLException {

        startDatabase();

        System.out.println("HOTEL MANAGEMENT");

        stopDatabase();
    }

    /**
     * Starting the H2 database using runtool.
     * @throws SQLException: Database Exception
     */
    public static void startDatabase() throws SQLException {
        server.runTool("-tcp", "-web", "-ifNotExists");
    }

    /**
     * Shutting down the H2 Database.
     */
    private static void stopDatabase() {
        server.shutdown();
    }
}
