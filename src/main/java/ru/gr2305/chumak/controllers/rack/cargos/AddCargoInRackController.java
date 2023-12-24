package ru.gr2305.chumak.controllers.rack.cargos;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.controllers.base.BaseChangeController;

import ru.gr2305.chumak.controllers.rack.RackController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Cargo;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCargoInRackController extends BaseChangeController implements Initializable {
    @FXML
    public ComboBox<String> comboBox;

    @Override
    protected void performSubmit() throws IOException, WindowedException {
        EntityManagerDAO.all(Cargo.class).forEach(cargo -> {
            if (comboBox.getSelectionModel().getSelectedItem().equalsIgnoreCase(cargo.getCode())) {
                cargo.setRack(RackController.getRack());
                RackController.getRack().getCargos().add(cargo);
                EntityManagerDAO.update(cargo);
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Cargo cargo : EntityManagerDAO.all(Cargo.class)) {
            if (cargo.getRack() == null || !cargo.getRack().equals(RackController.getRack()))
                comboBox.getItems().add(cargo.getCode());
        }
    }
}
