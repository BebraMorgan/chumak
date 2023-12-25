package ru.gr2305.chumak.controllers.room;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import ru.gr2305.chumak.controllers.base.BaseChangeController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Room;
import ru.gr2305.chumak.repositories.RoomRepository;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditRoomController extends BaseChangeController<Room, RoomRepository> implements Initializable {
    @FXML
    private TextField countTextField;

    public EditRoomController(Room entity, RoomRepository repository) {
        super(entity, repository);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTextField.setText(entity.getCode());
        countTextField.setText(Integer.toString(entity.getMaxRacks()));
    }

    @Override
    protected void performSubmit() throws IOException, WindowedException {
        if (nameTextField.getText().isEmpty()) throw new WindowedException("Вы не указали код помещения");
        entity.setCode(nameTextField.getText());
        entity.setMaxRacks(Integer.parseUnsignedInt(countTextField.getText()));
        repository.update(entity);
    }
}
