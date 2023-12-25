package ru.gr2305.chumak.controllers.rack.cargos;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import ru.gr2305.chumak.controllers.base.BaseChangeController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Cargo;
import ru.gr2305.chumak.models.Rack;
import ru.gr2305.chumak.repositories.CargoRepository;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCargoInRackController extends BaseChangeController<Rack, CargoRepository> implements Initializable {
    @FXML
    public ComboBox<String> comboBox;

    public AddCargoInRackController(Rack entity, CargoRepository repository) {
        super(entity, repository);
    }

    @Override
    protected void performSubmit() throws IOException, WindowedException {
        repository.all().forEach(cargo -> {
            if (comboBox.getSelectionModel().getSelectedItem().equalsIgnoreCase(cargo.getCode())) {
                cargo.setRack(entity);
                entity.getCargos().add(cargo);
                repository.update(cargo);
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Cargo cargo : repository.all()) {
            if (cargo.getRack() == null || !cargo.getRack().equals(entity))
                comboBox.getItems().add(cargo.getCode());
        }
    }
}
