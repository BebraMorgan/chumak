package ru.gr2305.chumak.controllers.rack;

import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;
import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.HelloApplication;
import ru.gr2305.chumak.controllers.HelloController;
import ru.gr2305.chumak.controllers.base.BaseTableController;
import ru.gr2305.chumak.controllers.rack.cargos.CargoRackController;
import ru.gr2305.chumak.controllers.room.AddRoomController;
import ru.gr2305.chumak.controllers.room.DeleteRoomController;
import ru.gr2305.chumak.controllers.room.RoomController;
import ru.gr2305.chumak.controllers.room.racks.RackRoomController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Rack;
import ru.gr2305.chumak.models.Room;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RackController extends BaseTableController<Rack> {
    public TableColumn<Rack, Integer> idColumn;
    public TableColumn<Rack, String> nameColumn;
    @FXML
    public MenuItem cargoItem;

    @Getter
    private static Rack rack;

    @Override
    protected void initTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
    }

    @Override
    protected void performEdit() throws IOException {
        openWindow("rack/edit-view.fxml", "Изменить", new EditRackController());
    }

    @Override
    public void performAdd() throws IOException {
        openWindow("rack/edit-view.fxml", "Добавить", new AddRackController());
    }

    @Override
    protected List<Rack> performUpdateTable() {
        return EntityManagerDAO.all(Rack.class);
    }

    @Override
    protected void performDelete() throws IOException, WindowedException {
        openWindow("common/confirm-delete-view.fxml", "Подтвердить", new DeleteRackController());
    }

    public void onCargoItemClick() throws IOException, WindowedException {
        if ((rack = table.getSelectionModel().getSelectedItem()) == null)
            throw new WindowedException("Вы не выбрали ни одного элемента");
        openWindow("cargo/table-view.fxml", "стеллажи в помещении", new CargoRackController());
        rack = null;
    }
}
