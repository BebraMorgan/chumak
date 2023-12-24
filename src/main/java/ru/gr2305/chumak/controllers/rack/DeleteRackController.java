package ru.gr2305.chumak.controllers.rack;

import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.controllers.base.BaseDeleteController;
import ru.gr2305.chumak.models.Rack;

public class DeleteRackController extends BaseDeleteController {
    @Override
    protected void delete() {
        EntityManagerDAO.delete(RackController.getChangeableObject());
    }
}
