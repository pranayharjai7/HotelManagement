package com.pranayharjai.hotelmanagement.Exceptions;

public class UserDataAuthenticationFailedException extends Throwable {

    public void errorAlertForUserDataAuthenticationFailed() {
        AllAlerts.errorAlert("UserDataAuthenticationFailedException", "UserData Authentication Failed Exception caught!", "Login username or password doesn't match!\nPlease try again!");
    }

    public void errorAlertForUserDataAuthenticationFailed(String title, String header, String content) {
        AllAlerts.errorAlert(title, header, content);
    }
}
