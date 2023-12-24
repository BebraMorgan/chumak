package ru.gr2305.chumak.controllers.room;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.HelloApplication;
import ru.gr2305.chumak.controllers.base.BaseChangeController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Rack;
import ru.gr2305.chumak.models.Room;

import java.io.IOException;

public class AddRoomController extends BaseChangeController {
    @FXML
    protected TextField countTextField;
    @Override
    protected void performSubmit() throws IOException, WindowedException {
        try {
            if (nameTextField.getText().isEmpty()) throw new WindowedException("Вы не указали код помещения");
            Room room = new Room();
            room.setCode(nameTextField.getText());
            room.setMaxRacks(Integer.parseUnsignedInt(countTextField.getText()));
            EntityManagerDAO.insert(room);
        } catch (NumberFormatException e) {
            throw new WindowedException("неверный формат числа");
        }
    }
}
