package ru.gr2305.chumak.controllers.room.racks;


import ru.gr2305.chumak.controllers.base.BaseDeleteController;
import ru.gr2305.chumak.models.Rack;
import ru.gr2305.chumak.repositories.RackRepository;

public class DeleteRackFromRoomController extends BaseDeleteController<Rack, RackRepository> {
    public DeleteRackFromRoomController(Rack entity, RackRepository repository) {
        super(entity,repository);
    }

    @Override
    protected void delete() {
        entity.setRoom(null);
        repository.update(entity);
    }
}
