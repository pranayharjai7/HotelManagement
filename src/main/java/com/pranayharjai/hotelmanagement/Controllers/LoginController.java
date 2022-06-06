package com.pranayharjai.hotelmanagement.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

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
    public TextField keyRegisterTextField;
    public CheckBox showPasswordCheckBox;
    public Button loginButton;
    private TextField passwordLoginTextField = new TextField();


    @FXML
    private void initialize(){
        passwordLoginTextField.setLayoutX(55);
        passwordLoginTextField.setLayoutY(164);
        passwordLoginTextField.setPrefWidth(passwordRegisterPasswordField.getPrefWidth());
        passwordLoginTextField.setFont(passwordLoginPasswordField.getFont());
        //passwordLoginTextField.setStyle("-fx-text-fill: green;");
        passwordLoginTextField.setStyle(passwordLoginPasswordField.getStyle()+" -fx-text-fill: #00ddff;");
    }

    public void loginButtonClicked(ActionEvent actionEvent) {
    }

    public void registerButtonClicked(ActionEvent actionEvent) {
    }

    public void forgotPasswordClicked(MouseEvent mouseEvent) {
        HBox hBox = new HBox();
        Label label = new Label("Enter Email ID:    ");
        label.setFont(new Font(18));
        TextField textField = new TextField();
        textField.setPromptText("Enter your Email here");
        textField.setPrefWidth(200);
        hBox.getChildren().addAll(label, textField);

        Alert forgotPassword = new Alert(Alert.AlertType.INFORMATION);
        forgotPassword.setTitle("Forgot Password");
        forgotPassword.setHeaderText("");
        forgotPassword.setGraphic(hBox);
        forgotPassword.showAndWait().ifPresent(buttonType -> {
            System.out.println(textField.getText());
        });
    }

    public void loginMenuButtonClicked(ActionEvent actionEvent) {
        menuChange(actionEvent, registerMenuAnchorPane,loginMenuAnchorPane,registerMenuButton,loginMenuButton);
    }

    public void registerMenuButtonClicked(ActionEvent actionEvent) {
        menuChange(actionEvent, loginMenuAnchorPane,registerMenuAnchorPane,loginMenuButton,registerMenuButton);
    }

    private void menuChange(ActionEvent actionEvent, AnchorPane p1, AnchorPane p2, Button b1, Button b2){
        b1.setDisable(false);
        b2.setDisable(true);
        p1.setDisable(true);
        p1.setVisible(false);
        p2.setDisable(false);
        p2.setVisible(true);
        menuLine.setLayoutX(menuLine.getLayoutX()==350?100:350);

        resetFields(actionEvent);
        PrimaryController.fadeTransition(p2);
    }

    private void resetFields(ActionEvent actionEvent) {
        usernameLoginTextField.setText("");
        passwordLoginPasswordField.setText("");
        passwordLoginTextField.setText("");
        showPasswordCheckBox.setSelected(false);
        showPasswordCheckBoxClicked(actionEvent);

        usernameRegisterTextField.setText("");
        passwordRegisterPasswordField.setText("");
        emailRegisterTextField.setText("");
        keyRegisterTextField.setText("");
    }

    public void showPasswordCheckBoxClicked(ActionEvent actionEvent) {
        if(showPasswordCheckBox.isSelected()){
            loginMenuAnchorPane.getChildren().add(passwordLoginTextField);
            passwordLoginTextField.setText(passwordLoginPasswordField.getText());
            passwordLoginPasswordField.setDisable(true);
            passwordLoginPasswordField.setVisible(false);
        }
        else{
            loginMenuAnchorPane.getChildren().remove(passwordLoginTextField);
            passwordLoginPasswordField.setDisable(false);
            passwordLoginPasswordField.setVisible(true);
        }
    }
}
