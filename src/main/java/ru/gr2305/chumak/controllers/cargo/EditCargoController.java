package ru.gr2305.chumak.controllers.cargo;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.controllers.base.BaseChangeController;
import ru.gr2305.chumak.enums.CargoType;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Cargo;
import ru.gr2305.chumak.models.Company;
import ru.gr2305.chumak.models.transformed.TransformedCargo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditCargoController extends BaseChangeController implements Initializable {
    @FXML
    private ComboBox<String> cargoTypeBox;
    @FXML
    private ComboBox<String> companyBox;
    @Override
    protected void performSubmit() throws IOException, WindowedException {
        if(nameTextField.getText().isEmpty()) throw new WindowedException("Вы не указали код груза");
        TransformedCargo transformedCargo = (TransformedCargo) CargoController.getChangeableObject();
        Cargo cargo = EntityManagerDAO.find(transformedCargo.getId(), Cargo.class);
        cargo.setCode(nameTextField.getText());
        EntityManagerDAO.all(Company.class).forEach(company -> {
            if(company.getName().equalsIgnoreCase(companyBox.getSelectionModel().getSelectedItem())) {
                cargo.getOwner().getCargos().remove(cargo);
                cargo.setOwner(company);
                company.getCargos().add(cargo);
            }
        });
        for (CargoType value : CargoType.values()) {
            if(value.toString().equalsIgnoreCase(cargoTypeBox.getSelectionModel().getSelectedItem())) {
                cargo.setType(value);
            }
        }
        EntityManagerDAO.update(cargo);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TransformedCargo transformedCargo = (TransformedCargo) CargoController.getChangeableObject();
        Cargo cargo = EntityManagerDAO.find(transformedCargo.getId(), Cargo.class);
        nameTextField.setText(cargo.getCode());
        EntityManagerDAO.all(Company.class).forEach(company -> {
            companyBox.getItems().add(company.getName());
        });
        if(cargo.getOwner() != null)
            companyBox.getSelectionModel().select(cargo.getOwner().getName());
        for (CargoType value : CargoType.values()) {
            cargoTypeBox.getItems().add(value.toString());
        }
        if(cargo.getType() != null)
            cargoTypeBox.getSelectionModel().select(cargo.getType().toString());


    }
}
