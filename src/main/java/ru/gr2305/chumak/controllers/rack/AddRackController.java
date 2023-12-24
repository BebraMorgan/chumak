package ru.gr2305.chumak.controllers.rack;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.controllers.base.BaseChangeController;
import ru.gr2305.chumak.controllers.room.RoomController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Rack;
import ru.gr2305.chumak.models.Room;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddRackController extends BaseChangeController {
    @FXML
    protected TextField countTextField;
    @Override
    protected void performSubmit() throws IOException, WindowedException {
        try {
        Rack rack = new Rack();
        rack.setCode(nameTextField.getText());
        rack.setMaxCargos(Integer.parseUnsignedInt(countTextField.getText()));
        EntityManagerDAO.insert(rack);
        } catch (NumberFormatException e) {
            throw new WindowedException("неверный формат числа");
        }
    }
}
