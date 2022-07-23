package com.pranayharjai.hotelmanagement.Exceptions;

import javafx.scene.control.Alert;

public class UserDataAlreadyExistsException extends Throwable {

    private Alert error = new Alert(Alert.AlertType.ERROR);

    public void errorAlertForUserDataAlreadyExists(){
        error.setTitle("UserDataAlreadyExistsException");
        error.setHeaderText("UserData Already Exists Exception caught!");
        error.setContentText("The entered user already exists! \nPlease Enter a new user or try logging in.");
        error.showAndWait();
    }
}
