package ru.gr2305.chumak.controllers.base;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

abstract public class BaseDeleteController {

    @FXML
    protected Button confirmButton;
    @FXML
    protected Button cancelButton;
    @FXML
    public void onConfirmButtonClick() {
        delete();
        Stage stage = (Stage)cancelButton.getScene().getWindow();
        stage.close();
    }

    abstract protected void delete();
    @FXML
    public void onCancelButtonClick() {
        Stage stage = (Stage)cancelButton.getScene().getWindow();
        stage.close();
    }
}
