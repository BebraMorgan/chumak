package ru.gr2305.chumak.controllers.room;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import lombok.Getter;
import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.controllers.base.BaseTableController;
import ru.gr2305.chumak.controllers.company.AddCompanyController;
import ru.gr2305.chumak.controllers.company.DeleteCompanyController;
import ru.gr2305.chumak.controllers.room.racks.RackRoomController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Room;

import java.io.IOException;
import java.util.List;

public class RoomController extends BaseTableController<Room> {
    public TableColumn<Room, Integer> idColumn;
    public TableColumn<Room, String> nameColumn;
    public MenuItem RackItem;
    @Getter
    private static Room room;

    @Override
    protected void initTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
    }

    @Override
    protected void performEdit() throws IOException {
        openWindow("room/edit-view.fxml", "Именение", new EditRoomController());
    }

    @Override
    public void performAdd() throws IOException {
        openWindow("room/edit-view.fxml", "Добавление", new AddRoomController());
    }

    @Override
    protected List<Room> performUpdateTable() {
        return EntityManagerDAO.all(Room.class);
    }

    @Override
    protected void performDelete() throws IOException, WindowedException {
        openWindow("common/confirm-delete-view.fxml", "Подтвердить", new DeleteRoomController());
    }


    public void onRackItemClick() throws IOException, WindowedException {
        if ((room = table.getSelectionModel().getSelectedItem()) == null)
            throw new WindowedException("Вы не выбрали ни одного элемента");
        openWindow("rack/table-view.fxml", "стеллажи в помещении", new RackRoomController());
        room = null;
    }
}
