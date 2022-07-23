package com.pranayharjai.hotelmanagement.Exceptions;

import javafx.scene.control.Alert;

public class WrongKeyException extends Throwable {

    private Alert error = new Alert(Alert.AlertType.ERROR);

    public void errorAlertForWrongKey() {
        AllAlerts.errorAlert("WrongKeyException", "Wrong Key Exception caught!", "The key you entered is incorrect!\nPlease try again.");
    }
}
