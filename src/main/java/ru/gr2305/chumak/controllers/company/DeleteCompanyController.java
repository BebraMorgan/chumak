package ru.gr2305.chumak.controllers.company;

import ru.gr2305.chumak.controllers.base.BaseDeleteController;
import ru.gr2305.chumak.models.Company;
import ru.gr2305.chumak.repositories.CompanyRepository;

public class DeleteCompanyController extends BaseDeleteController<Company, CompanyRepository> {
    public DeleteCompanyController(Company entity, CompanyRepository repository) {
        super(entity, repository);
    }

    @Override
    protected void delete() {
        repository.delete(entity);
    }
}
