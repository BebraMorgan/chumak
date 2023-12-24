package ru.gr2305.chumak.controllers.cargo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.HelloApplication;
import ru.gr2305.chumak.controllers.base.BaseChangeController;
import ru.gr2305.chumak.enums.CargoType;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Cargo;
import ru.gr2305.chumak.models.Company;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCargoController extends BaseChangeController implements Initializable {

    @FXML
    private ComboBox<String> cargoTypeBox;
    @FXML
    private ComboBox<String> companyBox;

    @Override
    protected void performSubmit() throws IOException, WindowedException {
        Cargo cargo = new Cargo();
        cargo.setCode(nameTextField.getText());
        for (Company company : EntityManagerDAO.all(Company.class)) {
            if (company.getName().equalsIgnoreCase(companyBox.getSelectionModel().getSelectedItem())) {
                cargo.setOwner(company);
                company.getCargos().add(cargo);
                break;
            }
        }
        for (CargoType value : CargoType.values()) {
            if(value.toString().equalsIgnoreCase(cargoTypeBox.getSelectionModel().getSelectedItem())) {
                cargo.setType(value);
            }
        }
        EntityManagerDAO.insert(cargo);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EntityManagerDAO.all(Company.class).forEach(company -> {
            companyBox.getItems().add(company.getName());
        });
        for (CargoType value : CargoType.values()) {
            cargoTypeBox.getItems().add(value.toString());
        }

    }
}
