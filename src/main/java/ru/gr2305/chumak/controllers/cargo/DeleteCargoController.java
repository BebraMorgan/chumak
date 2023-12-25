package ru.gr2305.chumak.controllers.cargo;

import ru.gr2305.chumak.controllers.base.BaseDeleteController;
import ru.gr2305.chumak.models.Cargo;
import ru.gr2305.chumak.repositories.CargoRepository;

public class DeleteCargoController extends BaseDeleteController<Cargo, CargoRepository> {


    public DeleteCargoController(Cargo entity, CargoRepository repository) {
        super(entity, repository);
    }

    @Override
    protected void delete() {
        repository.delete(entity);
    }
}
