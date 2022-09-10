package com.pranayharjai.hotelmanagement.Exceptions;


public class WrongKeyException extends Throwable {

    public void errorAlertForWrongKey() {
        AllAlerts.errorAlert("WrongKeyException", "Wrong Key Exception caught!", "The key you entered is incorrect!\nPlease try again.");
    }

    public void errorAlertForWrongKey(String title, String header, String content) {
        AllAlerts.errorAlert(title, header, content);
    }
}
