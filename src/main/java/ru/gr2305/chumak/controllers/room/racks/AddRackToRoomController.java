package ru.gr2305.chumak.controllers.room.racks;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import ru.gr2305.chumak.controllers.base.BaseChangeController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Rack;
import ru.gr2305.chumak.models.Room;
import ru.gr2305.chumak.repositories.RackRepository;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddRackToRoomController extends BaseChangeController<Rack, RackRepository> implements Initializable {
    @FXML
    private ComboBox<String> comboBox;

    private final Room room;

    public AddRackToRoomController(Rack entity, Room room, RackRepository repository) {
        super(entity, repository);
        this.room = room;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        repository.all().forEach(rack -> {
            if(rack.getRoom() == null || !rack.getRoom().equals(room)) {
                comboBox.getItems().add(rack.getCode());
            }
        });
    }

    @Override
    protected void performSubmit() throws IOException, WindowedException {
        if(room.getRacks().stream().count() < room.getMaxRacks()) {
            for (Rack rack : repository.all()) {
                if (rack.getCode().equals(comboBox.getSelectionModel().getSelectedItem())) {
                    rack.setRoom(room);
                    room.getRacks().add(rack);
                    repository.update(rack);
                    break;
                }
            }
        } else throw new WindowedException("Комната заполнена");
    }
}
