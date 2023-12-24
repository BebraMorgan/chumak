package ru.gr2305.chumak.controllers.room.racks;

import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.controllers.base.BaseDeleteController;
import ru.gr2305.chumak.controllers.rack.RackController;
import ru.gr2305.chumak.models.Rack;

public class DeleteRackFromRoomController extends BaseDeleteController {
    @Override
    protected void delete() {
        Rack rack = (Rack) RackRoomController.getChangeableObject();
        rack.setRoom(null);
        EntityManagerDAO.update(rack);
    }
}
