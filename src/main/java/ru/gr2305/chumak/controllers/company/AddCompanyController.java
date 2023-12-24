package ru.gr2305.chumak.controllers.company;

import javafx.fxml.Initializable;
import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.controllers.base.BaseChangeController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Company;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCompanyController extends BaseChangeController {
    @Override
    protected void performSubmit() throws IOException, WindowedException {
        if (nameTextField.getText().isEmpty()) throw new WindowedException("Вы не указали название");
        Company company = new Company();
        company.setName(nameTextField.getText());
        EntityManagerDAO.insert(company);
    }

}
