package ru.gr2305.chumak.controllers.rack;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import ru.gr2305.chumak.controllers.base.BaseChangeController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Rack;
import ru.gr2305.chumak.repositories.RackRepository;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditRackController extends BaseChangeController<Rack, RackRepository> implements Initializable {

    @FXML
    protected TextField countTextField;

    public EditRackController(Rack entity, RackRepository repository) {
        super(entity, repository);
    }

    @Override
    protected void performSubmit() throws IOException, WindowedException {
        entity.setCode(nameTextField.getText());
        entity.setMaxCargos(Integer.parseUnsignedInt(countTextField.getText()));
        repository.update(entity);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameTextField.setText(entity.getCode());
        countTextField.setText(Integer.toString(entity.getMaxCargos()));
    }
}
