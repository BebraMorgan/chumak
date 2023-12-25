package ru.gr2305.chumak.controllers.room;

import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.gr2305.chumak.controllers.base.BaseTableController;
import ru.gr2305.chumak.controllers.room.racks.RackRoomController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Room;
import ru.gr2305.chumak.repositories.RoomRepository;

import java.io.IOException;
import java.util.List;

public class RoomController extends BaseTableController<Room, RoomRepository> {
    public TableColumn<Room, Integer> idColumn;
    public TableColumn<Room, String> nameColumn;
    public MenuItem RackItem;

    @Override
    protected void performInitialize() {
        repository = new RoomRepository(new Room());
    }

    @Override
    protected void initTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
    }

    @Override
    protected void performEdit() throws IOException {
        openWindow("room/edit-view.fxml", "Именение", new EditRoomController(
                table.getSelectionModel().getSelectedItem(), repository
        ));
    }

    @Override
    public void performAdd() throws IOException {
        openWindow("room/edit-view.fxml", "Добавление", new AddRoomController(new Room(), repository));
    }

    @Override
    protected List<Room> performUpdateTable() {
        return repository.all();
    }

    @Override
    protected void performDelete() throws IOException, WindowedException {
        openWindow("common/confirm-delete-view.fxml", "Подтвердить", new DeleteRoomController(
                table.getSelectionModel().getSelectedItem(), repository
        ));
    }


    public void onRackItemClick() throws IOException, WindowedException {
        if ((table.getSelectionModel().getSelectedItem()) == null)
            throw new WindowedException("Вы не выбрали ни одного элемента");
        openWindow("rack/table-view.fxml", "стеллажи в помещении", new RackRoomController(table.getSelectionModel().getSelectedItem()));
    }
}
