package ru.gr2305.chumak.controllers.room.racks;

import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import ru.gr2305.chumak.controllers.rack.RackController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Rack;
import ru.gr2305.chumak.models.Room;
import ru.gr2305.chumak.repositories.RackRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RackRoomController extends RackController {

    private final Room room;
    public RackRoomController(Room room) {

        this.room = room;
    }

    @Override
    protected void performInitialize() {
        repository = new RackRepository(new Rack());
        this.editItem.setVisible(false);
    }


    @Override
    protected List<Rack> performUpdateTable() {
        List<Rack> racks = new ArrayList<>();
        repository.all().forEach(rack -> {
            if(rack.getRoom() != null && rack.getRoom().equals(room)) {
                racks.add(rack);
            }
        });
        return racks;
    }

    @Override
    public void performAdd() throws IOException {
        openWindow("rack/add-room-view.fxml", "Добавить", new AddRackToRoomController(new Rack(), room, repository));
    }

    @Override
    protected void performDelete() throws IOException, WindowedException {
        openWindow("common/confirm-delete-view.fxml", "Подтвердить", new DeleteRackFromRoomController(
                table.getSelectionModel().getSelectedItem(), repository)
        );
    }
}
