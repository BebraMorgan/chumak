package ru.gr2305.chumak.controllers.cargo;

import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.controllers.base.BaseDeleteController;
import ru.gr2305.chumak.models.Cargo;
import ru.gr2305.chumak.models.transformed.TransformedCargo;

public class DeleteCargoController extends BaseDeleteController {
    @Override
    protected void delete() {
        Cargo cargo = EntityManagerDAO.find(((TransformedCargo) CargoController.getChangeableObject()).getId(), Cargo.class);
        EntityManagerDAO.delete(cargo);
    }
}
