package ru.gr2305.chumak.controllers.room;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.controllers.base.BaseChangeController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Room;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditRoomController extends BaseChangeController implements Initializable {
    @FXML
    private TextField countTextField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Room room = (Room) RoomController.getChangeableObject();
        nameTextField.setText(room.getCode());
        countTextField.setText(Integer.toString(room.getMaxRacks()));
    }

    @Override
    protected void performSubmit() throws IOException, WindowedException {
        if (nameTextField.getText().isEmpty()) throw new WindowedException("Вы не указали код помещения");
        Room room = ((Room) RoomController.getChangeableObject());
        room.setCode(nameTextField.getText());
        room.setMaxRacks(Integer.parseUnsignedInt(countTextField.getText()));
        EntityManagerDAO.update(room);
    }
}
