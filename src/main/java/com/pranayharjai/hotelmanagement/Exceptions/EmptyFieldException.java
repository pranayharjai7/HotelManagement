package com.pranayharjai.hotelmanagement.Exceptions;

import javafx.scene.control.Alert;

public class EmptyFieldException extends Throwable {

    public void errorAlertForEmptyField() {
        AllAlerts.errorAlert("EmptyFieldException", "Empty Field Exception caught!", "Fields cannot be left empty!\nPlease try Again.");
    }
}
