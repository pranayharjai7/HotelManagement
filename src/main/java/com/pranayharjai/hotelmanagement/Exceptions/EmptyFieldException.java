package com.pranayharjai.hotelmanagement.Exceptions;

import javafx.scene.control.Alert;

public class EmptyFieldException extends Throwable {

    private Alert error = new Alert(Alert.AlertType.ERROR);
    public void errorAlertForEmptyField(){
        error.setTitle("EmptyFieldException");
        error.setHeaderText("Empty Field Exception caught!");
        error.setContentText("Fields cannot be left empty!\nPlease try Again.");
        error.showAndWait();
    }
}
