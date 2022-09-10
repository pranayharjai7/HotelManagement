package com.pranayharjai.hotelmanagement.Controllers;

import com.pranayharjai.hotelmanagement.Main;
import com.pranayharjai.hotelmanagement.Models.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

public class CheckOutController {
    @FXML
    private TableView checkOutTableView;
    @FXML
    private TableColumn name;
    @FXML
    private TableColumn idNo;
    @FXML
    private TableColumn additionalMembers;
    @FXML
    private TableColumn petTag;
    @FXML
    private TableColumn checkInDate;
    @FXML
    private TableColumn roomNo;

    @FXML
    private TextField nameFilterTextField;
    @FXML
    private TextField idNoFilterTextField;
    @FXML
    private TextField roomFilterTextField;
    @FXML
    private Button checkOutButton;
    @FXML
    private Button backButton;
    @FXML
    private Button searchButton;

    private CheckInDataManager checkInDataManager;
    private BillDataManager billDataManager;
    private CustomerDataManager customerDataManager;
    private RoomDataManager roomDataManager;
    @FXML
    public void initialize() {
        linkedCheckInDataToCheckOutTableViewColumns();

        checkInDataManager = new CheckInDataManager();
        List<CheckInData> checkInDataList = checkInDataManager.readAllCheckInData();

        checkOutTableView.getItems().addAll(checkInDataList);
    }

    private void linkedCheckInDataToCheckOutTableViewColumns() {
        name.setCellValueFactory(new PropertyValueFactory<CheckInData, String>("name"));
        idNo.setCellValueFactory(new PropertyValueFactory<CheckInData, String>("idNumber"));
        additionalMembers.setCellValueFactory(new PropertyValueFactory<CheckInData, String>("noOfAdditionalMembers"));
        petTag.setCellValueFactory(new PropertyValueFactory<CheckInData, String>("petTag"));
        checkInDate.setCellValueFactory(new PropertyValueFactory<CheckInData, String>("checkInDate"));
        roomNo.setCellValueFactory(new PropertyValueFactory<CheckInData, String>("roomNumber"));
    }

    @FXML
    private void backButtonClicked(ActionEvent actionEvent) throws IOException {
        Main.setScene("HotelManagementMenu.fxml");
    }

    @FXML
    private void searchButtonClicked(ActionEvent actionEvent) {
    }

    @FXML
    private void checkOutButtonClicked(ActionEvent actionEvent) {
        for (int i = 0; i < checkInDataManager.readAllCheckInData().size(); i++) {
            if (checkOutTableView.getSelectionModel().isSelected(i)) {
                CheckInData checkInData = (CheckInData) checkOutTableView.getSelectionModel().getSelectedItem();
                checkOut(checkInData);
                break;
            }
        }
    }

    private void checkOut(CheckInData checkInData) {

        billDataManager = new BillDataManager();
        customerDataManager = new CustomerDataManager();


        CustomerData customerData = customerDataManager.readAllCustomerData()
                .stream().filter(customerData1 -> customerData1.getIdNumber().equals(checkInData.getIdNumber()))
                .toList()
                .get(0);


        BillData billData = new BillData();
        billData.setBillId(UUID.randomUUID().toString());
        billData.setCustomerDataId(customerData.getId());
        int amount = calculateAmount(customerData);
        billData.setAmount(amount);
        billData.setBillStatus("UNPAID");

        customerData.setCheckOutDate(LocalDate.now().toString());
        customerData.setStatus("CHECKED-OUT");
        customerData.setBillId(billData.getBillId());

        billDataManager.setBillData(billData);
        customerDataManager.updateCustomerData(customerData);
        checkInDataManager.deleteCheckInData(checkInData);

        //TODO
        //jump to bills with billId
    }

    private int calculateAmount(CustomerData customerData) {
        roomDataManager = new RoomDataManager();
        RoomData roomData = roomDataManager.readAllRoomData().stream()
                .filter(roomData1 -> roomData1.getRoomNo().equals(customerData.getRoomNumber()))
                .toList()
                .get(0);

        int amount = 0;
        long noOfDaysOfStay = ChronoUnit.DAYS.between(LocalDate.parse(customerData.getCheckInDate()), LocalDate.now());
        amount = (int) (Integer.parseInt(roomData.getPrice()) * noOfDaysOfStay);

        if(customerData.getPets().equals("true")) {
            amount += 2000;
        }

        return amount;
    }


}
