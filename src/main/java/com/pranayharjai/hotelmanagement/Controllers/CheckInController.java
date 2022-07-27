package com.pranayharjai.hotelmanagement.Controllers;

import com.pranayharjai.hotelmanagement.Exceptions.EmptyFieldException;
import com.pranayharjai.hotelmanagement.Main;
import com.pranayharjai.hotelmanagement.Models.RoomData;
import com.pranayharjai.hotelmanagement.Models.RoomDataManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheckInController {
    @FXML
    private TextField fullNameTextField;

    @FXML
    private MenuButton typeOfIdMenuButton;
    @FXML
    private MenuItem passportMenuItem;
    @FXML
    private MenuItem residencePermitMenuItem;
    @FXML
    private MenuItem nicMenuItem;
    @FXML
    private Label typeOfIdLabel;

    @FXML
    private TextField idNoTextField;

    @FXML
    private MenuButton noOfAdditionalMembersMenuButton;
    @FXML
    private MenuItem zeroMenuItem;
    @FXML
    private MenuItem oneMenuItem;
    @FXML
    private MenuItem twoMenuItem;
    @FXML
    private Label noOfAdditionalMembersLabel;

    @FXML
    private CheckBox petsCheckBox;
    @FXML
    private TextField petTagTextField;

    @FXML
    private DatePicker checkInDatePicker;
    @FXML
    private TextField estimatedDaysOfStayTextField;

    @FXML
    private ChoiceBox roomChoiceBox;
    @FXML
    private TextField expectedPriceTextField;

    @FXML
    private Button checkInButton;

    private RoomDataManager roomDataManager;

    @FXML
    private void initialize() {

        roomDataManager = new RoomDataManager();
        List<RoomData> roomDataList = roomDataManager.readAllRoomData()
                .stream()
                .filter(roomData -> roomData.getAvailability().equals("AVAILABLE"))
                .collect(Collectors.toList());
        List<String> roomNoList = new ArrayList<>();
        for (RoomData roomData : roomDataList) {
            roomNoList.add(roomData.getRoomNo());
        }
        ObservableList<String> roomsList = FXCollections.observableArrayList();
        roomsList.addAll(roomNoList);
        roomChoiceBox.setItems(roomsList);

        if (!RoomSearchController.SELECTED_ROOM.equals("")) {
            roomChoiceBox.setValue(RoomSearchController.SELECTED_ROOM);
        }

        RoomSearchController.SELECTED_ROOM = "";
    }

    @FXML
    private void typeOfIdClicked(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(nicMenuItem)) {
            typeOfIdLabel.setText("NIC");
        } else if (actionEvent.getSource().equals(passportMenuItem)) {
            typeOfIdLabel.setText("Passport");
        } else if (actionEvent.getSource().equals(residencePermitMenuItem)) {
            typeOfIdLabel.setText("Residence Permit");
        }
    }

    @FXML
    private void noOfAdditionalMembersClicked(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(zeroMenuItem)) {
            noOfAdditionalMembersLabel.setText("0");
        } else if (actionEvent.getSource().equals(oneMenuItem)) {
            noOfAdditionalMembersLabel.setText("1");
        } else if (actionEvent.getSource().equals(twoMenuItem)) {
            noOfAdditionalMembersLabel.setText("2");
        }
    }

    @FXML
    private void petsCheckBoxClicked(ActionEvent actionEvent) {
        if (petsCheckBox.isSelected()) {
            petTagTextField.setDisable(false);
        } else {
            petTagTextField.setDisable(true);
        }
    }

    @FXML
    private void checkInButtonClicked(ActionEvent actionEvent) throws EmptyFieldException {
        if (fullNameTextField.getText().isEmpty() || typeOfIdLabel.equals("__") || idNoTextField.getText().isEmpty()
                || noOfAdditionalMembersLabel.getText().equals("__") || checkInDatePicker.getValue().toString().isEmpty()
                || estimatedDaysOfStayTextField.getText().isEmpty() || expectedPriceTextField.getText().isEmpty()
                || roomChoiceBox.getValue().toString().isEmpty()) {
            throw new EmptyFieldException();
        }


        String customerName = fullNameTextField.getText();
        String typeOfId = typeOfIdLabel.getText();
        String idNo = idNoTextField.getText();
        String additionalMembers = noOfAdditionalMembersLabel.getText();
        String petTag = petTagTextField.getText().isEmpty()?"":petTagTextField.getText();
        String checkInDate = checkInDatePicker.getValue().toString();
        String ETAdays = estimatedDaysOfStayTextField.getText();
        String roomNo = roomChoiceBox.getValue().toString();
        String price = expectedPriceTextField.getText();

        System.out.println(customerName
                + " " + typeOfId
                + " " + idNo
                + " " + additionalMembers
                + " " + petTag
                + " " + checkInDate
                + " " + ETAdays
                + " " + roomNo
                + " " + price);
    }

    @FXML
    private void backButtonClicked(ActionEvent actionEvent) throws IOException {
        Main.setScene("HotelManagementMenu.fxml");
    }
}
