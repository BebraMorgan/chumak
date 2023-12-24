package ru.gr2305.chumak.controllers.contract;

import ru.gr2305.chumak.controllers.base.BaseTableController;
import ru.gr2305.chumak.exceptions.WindowedException;
import ru.gr2305.chumak.models.Contract;

import java.io.IOException;
import java.util.List;

public class ContractController extends BaseTableController<Contract> {
    @Override
    protected void initTable() {

    }

    @Override
    protected void performEdit() throws IOException {

    }

    @Override
    public void performAdd() throws IOException {

    }

    @Override
    protected List<Contract> performUpdateTable() {
        return null;
    }

    @Override
    protected void performDelete() throws IOException, WindowedException {

    }
}
