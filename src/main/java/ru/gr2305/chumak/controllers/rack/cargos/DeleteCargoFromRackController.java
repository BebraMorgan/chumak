package ru.gr2305.chumak.controllers.rack.cargos;

import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.controllers.HelloController;
import ru.gr2305.chumak.controllers.base.BaseDeleteController;
import ru.gr2305.chumak.models.Cargo;
import ru.gr2305.chumak.models.Rack;
import ru.gr2305.chumak.models.transformed.TransformedCargo;

public class DeleteCargoFromRackController extends BaseDeleteController {
    @Override
    protected void delete() {
        TransformedCargo transformedCargo = (TransformedCargo) CargoRackController.getChangeableObject();
        Cargo cargo = EntityManagerDAO.find(transformedCargo.getId(), Cargo.class);
        cargo.getRack().getCargos().remove(cargo);
        cargo.setRack(null);
        EntityManagerDAO.update(cargo);
    }
}
