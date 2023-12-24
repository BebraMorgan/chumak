package ru.gr2305.chumak.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.controllers.base.BaseController;
import ru.gr2305.chumak.controllers.cargo.CargoController;
import ru.gr2305.chumak.controllers.rack.RackController;
import ru.gr2305.chumak.models.Rack;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController extends BaseController {

    public Button CompanyButton;
    public Button RoomButton;
    public Button RackButton;
    public Button CargoButton;
    public Button percentButton;
    public Button typeButton;

    @FXML
    protected void onRackButtonClick() throws IOException {
        openWindow("rack/table-view.fxml", "стеллажи", new RackController());
    }
    @FXML
    protected void onRoomButtonClick() throws IOException {
        openWindow("room/table-view.fxml", "Помещения");
    }
    @FXML
    protected void onCompanyButtonClick() throws IOException {
        openWindow("company/table-view.fxml", "Компании");
    }

    public void onCargoButtonClick() throws IOException {
        openWindow("cargo/table-view.fxml", "Грузы", new CargoController());
    }


    public void onPercentButtonClick() throws IOException {
        openWindow("filled-percent-view.fxml", "Грузы");
    }

    public void onTypeButtonClick() throws IOException {
        openWindow("type-cargo-view.fxml", "Грузы");
    }
}