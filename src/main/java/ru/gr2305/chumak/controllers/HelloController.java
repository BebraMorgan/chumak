package ru.gr2305.chumak.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import ru.gr2305.chumak.controllers.base.BaseController;
import ru.gr2305.chumak.controllers.cargo.CargoController;
import ru.gr2305.chumak.controllers.rack.RackController;

import java.io.IOException;

public class HelloController extends BaseController {

    public Button CompanyButton;
    public Button RoomButton;
    public Button RackButton;
    public Button CargoButton;
    public Button percentButton;
    public Button typeButton;
    public Button contract;

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


    public void onContractButtonClick() throws IOException {
        openWindow("contract/table-view.fxml", "Контракты");
    }
}