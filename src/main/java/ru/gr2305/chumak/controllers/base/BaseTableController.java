package ru.gr2305.chumak.controllers.base;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableView;
import lombok.Getter;
import ru.gr2305.chumak.exceptions.WindowedException;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public abstract class BaseTableController<T> extends BaseController implements Initializable {
    @FXML
    protected TableView<T> table;
    @FXML
    protected MenuItem deleteItem;
    @FXML
    protected MenuItem editItem;
    @FXML
    protected MenuItem addItem;

    @Getter
    protected static Object changeableObject;

    protected final ObservableList<T> observableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bootTable();
    }

    public void onAddItemClick() throws IOException {
        performAdd();
        updateTable();
        changeableObject = null;
    }
    @FXML
    public void onDeleteItemClick() throws IOException, WindowedException {
        if ((changeableObject = table.getSelectionModel().getSelectedItem()) == null)
            throw new WindowedException("Вы не выбрали ни одного элемента");
        performDelete();
        updateTable();
        changeableObject = null;
    }
    @FXML
    public void onEditItemClick() throws IOException, WindowedException {
        if ((changeableObject = table.getSelectionModel().getSelectedItem()) == null)
            throw new WindowedException("Вы не выбрали ни одного элемента");
        performEdit();
        updateTable();
        changeableObject = null;
    }

    protected void updateTable() {
        observableList.clear();
        List<T> data = performUpdateTable();
        observableList.addAll(data);
        table.setItems(observableList);
    }

    protected void bootTable() {
        initTable();
        updateTable();
    }

    abstract protected void initTable();

    abstract protected void performEdit() throws IOException;

    abstract public void performAdd() throws IOException;

    abstract protected List<T> performUpdateTable();

    abstract protected void performDelete() throws IOException, WindowedException;


}
