package ru.gr2305.chumak.controllers.rack;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import ru.gr2305.chumak.controllers.base.BaseChangeController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Rack;
import ru.gr2305.chumak.repositories.RackRepository;

import java.io.IOException;

public class AddRackController extends BaseChangeController<Rack, RackRepository> {
    @FXML
    protected TextField countTextField;

    public AddRackController(Rack entity, RackRepository repository) {
        super(entity, repository);
    }

    @Override
    protected void performSubmit() throws IOException, WindowedException {
        try {
        entity.setCode(nameTextField.getText());
        entity.setMaxCargos(Integer.parseUnsignedInt(countTextField.getText()));
        repository.insert(entity);
        } catch (NumberFormatException e) {
            throw new WindowedException("неверный формат числа");
        }
    }
}
