package com.pranayharjai.hotelmanagement.Exceptions;

public class UserDataAuthenticationFailedException extends Throwable {

    public void errorAlertForUserDataAuthenticationFailed() {
        AllAlerts.errorAlert("UserDataAuthenticationFailedException", "UserData Authentication Failed Exception caught!", "Login username or password doesn't match!\nPlease try again!");
    }
}
