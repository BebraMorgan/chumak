package ru.gr2305.chumak.controllers.cargo;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.controllers.base.BaseTableController;
import ru.gr2305.chumak.controllers.company.DeleteCompanyController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Cargo;
import ru.gr2305.chumak.models.transformed.TransformedCargo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CargoController extends BaseTableController<TransformedCargo> {
    public MenuItem CompanyItem;
    public TableColumn<TransformedCargo, Integer> idColumn;
    public TableColumn<TransformedCargo, String> nameColumn;
    public TableColumn<TransformedCargo, String> typeColumn;

    @Override
    protected void initTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("cargoType"));
    }

    @Override
    protected void performEdit() throws IOException {
        openWindow("cargo/edit-view.fxml", "Добавление", new EditCargoController());
    }

    @Override
    public void performAdd() throws IOException {
        openWindow("cargo/edit-view.fxml", "Добавление", new AddCargoController());
    }

    @Override
    protected List<TransformedCargo> performUpdateTable() {
        List<TransformedCargo> transformedCargos = new ArrayList<>();
        EntityManagerDAO.all(Cargo.class).forEach(cargo -> {
            transformedCargos.add(new TransformedCargo(cargo));
        });
        return transformedCargos;
    }

    @Override
    protected void performDelete() throws IOException, WindowedException {
        openWindow("common/confirm-delete-view.fxml", "Подтвердить", new DeleteCargoController());
    }

    public void onCompanyItemClick(ActionEvent actionEvent) {
    }
}
