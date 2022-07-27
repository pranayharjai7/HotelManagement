package com.pranayharjai.hotelmanagement.Controllers;

import com.pranayharjai.hotelmanagement.Main;
import com.pranayharjai.hotelmanagement.Models.RoomData;
import com.pranayharjai.hotelmanagement.Models.RoomDataManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class RoomSearchController {

    public static String SELECTED_ROOM = "";

    @FXML
    private TableView roomSearchTableView;
    @FXML
    private TableColumn roomNo;
    @FXML
    private TableColumn typeOfRoom;
    @FXML
    private TableColumn noOfBeds;
    @FXML
    private TableColumn price;
    @FXML
    private TableColumn availability;

    @FXML
    private MenuButton typeOfRoomMenuButton;
    @FXML
    private MenuItem acMenuItem;
    @FXML
    private MenuItem nonAcMenuItem;

    @FXML
    private MenuButton noOfBedsMenuButton;
    @FXML
    private MenuItem oneBedMenuItem;
    @FXML
    private MenuItem twoBedMenuItem;
    @FXML
    private MenuItem threeBedMenuItem;


    @FXML
    private MenuButton orderByMenuButton;
    @FXML
    private MenuItem noOfBedsMenuItem;
    @FXML
    private MenuItem priceMenuItem;

    @FXML
    private Button bookButton;

    private RoomDataManager roomDataManager;

    @FXML
    public void initialize() {
        linkRoomSearchTableViewColumns();

        roomDataManager = new RoomDataManager();
        List<RoomData> roomDataList = roomDataManager.readAllRoomData();

        if (roomDataList.isEmpty()) {
            addDataToRoomDataTable();
            roomDataList = roomDataManager.readAllRoomData();
        }

        roomSearchTableView.getItems().addAll(roomDataList);
    }

    private void addDataToRoomDataTable() {
        for (int i = 1; i <= 60; i++) {
            RoomData roomData = null;
            if (i <= 10) {
                roomData = new RoomData("" + i, "NON-AC", "1", "10000", "AVAILABLE");
            } else if (i <= 20) {
                roomData = new RoomData("" + i, "NON-AC", "2", "15000", "AVAILABLE");
            } else if (i <= 30) {
                roomData = new RoomData("" + i, "NON-AC", "3", "20000", "AVAILABLE");
            } else if (i <= 40) {
                roomData = new RoomData("" + i, "AC", "1", "20000", "AVAILABLE");
            } else if (i <= 50) {
                roomData = new RoomData("" + i, "AC", "2", "25000", "AVAILABLE");
            } else if (i <= 60) {
                roomData = new RoomData("" + i, "AC", "3", "30000", "AVAILABLE");
            }
            roomDataManager.setRoomData(roomData);
        }

    }

    private void linkRoomSearchTableViewColumns() {
        roomNo.setCellValueFactory(new PropertyValueFactory<RoomData, String>("roomNo"));
        typeOfRoom.setCellValueFactory(new PropertyValueFactory<RoomData, String>("typeOfRoom"));
        noOfBeds.setCellValueFactory(new PropertyValueFactory<RoomData, String>("noOfBeds"));
        price.setCellValueFactory(new PropertyValueFactory<RoomData, String>("price"));
        availability.setCellValueFactory(new PropertyValueFactory<RoomData, String>("availability"));
    }


    public void acMenuItemClicked(ActionEvent actionEvent) {
        roomSearchTableView.getItems().clear();

        List<RoomData> roomDataList = roomDataManager.readAllRoomData();
        roomDataList = roomDataList.stream().filter(roomData -> roomData.getTypeOfRoom().equals("AC"))
                .collect(Collectors.toList());

        roomSearchTableView.getItems().addAll(roomDataList);
    }

    public void nonAcMenuItemClicked(ActionEvent actionEvent) {
        roomSearchTableView.getItems().clear();

        List<RoomData> roomDataList = roomDataManager.readAllRoomData();
        roomDataList = roomDataList.stream().filter(roomData -> roomData.getTypeOfRoom().equals("NON-AC"))
                .collect(Collectors.toList());

        roomSearchTableView.getItems().addAll(roomDataList);
    }

    public void oneBedMenuItemClicked(ActionEvent actionEvent) {
        roomSearchTableView.getItems().clear();

        List<RoomData> roomDataList = roomDataManager.readAllRoomData();
        roomDataList = roomDataList.stream().filter(roomData -> roomData.getNoOfBeds().equals("1"))
                .collect(Collectors.toList());

        roomSearchTableView.getItems().addAll(roomDataList);
    }

    public void twoBedMenuItemClicked(ActionEvent actionEvent) {
        roomSearchTableView.getItems().clear();

        List<RoomData> roomDataList = roomDataManager.readAllRoomData();
        roomDataList = roomDataList.stream().filter(roomData -> roomData.getNoOfBeds().equals("2"))
                .collect(Collectors.toList());

        roomSearchTableView.getItems().addAll(roomDataList);
    }

    public void threeBedMenuItemClicked(ActionEvent actionEvent) {
        roomSearchTableView.getItems().clear();

        List<RoomData> roomDataList = roomDataManager.readAllRoomData();
        roomDataList = roomDataList.stream().filter(roomData -> roomData.getNoOfBeds().equals("3"))
                .collect(Collectors.toList());

        roomSearchTableView.getItems().addAll(roomDataList);
    }

    public void noOfBedsMenuItemClicked(ActionEvent actionEvent) {
        roomSearchTableView.getItems().clear();

        List<RoomData> roomDataList = roomDataManager.readAllRoomData();
        roomDataList = roomDataList.stream().sorted((o1, o2) -> o1.getNoOfBeds().compareTo(o2.getNoOfBeds())).collect(Collectors.toList());

        roomSearchTableView.getItems().addAll(roomDataList);
    }

    public void priceMenuItemClicked(ActionEvent actionEvent) {
        roomSearchTableView.getItems().clear();

        List<RoomData> roomDataList = roomDataManager.readAllRoomData();
        roomDataList = roomDataList.stream().sorted((o1, o2) -> o1.getPrice().compareTo(o2.getPrice())).collect(Collectors.toList());

        roomSearchTableView.getItems().addAll(roomDataList);
    }

    public void clearFiltersButtonClicked(ActionEvent actionEvent) {
        roomSearchTableView.getItems().clear();
        List<RoomData> roomDataList = roomDataManager.readAllRoomData();
        roomSearchTableView.getItems().addAll(roomDataList);
    }

    public void bookButtonClicked(ActionEvent actionEvent) throws IOException {
        for (int i = 0; i < 60; i++) {
            if (roomSearchTableView.getSelectionModel().isSelected(i)) {
                RoomData roomData = (RoomData) roomSearchTableView.getSelectionModel().getSelectedItem();
                if (roomData.getAvailability().equals("AVAILABLE")) {
                    bookRoom(actionEvent, roomData);
                } else {
                    unBookRoom(actionEvent, roomData);
                }
                break;
            }
        }
    }

    private void bookRoom(ActionEvent actionEvent, RoomData roomData) throws IOException {
        clearFiltersButtonClicked(actionEvent);
        SELECTED_ROOM = roomData.getRoomNo();
        Main.setScene("CheckIn.fxml");
    }

    private void unBookRoom(ActionEvent actionEvent, RoomData roomData) {
        roomData.setAvailability("AVAILABLE");
        roomDataManager.updateRoomData(roomData);
        clearFiltersButtonClicked(actionEvent);
    }

    public void backButtonClicked(ActionEvent actionEvent) throws IOException {
        Main.setScene("HotelManagementMenu.fxml");
    }

    public void roomSearchTableVIewClicked(MouseEvent mouseEvent) {
        for (int i = 0; i < 60; i++) {
            if (roomSearchTableView.getSelectionModel().isSelected(i)) {
                RoomData roomData = (RoomData) roomSearchTableView.getSelectionModel().getSelectedItem();
                if (roomData.getAvailability().equals("AVAILABLE")) {
                    bookButton.setDisable(false);
                    bookButton.setText("BOOK");
                } else {
                    bookButton.setDisable(true);
                    bookButton.setText("BOOKED");
                }
                break;
            }
        }
    }
}
