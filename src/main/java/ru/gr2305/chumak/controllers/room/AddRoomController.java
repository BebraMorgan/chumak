package ru.gr2305.chumak.controllers.room;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ru.gr2305.chumak.controllers.base.BaseChangeController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Room;
import ru.gr2305.chumak.repositories.RoomRepository;

import java.io.IOException;

public class AddRoomController extends BaseChangeController<Room, RoomRepository> {
    @FXML
    protected TextField countTextField;

    public AddRoomController(Room entity, RoomRepository repository) {
        super(entity, repository);
    }

    @Override
    protected void performSubmit() throws IOException, WindowedException {
        try {
            if (nameTextField.getText().isEmpty()) throw new WindowedException("Вы не указали код помещения");
            entity.setCode(nameTextField.getText());
            entity.setMaxRacks(Integer.parseUnsignedInt(countTextField.getText()));
            repository.insert(entity);
        } catch (NumberFormatException e) {
            throw new WindowedException("неверный формат числа");
        }
    }
}
