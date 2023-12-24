package ru.gr2305.chumak.controllers.rack.cargos;

import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.controllers.cargo.AddCargoController;
import ru.gr2305.chumak.controllers.cargo.CargoController;
import ru.gr2305.chumak.controllers.cargo.DeleteCargoController;
import ru.gr2305.chumak.controllers.rack.RackController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Cargo;
import ru.gr2305.chumak.models.transformed.TransformedCargo;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CargoRackController extends CargoController {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        editItem.setVisible(false);
        bootTable();
    }
    @Override
    public void performAdd() throws IOException {
        openWindow("cargo/add-rack-view.fxml", "Добавление", new AddCargoInRackController());
    }

    @Override
    protected void performDelete() throws IOException, WindowedException {
        openWindow("common/confirm-delete-view.fxml", "Подтвердить", new DeleteCargoFromRackController());
    }
    @Override
    protected List<TransformedCargo> performUpdateTable() {
        List<TransformedCargo> transformedCargos = new ArrayList<>();
        EntityManagerDAO.all(Cargo.class).forEach(cargo -> {
            if(cargo.getRack() != null && cargo.getRack().equals(RackController.getRack()))
                transformedCargos.add(new TransformedCargo(cargo));
        });
        return transformedCargos;
    }


}
