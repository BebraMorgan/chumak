package ru.gr2305.chumak.controllers.rack;

import ru.gr2305.chumak.controllers.base.BaseDeleteController;
import ru.gr2305.chumak.models.Rack;
import ru.gr2305.chumak.repositories.RackRepository;

public class DeleteRackController extends BaseDeleteController<Rack, RackRepository> {
    public DeleteRackController(Rack entity, RackRepository repository) {
        super(entity, repository);
    }

    @Override
    protected void delete() {
        repository.delete(entity);
    }
}
