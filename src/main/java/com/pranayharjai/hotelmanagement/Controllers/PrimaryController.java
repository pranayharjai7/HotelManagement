package com.pranayharjai.hotelmanagement.Controllers;

import com.pranayharjai.hotelmanagement.Main;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.io.IOException;

public class PrimaryController {
    public void startButtonClicked(ActionEvent actionEvent) throws IOException {
        Main.setScene("Login.fxml");
    }

    public static void fadeTransition(Pane pane) {
        FadeTransition transition = new FadeTransition(Duration.seconds(1.0), pane);
        transition.setFromValue(0.0);
        transition.setToValue(1.0);
        transition.play();
    }
}
