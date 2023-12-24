package ru.gr2305.chumak.controllers.room;

import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.controllers.base.BaseDeleteController;

public class DeleteRoomController extends BaseDeleteController {
    @Override
    protected void delete() {
        EntityManagerDAO.delete(RoomController.getChangeableObject());
    }
}
