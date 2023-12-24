package ru.gr2305.chumak.controllers.company;

import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.controllers.base.BaseDeleteController;

public class DeleteCompanyController extends BaseDeleteController {
    @Override
    protected void delete() {
        EntityManagerDAO.delete(CompanyController.getChangeableObject());
    }
}
