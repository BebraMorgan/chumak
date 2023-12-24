package ru.gr2305.chumak.controllers;

import javafx.scene.control.Label;
import ru.gr2305.chumak.EntityManagerDAO;
import ru.gr2305.chumak.controllers.cargo.CargoController;
import ru.gr2305.chumak.models.Cargo;
import ru.gr2305.chumak.models.transformed.TransformedCargo;

import java.util.ArrayList;
import java.util.List;

public class TypedCargoController extends CargoController {
    public Label total;

    @Override
    protected List<TransformedCargo> performUpdateTable() {
        List<TransformedCargo> transformedCargos = new ArrayList<>();
        EntityManagerDAO.all(Cargo.class).forEach(cargo -> {
            if(cargo.getType().equals(ChooseTypeController.getType()))
                transformedCargos.add(new TransformedCargo(cargo));
        });
        total.setText("Всего: " + transformedCargos.stream().count());
        return transformedCargos;
    }
}
