package ru.gr2305.chumak.controllers.cargo;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.NoArgsConstructor;
import ru.gr2305.chumak.controllers.base.BaseTableController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Cargo;
import ru.gr2305.chumak.models.transformed.TransformedCargo;
import ru.gr2305.chumak.repositories.CargoRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class CargoController extends BaseTableController<TransformedCargo, CargoRepository> {

    public TableColumn<TransformedCargo, Integer> idColumn;
    public TableColumn<TransformedCargo, String> nameColumn;
    public TableColumn<TransformedCargo, String> typeColumn;

    @Override
    protected void performInitialize() {
        repository = new CargoRepository(new Cargo());
    }

    @Override
    protected void initTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("cargoType"));
    }


    @Override
    protected void performEdit() throws IOException {
        Cargo cargo = table.getSelectionModel().getSelectedItem().getCargo();
        openWindow("cargo/edit-view.fxml", "Изменение", new EditCargoController(cargo, repository));
    }

    @Override
    public void performAdd() throws IOException {

        openWindow("cargo/edit-view.fxml", "Добавление", new AddCargoController(new Cargo(), repository));
    }

    @Override
    protected List<TransformedCargo> performUpdateTable() {
        List<TransformedCargo> transformedCargos = new ArrayList<>();
        repository.all().forEach(cargo -> {
            transformedCargos.add(new TransformedCargo(cargo));
        });
        return transformedCargos;
    }

    @Override
    protected void performDelete() throws IOException, WindowedException {
        Cargo cargo = table.getSelectionModel().getSelectedItem().getCargo();
        openWindow("common/confirm-delete-view.fxml", "Подтвердить", new DeleteCargoController(cargo, repository));
    }

    public void onTypeButtonClick() throws IOException {
        openWindow("type-cargo-view.fxml", "Грузы");
    }

}
