package ru.gr2305.chumak.controllers.company;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.gr2305.chumak.controllers.base.BaseTableController;
import ru.gr2305.chumak.models.Company;
import ru.gr2305.chumak.repositories.CompanyRepository;

import java.io.IOException;
import java.util.List;

public class CompanyController extends BaseTableController<Company, CompanyRepository> {

    public TableColumn<Company, Integer> idColumn;
    public TableColumn<Company, String> nameColumn;
    @Override
    protected void performInitialize() {
        repository = new CompanyRepository(new Company());
    }

    @Override
    protected void initTable() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

    @Override
    protected void performEdit() throws IOException {
        openWindow("company/edit-view.fxml", "Изменение", new EditCompanyController(
                table.getSelectionModel().getSelectedItem(), repository
        ));
    }

    @Override
    public void performAdd() throws IOException {
        openWindow("company/edit-view.fxml", "Добавление", new AddCompanyController(new Company(), repository));
    }

    @Override
    protected List<Company> performUpdateTable() {
        return repository.all();
    }

    @Override
    protected void performDelete() throws IOException {
        openWindow("common/confirm-delete-view.fxml", "Подтвердить", new DeleteCompanyController(
                table.getSelectionModel().getSelectedItem(), repository
        ));
    }
}
