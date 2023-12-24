package ru.gr2305.chumak.controllers.room.racks;

import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.controllers.rack.AddRackController;
import ru.gr2305.chumak.controllers.rack.DeleteRackController;
import ru.gr2305.chumak.controllers.rack.RackController;
import ru.gr2305.chumak.controllers.room.RoomController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Rack;
import ru.gr2305.chumak.models.Room;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class RackRoomController extends RackController {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        editItem.setVisible(false);
        bootTable();
    }

    @Override
    protected List<Rack> performUpdateTable() {
        Room room = RoomController.getRoom();
        List<Rack> racks = new ArrayList<>();
        EntityManagerDAO.all(Rack.class).forEach(rack -> {
            if(rack.getRoom() != null && rack.getRoom().equals(room)) {
                racks.add(rack);
            }
        });
        return racks;
    }

    @Override
    public void performAdd() throws IOException {
        openWindow("rack/add-room-view.fxml", "Добавить", new AddRackToRoomController());
    }

    @Override
    protected void performDelete() throws IOException, WindowedException {
        openWindow("common/confirm-delete-view.fxml", "Подтвердить", new DeleteRackFromRoomController());
    }
}
