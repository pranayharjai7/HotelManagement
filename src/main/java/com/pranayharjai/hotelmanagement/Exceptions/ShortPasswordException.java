package com.pranayharjai.hotelmanagement.Exceptions;

import javafx.scene.control.Alert;

public class ShortPasswordException extends Throwable {

    private Alert error = new Alert(Alert.AlertType.ERROR);

    public void errorAlertForShortPassword(){
        error.setTitle("ShortPasswordException");
        error.setHeaderText("Short Password Exception caught!");
        error.setContentText("Password should be more than 6 characters long!\nPlease try again.");
        error.showAndWait();
    }
}
