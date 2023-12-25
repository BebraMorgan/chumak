package ru.gr2305.chumak.controllers.rack.cargos;

import ru.gr2305.chumak.controllers.cargo.CargoController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Cargo;
import ru.gr2305.chumak.models.Rack;
import ru.gr2305.chumak.models.transformed.TransformedCargo;
import ru.gr2305.chumak.repositories.CargoRepository;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CargoRackController extends CargoController {
    private Rack rack;
    private final CargoRepository cargoRepository = new CargoRepository(new Cargo());

    public CargoRackController(Rack rack) {
        this.rack = rack;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        editItem.setVisible(false);
        bootTable();
    }
    @Override
    public void performAdd() throws IOException {
        openWindow("cargo/add-rack-view.fxml", "Добавление", new AddCargoInRackController(rack, cargoRepository));
    }

    @Override
    protected void performDelete() throws IOException, WindowedException {
        Cargo cargo = table.getSelectionModel().getSelectedItem().getCargo();
        openWindow("common/confirm-delete-view.fxml", "Подтвердить", new DeleteCargoFromRackController(cargo, cargoRepository));
    }
    @Override
    protected List<TransformedCargo> performUpdateTable() {
        List<TransformedCargo> transformedCargos = new ArrayList<>();
        cargoRepository.all().forEach(cargo -> {
            if(cargo.getRack() != null && cargo.getRack().equals(rack))
                transformedCargos.add(new TransformedCargo(cargo));
        });
        return transformedCargos;
    }


}
