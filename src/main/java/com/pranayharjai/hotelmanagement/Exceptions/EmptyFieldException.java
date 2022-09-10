package com.pranayharjai.hotelmanagement.Exceptions;


public class EmptyFieldException extends Throwable {

    public void errorAlertForEmptyField() {
        AllAlerts.errorAlert("EmptyFieldException", "Empty Field Exception caught!", "Fields cannot be left empty!\nPlease try Again.");
    }

    public void errorAlertForEmptyField(String title, String header, String content) {
        AllAlerts.errorAlert(title, header, content);
    }
}
