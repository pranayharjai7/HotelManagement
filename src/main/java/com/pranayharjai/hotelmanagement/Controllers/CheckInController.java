package com.pranayharjai.hotelmanagement.Controllers;

import com.pranayharjai.hotelmanagement.Exceptions.AllAlerts;
import com.pranayharjai.hotelmanagement.Exceptions.EmptyFieldException;
import com.pranayharjai.hotelmanagement.Exceptions.WrongDataException;
import com.pranayharjai.hotelmanagement.Main;
import com.pranayharjai.hotelmanagement.Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.time.temporal.ChronoUnit;
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
    private DatePicker checkOutDatePicker;
    @FXML
    private CheckBox calculateDaysOfStayCheckBox;
    @FXML
    private TextField estimatedDaysOfStayTextField;
    @FXML
    public CheckBox calculateCheckOutDateCheckBox;

    @FXML
    private ChoiceBox roomChoiceBox;
    @FXML
    private TextField expectedPriceTextField;

    @FXML
    private Button checkInButton;

    private RoomDataManager roomDataManager;
    private CheckInDataManager checkInDataManager;
    private CustomerDataManager customerDataManager;

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
    private void calculateDaysOfStayCheckBoxClicked(ActionEvent actionEvent) {
        try {
            if (calculateDaysOfStayCheckBox.isSelected()) {
                if (checkInDatePicker.getValue() != null && checkOutDatePicker.getValue() != null) {
                    if (checkOutDatePicker.getValue().isAfter(checkInDatePicker.getValue())) {
                        long difference = ChronoUnit.DAYS.between(checkInDatePicker.getValue(), checkOutDatePicker.getValue());
                        estimatedDaysOfStayTextField.setText("" + difference);
                        estimatedDaysOfStayTextField.setEditable(false);
                    } else {
                        throw new WrongDataException();
                    }
                } else {
                    throw new EmptyFieldException();
                }
            } else {
                estimatedDaysOfStayTextField.setEditable(true);
            }
        } catch (EmptyFieldException e) {
            e.errorAlertForEmptyField("EmptyFieldException", "Error!", "Check-In date and Check-Out date should not be empty!");
            calculateDaysOfStayCheckBox.setSelected(false);
        } catch (WrongDataException e) {
            e.errorAlertForWrongData("Wrong Date entered!", "Wrong Check-out Date entered!", "Please enter checkout date correctly");
            calculateDaysOfStayCheckBox.setSelected(false);
        }
    }

    @FXML
    private void calculateCheckOutDateCheckBoxClicked(ActionEvent actionEvent) {
        try {
            if (calculateCheckOutDateCheckBox.isSelected()) {
                if (checkInDatePicker.getValue() != null && !estimatedDaysOfStayTextField.getText().isEmpty()) {
                    int daysOfStay = Integer.parseInt(estimatedDaysOfStayTextField.getText());
                    if (daysOfStay < 0) {
                        throw new WrongDataException();
                    }
                    checkOutDatePicker.setValue(checkInDatePicker.getValue().plusDays(daysOfStay));
                    checkOutDatePicker.setEditable(false);
                } else {
                    throw new EmptyFieldException();
                }
            } else {
                checkOutDatePicker.setEditable(true);
            }
        } catch (EmptyFieldException e) {
            e.errorAlertForEmptyField("EmptyFieldException", "Error!", "Check-In date and Estimated Days of stay should not be empty!");
            calculateCheckOutDateCheckBox.setSelected(false);
        } catch (WrongDataException e) {
            e.errorAlertForWrongData("WrongDataException", "Wrong Day Entered", "Please use positive integers only!");
            calculateCheckOutDateCheckBox.setSelected(false);
        } catch (NumberFormatException e) {
            AllAlerts.errorAlert("NumberFormatException", "Wrong Day Entered!", "Please use numbers only!");
            calculateCheckOutDateCheckBox.setSelected(false);
        }
    }

    @FXML
    private void expectedPriceTextFieldClicked(MouseEvent mouseEvent) {
        double price = 0;
        try {
            if (roomChoiceBox.getValue() == null) {
                throw new EmptyFieldException();
            }

            List<RoomData> roomDataList = roomDataManager.readAllRoomData()
                    .stream()
                    .filter(roomData -> roomData.getRoomNo().equals(roomChoiceBox.getValue().toString()))
                    .toList();

            price = Double.parseDouble(roomDataList.get(0).getPrice());

            if (petsCheckBox.isSelected()) {
                price += 2000;
            }
        } catch (EmptyFieldException e) {
            e.errorAlertForEmptyField();
        }

        expectedPriceTextField.setText("" + price);
    }

    @FXML
    private void checkInButtonClicked(ActionEvent actionEvent) throws IOException {

        try {
            if (fullNameTextField.getText().isEmpty() || typeOfIdLabel.getText().equals("__") || idNoTextField.getText().isEmpty()
                    || noOfAdditionalMembersLabel.getText().equals("__") || checkInDatePicker.getValue() == null
                    || estimatedDaysOfStayTextField.getText().isEmpty() || checkOutDatePicker.getValue() == null
                    || roomChoiceBox.getValue() == null) {
                throw new EmptyFieldException();
            }

            manageCheckInData();
            manageCustomerData();
            updateRoomStatus();

            AllAlerts.confirmAlert("Check-In", "Check-In successful!", "You are now checked in!");
            Main.setScene("HotelManagementMenu.fxml");
        } catch (EmptyFieldException e) {
            e.errorAlertForEmptyField();
        }
    }

    private void manageCheckInData() {
        CheckInData checkInData = new CheckInData();
        checkInData.setName(fullNameTextField.getText());
        checkInData.setTypeOfId(typeOfIdLabel.getText());
        checkInData.setIdNumber(idNoTextField.getText());
        checkInData.setNoOfAdditionalMembers(noOfAdditionalMembersLabel.getText());
        checkInData.setPets("" + petsCheckBox.isSelected());
        if (petsCheckBox.isSelected()) {
            checkInData.setPetTag(petTagTextField.getText());
        } else {
            checkInData.setPetTag("NONE");
        }
        checkInData.setCheckInDate(checkInDatePicker.getValue().toString());
        checkInData.setExpectedCheckOut(checkOutDatePicker.getValue().toString());
        checkInData.setEstimatedTimeOfStay(estimatedDaysOfStayTextField.getText());
        checkInData.setRoomNumber(roomChoiceBox.getValue().toString());
        checkInDataManager = new CheckInDataManager();
        checkInDataManager.setCheckInData(checkInData);
    }

    private void manageCustomerData() {
        CustomerData customerData = new CustomerData();
        customerData.setName(fullNameTextField.getText());
        customerData.setTypeOfId(typeOfIdLabel.getText());
        customerData.setIdNumber(idNoTextField.getText());
        customerData.setNoOfAdditionalMembers(noOfAdditionalMembersLabel.getText());
        customerData.setPets("" + petsCheckBox.isSelected());
        if (petsCheckBox.isSelected()) {
            customerData.setPetTag(petTagTextField.getText());
        } else {
            customerData.setPetTag("NONE");
        }
        customerData.setCheckInDate(checkInDatePicker.getValue().toString());
        customerData.setCheckOutDate("NONE");
        customerData.setRoomNumber(roomChoiceBox.getValue().toString());
        customerData.setStatus("CHECKED-IN");
        customerData.setBillId("NONE");
        customerDataManager = new CustomerDataManager();
        customerDataManager.setCustomerData(customerData);
    }

    private void updateRoomStatus() {
        roomDataManager = new RoomDataManager();
        RoomData roomData = roomDataManager.readAllRoomData()
                .stream()
                .filter(roomData1 -> roomData1.getRoomNo().equals(roomChoiceBox.getValue().toString()))
                .toList()
                .get(0);

        roomData.setAvailability("BOOKED");
        roomDataManager.updateRoomData(roomData);
    }

    @FXML
    private void backButtonClicked(ActionEvent actionEvent) throws IOException {
        Main.setScene("HotelManagementMenu.fxml");
    }
}
