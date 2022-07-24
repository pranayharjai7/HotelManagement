package com.pranayharjai.hotelmanagement.Controllers;

import com.pranayharjai.hotelmanagement.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.io.IOException;

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

    @FXML
    public void initialize(){

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
