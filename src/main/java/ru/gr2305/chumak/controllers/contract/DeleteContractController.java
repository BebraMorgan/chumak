package ru.gr2305.chumak.controllers.contract;

import ru.gr2305.chumak.controllers.base.BaseDeleteController;
import ru.gr2305.chumak.models.Contract;
import ru.gr2305.chumak.repositories.ContractRepository;

public class DeleteContractController extends BaseDeleteController<Contract, ContractRepository> {
    public DeleteContractController(Contract entity, ContractRepository repository) {
        super(entity, repository);
    }

    @Override
    protected void delete() {
        repository.delete(entity);
    }
}
