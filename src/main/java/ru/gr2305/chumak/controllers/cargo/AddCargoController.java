package ru.gr2305.chumak.controllers.cargo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import ru.gr2305.chumak.controllers.base.BaseChangeController;
import ru.gr2305.chumak.enums.CargoType;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Cargo;
import ru.gr2305.chumak.models.Company;
import ru.gr2305.chumak.repositories.CargoRepository;
import ru.gr2305.chumak.repositories.CompanyRepository;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCargoController extends BaseChangeController<Cargo, CargoRepository> implements Initializable {

    @FXML
    private ComboBox<String> cargoTypeBox;
    @FXML
    private ComboBox<String> companyBox;

    private final CompanyRepository companyRepository = new CompanyRepository(new Company());

    public AddCargoController(Cargo entity, CargoRepository repository) {
        super(entity, repository);
    }


    @Override
    protected void performSubmit() throws IOException, WindowedException {
        entity.setCode(nameTextField.getText());
        for (Company company : companyRepository.all()) {
            if (company.getName().equals(companyBox.getSelectionModel().getSelectedItem())) {
                entity.setOwner(company);
                company.getCargos().add(entity);
                break;
            }
        }
        for (CargoType value : CargoType.values()) {
            if(value.toString().equals(cargoTypeBox.getSelectionModel().getSelectedItem())) {
                entity.setType(value);
                break;
            }
        }
        repository.insert(entity);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        companyRepository.all().forEach(company -> {
            companyBox.getItems().add(company.getName());
        });
        for (CargoType value : CargoType.values()) {
            cargoTypeBox.getItems().add(value.toString());
        }

    }
}
