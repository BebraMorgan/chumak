package ru.gr2305.chumak.controllers.base;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.gr2305.chumak.exceptions.WindowedException;

import java.io.IOException;

abstract public class BaseChangeController {
    @FXML
    protected Button submitButton;
    @FXML
    protected TextField nameTextField;
    @FXML
    public void onSubmitButtonClick() throws WindowedException, IOException {
        performSubmit();
        Stage stage = (Stage) submitButton.getScene().getWindow();
        stage.close();
    };

    protected abstract void performSubmit() throws IOException, WindowedException;
}
