package ru.gr2305.chumak.controllers.company;

import javafx.fxml.Initializable;
import ru.gr2305.chumak.controllers.base.BaseChangeController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Company;
import ru.gr2305.chumak.repositories.CompanyRepository;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditCompanyController extends BaseChangeController<Company, CompanyRepository> implements Initializable {
    public EditCompanyController(Company entity, CompanyRepository repository) {
        super(entity, repository);
    }

    @Override
    protected void performSubmit() throws IOException, WindowedException {
        if (nameTextField.getText().isEmpty()) throw new WindowedException("Вы не указали название");
        entity.setName(nameTextField.getText());
        repository.update(entity);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTextField.setText(entity.getName());
    }
}
