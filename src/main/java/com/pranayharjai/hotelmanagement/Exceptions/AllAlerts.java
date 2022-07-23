package com.pranayharjai.hotelmanagement.Exceptions;

import javafx.scene.control.Alert;

public class AllAlerts {

    private static Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
    private static Alert error = new Alert(Alert.AlertType.ERROR);

    public static void confirmAlert(String title, String header, String content) {
        confirm.setTitle(title);
        confirm.setHeaderText(header);
        confirm.setContentText(content);
        confirm.showAndWait();
    }

    public static void errorAlert(String title, String header, String content) {
        error.setTitle(title);
        error.setHeaderText(header);
        error.setContentText(content);
        error.showAndWait();
    }
}
