package ru.gr2305.chumak.controllers.room;

import ru.gr2305.chumak.controllers.base.BaseDeleteController;
import ru.gr2305.chumak.models.Room;
import ru.gr2305.chumak.repositories.RoomRepository;

public class DeleteRoomController extends BaseDeleteController<Room, RoomRepository> {
    public DeleteRoomController(Room entity, RoomRepository repository) {
        super(entity, repository);
    }

    @Override
    protected void delete() {
        repository.delete(entity);
    }
}
