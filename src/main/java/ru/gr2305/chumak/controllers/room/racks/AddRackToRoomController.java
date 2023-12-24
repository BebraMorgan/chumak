package ru.gr2305.chumak.controllers.room.racks;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.HelloApplication;
import ru.gr2305.chumak.controllers.base.BaseChangeController;
import ru.gr2305.chumak.controllers.room.RoomController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Rack;
import ru.gr2305.chumak.models.Room;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddRackToRoomController extends BaseChangeController implements Initializable {
    @FXML
    private ComboBox<String> comboBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EntityManagerDAO.all(Rack.class).forEach(rack -> {
            if(rack.getRoom() == null || !rack.getRoom().equals(RoomController.getRoom())) {
                comboBox.getItems().add(rack.getCode());
            }
        });
    }

    @Override
    protected void performSubmit() throws IOException, WindowedException {
        Room room = RoomController.getRoom();
        if(room.getRacks().stream().count() < room.getMaxRacks()) {
            for (Rack rack : EntityManagerDAO.all(Rack.class)) {
                if (rack.getCode().equalsIgnoreCase(comboBox.getSelectionModel().getSelectedItem())) {
                    rack.setRoom(RoomController.getRoom());
                    EntityManagerDAO.update(rack);
                    break;
                }
            }
        } else throw new WindowedException("Комната заполнена");
    }
}
