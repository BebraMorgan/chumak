package ru.gr2305.chumak.controllers.rack;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.gr2305.chumak.controllers.base.BaseTableController;
import ru.gr2305.chumak.controllers.rack.cargos.CargoRackController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Rack;
import ru.gr2305.chumak.repositories.RackRepository;

import java.io.IOException;
import java.util.List;

public class RackController extends BaseTableController<Rack, RackRepository> {
    public TableColumn<Rack, Integer> idColumn;
    public TableColumn<Rack, String> nameColumn;
    @FXML
    public MenuItem cargoItem;

    @Override
    protected void performInitialize() {
        repository = new RackRepository(new Rack());
    }

    @Override
    protected void initTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
    }

    @Override
    protected void performEdit() throws IOException {
        openWindow("rack/edit-view.fxml", "Изменить", new EditRackController(
                table.getSelectionModel().getSelectedItem(), repository
        ));
    }

    @Override
    public void performAdd() throws IOException {
        openWindow("rack/edit-view.fxml", "Добавить", new AddRackController(new Rack(), repository));
    }

    @Override
    protected List<Rack> performUpdateTable() {
        return repository.all();
    }

    @Override
    protected void performDelete() throws IOException, WindowedException {
        openWindow("common/confirm-delete-view.fxml", "Подтвердить", new DeleteRackController(
                table.getSelectionModel().getSelectedItem(), repository
        ));
    }

    public void onCargoItemClick() throws IOException, WindowedException {
        if ((table.getSelectionModel().getSelectedItem()) == null)
            throw new WindowedException("Вы не выбрали ни одного элемента");
        openWindow("cargo/table-view.fxml", "стеллажи в помещении", new CargoRackController(
                table.getSelectionModel().getSelectedItem()
        ));
    }
}
