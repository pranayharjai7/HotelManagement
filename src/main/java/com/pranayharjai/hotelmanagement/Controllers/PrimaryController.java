package com.pranayharjai.hotelmanagement.Controllers;

import com.pranayharjai.hotelmanagement.Main;
import javafx.event.ActionEvent;

import java.io.IOException;

public class PrimaryController {
    public void startButtonClicked(ActionEvent actionEvent) throws IOException {
        Main.setScene("Login.fxml");
    }
}
