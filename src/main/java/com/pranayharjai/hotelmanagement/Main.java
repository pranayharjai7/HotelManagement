package com.pranayharjai.hotelmanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.h2.tools.Server;

import java.io.IOException;
import java.sql.SQLException;
public class Main extends Application {

    private static final Server server = new Server();
    private static Scene scene;
    public static void main(String[] args) throws SQLException {

        startDatabase();
        System.out.println("HOTEL MANAGEMENT");
        launch(args);
        stopDatabase();
    }

    @Override
    public void start(Stage stage) throws Exception {
        scene = new Scene(loadFxml("Primary.fxml"));
        stage.setTitle("Hotel Management");
        stage.setScene(scene);
        stage.show();
    }

    public static void setScene(String fxml) throws IOException {
        scene.setRoot(loadFxml(fxml));


    }

    private static Parent loadFxml(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/fxml/"+fxml));
        return loader.load();
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
