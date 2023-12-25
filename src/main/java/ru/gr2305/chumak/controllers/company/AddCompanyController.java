package ru.gr2305.chumak.controllers.company;

import ru.gr2305.chumak.controllers.base.BaseChangeController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Company;
import ru.gr2305.chumak.repositories.CompanyRepository;

import java.io.IOException;

public class AddCompanyController extends BaseChangeController<Company, CompanyRepository> {
    public AddCompanyController(Company entity, CompanyRepository repository) {
        super(entity, repository);
    }

    @Override
    protected void performSubmit() throws IOException, WindowedException {
        if (nameTextField.getText().isEmpty()) throw new WindowedException("Вы не указали название");
        entity.setName(nameTextField.getText());
        repository.insert(entity);
    }

}
