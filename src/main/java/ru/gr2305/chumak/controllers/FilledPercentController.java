package ru.gr2305.chumak.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.models.Rack;

import java.net.URL;
import java.util.ResourceBundle;

public class FilledPercentController implements Initializable {
    public Label filled;
    public Button closeButton;

    public void close() {
        ((Stage)closeButton.getScene().getWindow()).close();
    }
    private int countFilledPercent() {
        int filled = 0;
        for (Rack rack : EntityManagerDAO.all(Rack.class)) {
            filled += (int) ( rack.getCargos().stream().count() / rack.getMaxCargos() * 100);
        }
        return (int) (filled / EntityManagerDAO.all(Rack.class).stream().count());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        filled.setText(countFilledPercent() + "%");
    }
}
