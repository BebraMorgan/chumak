package ru.gr2305.chumak.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ru.gr2305.chumak.models.Rack;
import ru.gr2305.chumak.repositories.RackRepository;

import java.net.URL;
import java.util.ResourceBundle;

public class FilledPercentController implements Initializable {
    public Label filled;
    public Button closeButton;

    private RackRepository repository;

    public void close() {
        ((Stage)closeButton.getScene().getWindow()).close();
    }
    private double countFilledPercent() {
        double filled = 0;
        for (Rack rack : repository.all()) {
            filled += (double) rack.getCargos().stream().count() / rack.getMaxCargos() * 100;
        }
        return (filled / repository.all().stream().count());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        repository = new RackRepository(new Rack());
        filled.setText(countFilledPercent() + "%");
    }
}
