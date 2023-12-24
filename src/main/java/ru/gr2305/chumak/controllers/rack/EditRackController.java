package ru.gr2305.chumak.controllers.rack;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import ru.gr2305.chumak.controllers.base.BaseChangeController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Rack;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EditRackController extends BaseChangeController implements Initializable {

    @FXML
    protected TextField countTextField;

    @Override
    protected void performSubmit() throws IOException, WindowedException {
        Rack rack = (Rack) RackController.getChangeableObject();
        rack.setCode(nameTextField.getText());
        rack.setMaxCargos(Integer.parseUnsignedInt(countTextField.getText()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Rack rack = (Rack) RackController.getChangeableObject();
        nameTextField.setText(rack.getCode());
        countTextField.setText(Integer.toString(rack.getMaxCargos()));
    }
}
