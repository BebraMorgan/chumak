package ru.gr2305.chumak.controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import ru.gr2305.chumak.controllers.base.BaseController;
import ru.gr2305.chumak.enums.CargoType;
import ru.gr2305.chumak.exceptions.WindowedException;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChooseTypeController extends BaseController implements Initializable {
    public ComboBox<String> comboBox;
    private CargoType type;
    public void find() throws IOException, WindowedException {
        if(comboBox.getSelectionModel().getSelectedItem() == null) throw new WindowedException("Вы не выбрали тип груза");
        for (CargoType cargoType : CargoType.values()) {
            if(comboBox.getSelectionModel().getSelectedItem().equalsIgnoreCase(cargoType.toString())) {
                type = cargoType;
            }
        }
        openWindow("table-typed-view.fxml", "груз типа \"" +  type.toString() + "\"", new TypedCargoController(type));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (CargoType type : CargoType.values()) {
            comboBox.getItems().add(type.toString());
        }
    }
}
