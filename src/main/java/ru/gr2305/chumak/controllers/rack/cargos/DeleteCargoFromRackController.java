package ru.gr2305.chumak.controllers.rack.cargos;


import ru.gr2305.chumak.controllers.base.BaseDeleteController;
import ru.gr2305.chumak.models.Cargo;
import ru.gr2305.chumak.repositories.CargoRepository;

public class DeleteCargoFromRackController extends BaseDeleteController<Cargo, CargoRepository> {
    public DeleteCargoFromRackController(Cargo entity, CargoRepository repository) {
        super(entity, repository);
    }

    @Override
    protected void delete() {
        entity.getRack().getCargos().remove(entity);
        entity.setRack(null);
        repository.update(entity);
    }
}
