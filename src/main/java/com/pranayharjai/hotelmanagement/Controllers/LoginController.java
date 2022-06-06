package com.pranayharjai.hotelmanagement.Controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;

public class LoginController {
    public Button loginMenuButton;
    public Button registerMenuButton;
    public Line menuLine;
    public AnchorPane loginMenuAnchorPane;
    public AnchorPane registerMenuAnchorPane;

    public TextField usernameLoginTextField;
    public PasswordField passwordLoginPasswordField;

    public TextField usernameRegisterTextField;
    public TextField emailRegisterTextField;
    public PasswordField passwordRegisterPasswordField;
    public TextField keyRegisterTextField1;


    public void loginMenuButtonClicked(ActionEvent actionEvent) {
        loginMenuButton.setDisable(true);
        registerMenuButton.setDisable(false);
        menuLine.setLayoutX(120);
        loginMenuAnchorPane.setDisable(false);
        loginMenuAnchorPane.setOpacity(1);
        registerMenuAnchorPane.setDisable(true);
        registerMenuAnchorPane.setOpacity(0);
    }

    public void registerMenuButtonClicked(ActionEvent actionEvent) {
        loginMenuButton.setDisable(false);
        registerMenuButton.setDisable(true);
        menuLine.setLayoutX(350);
        loginMenuAnchorPane.setDisable(true);
        loginMenuAnchorPane.setOpacity(0);
        registerMenuAnchorPane.setDisable(false);
        registerMenuAnchorPane.setOpacity(1);
    }

    public void loginButtonClicked(ActionEvent actionEvent) {
    }

    public void forgotPasswordClicked(MouseEvent mouseEvent) {
    }

    public void registerButtonClicked(ActionEvent actionEvent) {
    }
}
