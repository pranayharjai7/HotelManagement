package com.pranayharjai.hotelmanagement.Controllers;

import com.pranayharjai.hotelmanagement.Main;
import com.pranayharjai.hotelmanagement.Models.RoomData;
import com.pranayharjai.hotelmanagement.Models.RoomDataManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

public class RoomSearchController {

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
    }

    public void nonAcMenuItemClicked(ActionEvent actionEvent) {
    }

    public void oneBedMenuItemClicked(ActionEvent actionEvent) {
    }

    public void twoBedMenuItemClicked(ActionEvent actionEvent) {
    }

    public void threeBedMenuItemClicked(ActionEvent actionEvent) {
    }

    public void noOfBedsMenuItemClicked(ActionEvent actionEvent) {
    }

    public void priceMenuItemClicked(ActionEvent actionEvent) {
    }

    public void clearFiltersButtonClicked(ActionEvent actionEvent) {
    }

    public void bookButtonClicked(ActionEvent actionEvent) {
    }

    public void backButtonClicked(ActionEvent actionEvent) throws IOException {
        Main.setScene("HotelManagementMenu.fxml");
    }
}
