package com.pranayharjai.hotelmanagement.Controllers;

import com.pranayharjai.hotelmanagement.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HotelManagementMenuController {
    @FXML
    private AnchorPane roomSearchAnchorPane;
    @FXML
    private ImageView roomSearchImageView;
    @FXML
    private Label roomSearchLabel;
    @FXML
    private AnchorPane checkInAnchorPane;
    @FXML
    private ImageView checkInImageView;
    @FXML
    private Label checkInLabel;
    @FXML
    private AnchorPane checkOutAnchorPane;
    @FXML
    private ImageView checkOutImageView;
    @FXML
    private Label checkOutLabel;
    @FXML
    private AnchorPane petManagementAnchorPane;
    @FXML
    private ImageView petManagementImageView;
    @FXML
    private Label petManagementLabel;
    @FXML
    private AnchorPane billsAnchorPane;
    @FXML
    private ImageView billsImageView;
    @FXML
    private Label billsLabel;

    public void roomSearchClicked(MouseEvent mouseEvent) {
    }

    public void checkInClicked(MouseEvent mouseEvent) {
    }

    public void checkOutClicked(MouseEvent mouseEvent) {
    }

    public void petManagementClicked(MouseEvent mouseEvent) {
    }

    public void billsCLicked(MouseEvent mouseEvent) {
    }

    public void roomSearchAnchorPaneMouseEntered(MouseEvent mouseEvent) {
        labelShiftUp(roomSearchAnchorPane, roomSearchImageView, roomSearchLabel);
    }

    public void roomSearchAnchorPaneMouseExited(MouseEvent mouseEvent) {
        labelShiftDown(roomSearchAnchorPane, roomSearchImageView, roomSearchLabel);
    }

    public void checkInAnchorPaneMouseEntered(MouseEvent mouseEvent) {
        labelShiftUp(checkInAnchorPane, checkInImageView, checkInLabel);
    }

    public void checkInAnchorPaneMouseExited(MouseEvent mouseEvent) {
        labelShiftDown(checkInAnchorPane, checkInImageView, checkInLabel);
    }

    public void checkOutAnchorPaneMouseEntered(MouseEvent mouseEvent) {
        labelShiftUp(checkOutAnchorPane, checkOutImageView, checkOutLabel);
    }

    public void checkOutAnchorPaneMouseExited(MouseEvent mouseEvent) {
        labelShiftDown(checkOutAnchorPane, checkOutImageView, checkOutLabel);
    }

    public void petManagementAnchorPaneMouseEntered(MouseEvent mouseEvent) {
        labelShiftUp(petManagementAnchorPane, petManagementImageView, petManagementLabel);
    }

    public void petManagementAnchorPaneMouseExited(MouseEvent mouseEvent) {
        labelShiftDown(petManagementAnchorPane, petManagementImageView, petManagementLabel);
    }

    public void billsAnchorPaneMouseEntered(MouseEvent mouseEvent) {
        labelShiftUp(billsAnchorPane, billsImageView, billsLabel);
    }

    public void billsAnchorPaneMouseExited(MouseEvent mouseEvent) {
        labelShiftDown(billsAnchorPane, billsImageView, billsLabel);
    }

    private void labelShiftUp(AnchorPane anchorPane, ImageView imageView, Label label) {
        anchorPane.setPrefWidth(anchorPane.getPrefWidth() + 50);
        anchorPane.setLayoutX(anchorPane.getLayoutX() - 25);
        imageView.setFitWidth(imageView.getFitWidth() + 50);
        imageView.setPreserveRatio(false);
        label.setPrefWidth(label.getPrefWidth() + 50);
        label.setPrefHeight(label.getPrefHeight() + 25);
        label.setLayoutY(label.getLayoutY() - 25);
    }

    private void labelShiftDown(AnchorPane anchorPane, ImageView imageView, Label label) {
        anchorPane.setPrefWidth(anchorPane.getPrefWidth() - 50);
        anchorPane.setLayoutX(anchorPane.getLayoutX() + 25);
        imageView.setFitWidth(imageView.getFitWidth() - 50);
        imageView.setPreserveRatio(false);
        label.setPrefWidth(label.getPrefWidth() - 50);
        label.setPrefHeight(label.getPrefHeight() - 25);
        label.setLayoutY(label.getLayoutY() + 25);
    }

    public void logoutButtonClicked(ActionEvent actionEvent) throws IOException {
        Main.setScene("Login.fxml");
    }
}
