package com.pranayharjai.hotelmanagement.Exceptions;

import javafx.scene.control.Alert;

public class ShortPasswordException extends Throwable {
    public void errorAlertForShortPassword() {
        AllAlerts.errorAlert("ShortPasswordException", "Short Password Exception caught!", "Password should be more than 6 characters long!\nPlease try again.");
    }
}
