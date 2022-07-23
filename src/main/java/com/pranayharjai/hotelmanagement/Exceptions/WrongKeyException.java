package com.pranayharjai.hotelmanagement.Exceptions;

import javafx.scene.control.Alert;

public class WrongKeyException extends Throwable {

    private Alert error = new Alert(Alert.AlertType.ERROR);

    public void errorAlertForWrongKey() {
        error.setTitle("WrongKeyException");
        error.setHeaderText("Wrong Key Exception caught!");
        error.setContentText("The key you entered is incorrect!\nPlease try again.");
        error.showAndWait();
    }
}
