package com.pranayharjai.hotelmanagement.Exceptions;

public class WrongDataException extends Throwable {

    public void errorAlertForWrongData() {
        AllAlerts.errorAlert("WrongDataException", "Wrong Data Exception caught!", "The data you entered is wrong!\n Please try again!");
    }

    public void errorAlertForWrongData(String title, String header, String content) {
        AllAlerts.errorAlert(title, header, content);
    }
}
