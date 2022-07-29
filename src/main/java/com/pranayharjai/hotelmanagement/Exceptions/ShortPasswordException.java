package com.pranayharjai.hotelmanagement.Exceptions;


public class ShortPasswordException extends Throwable {
    public void errorAlertForShortPassword() {
        AllAlerts.errorAlert("ShortPasswordException", "Short Password Exception caught!", "Password should be more than 6 characters long!\nPlease try again.");
    }

    public void errorAlertForShortPassword(String title, String header, String content) {
        AllAlerts.errorAlert(title, header, content);
    }
}
