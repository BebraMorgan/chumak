package ru.gr2305.chumak.controllers.company;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.HelloApplication;
import ru.gr2305.chumak.controllers.HelloController;
import ru.gr2305.chumak.controllers.base.BaseTableController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Company;

import java.io.IOException;
import java.util.List;

public class CompanyController extends BaseTableController<Company> {

    public TableColumn<Company, Integer> idColumn;
    public TableColumn<Company, String> nameColumn;

    @Override
    protected void initTable() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

    @Override
    protected void performEdit() throws IOException {
        openWindow("company/edit-view.fxml", "Изменение", new EditCompanyController());
    }

    @Override
    public void performAdd() throws IOException {
        openWindow("company/edit-view.fxml", "Добавление", new AddCompanyController());
    }

    @Override
    protected List<Company> performUpdateTable() {
        return EntityManagerDAO.all(Company.class);
    }

    @Override
    protected void performDelete() throws IOException, WindowedException {
        openWindow("common/confirm-delete-view.fxml", "Подтвердить", new DeleteCompanyController());
    }
}
