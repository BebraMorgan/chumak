package ru.gr2305.chumak.controllers.contract;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import ru.gr2305.chumak.controllers.base.BaseChangeController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Company;
import ru.gr2305.chumak.models.Contract;
import ru.gr2305.chumak.repositories.CompanyRepository;
import ru.gr2305.chumak.repositories.ContractRepository;

import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class AddContractController extends BaseChangeController<Contract, ContractRepository> implements Initializable {

    private final CompanyRepository companyRepository;
    @FXML
    private ComboBox<String> companyBox;
    @FXML
    private DatePicker beginPicker;
    @FXML
    private DatePicker endPicker;

    public AddContractController(Contract entity, ContractRepository repository) {
        super(entity, repository);
        companyRepository = new CompanyRepository(new Company());
    }

    @Override
    protected void performSubmit() throws IOException, WindowedException {
        if(nameTextField.getText().isEmpty()) throw new WindowedException("Вы не указали код контракта");
        if(companyBox.getSelectionModel().getSelectedItem().isEmpty()) throw new WindowedException("Вы не указали компанию");
        entity.setCode(nameTextField.getText());
        Date beginDate = Date.from(Instant.from(beginPicker.getValue().atStartOfDay(ZoneId.systemDefault())));
        Date endDate = Date.from(Instant.from(endPicker.getValue().atStartOfDay(ZoneId.systemDefault())));
        if(beginDate.after(endDate)) throw new WindowedException("Дата начала контракта не может быть после даты его конца");
        entity.setBeginDate(beginDate);
        entity.setEndDate(endDate);
        for (Company company : companyRepository.all()) {
            if (company.getName().equals(companyBox.getSelectionModel().getSelectedItem())) {
                entity.setCompany(company);
                company.getContracts().add(entity);
                repository.insert(entity);
                break;
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        for (Company company : companyRepository.all()) {
            companyBox.getItems().add(company.getName());
        }
    }
}
