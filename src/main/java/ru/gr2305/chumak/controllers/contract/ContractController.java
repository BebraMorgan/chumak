package ru.gr2305.chumak.controllers.contract;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import ru.gr2305.chumak.controllers.base.BaseTableController;
import ru.gr2305.chumak.controllers.rack.AddRackController;
import ru.gr2305.chumak.controllers.rack.DeleteRackController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Contract;
import ru.gr2305.chumak.models.Rack;
import ru.gr2305.chumak.models.transformed.TransformedContract;
import ru.gr2305.chumak.repositories.ContractRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContractController extends BaseTableController<TransformedContract, ContractRepository> {
    public TableColumn<TransformedContract, Integer> idColumn;
    public TableColumn<TransformedContract, String> companyColumn;
    public TableColumn<TransformedContract, String> beginDateColumn;
    public TableColumn<TransformedContract, String> endDateColumn;


    @Override
    protected void performInitialize() {
        repository = new ContractRepository(new Contract());
    }

    @Override
    protected void initTable() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        companyColumn.setCellValueFactory(new PropertyValueFactory<>("company"));
        beginDateColumn.setCellValueFactory(new PropertyValueFactory<>("beginDate"));
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));
    }

    @Override
    protected void performEdit() throws IOException {
        openWindow("contract/edit-view.fxml", "Изменить", new EditContractController(
                table.getSelectionModel().getSelectedItem().getContract(), repository
        ));
    }

    @Override
    public void performAdd() throws IOException {
        openWindow("contract/edit-view.fxml", "Добавить", new AddContractController(new Contract(), repository));
    }

    @Override
    protected List<TransformedContract> performUpdateTable() {
        List<TransformedContract> contracts = new ArrayList<>();
        for (Contract contract : repository.all()) {
            contracts.add(new TransformedContract(contract));
        }
        return contracts;
    }

    @Override
    protected void performDelete() throws IOException, WindowedException {
        openWindow("common/confirm-delete-view.fxml", "Подтвердить", new DeleteContractController(
                table.getSelectionModel().getSelectedItem().getContract(), repository
        ));
    }
}
