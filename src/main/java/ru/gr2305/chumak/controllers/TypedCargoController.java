package ru.gr2305.chumak.controllers;

import javafx.scene.control.Label;
import ru.gr2305.chumak.controllers.cargo.CargoController;
import ru.gr2305.chumak.enums.CargoType;
import ru.gr2305.chumak.models.transformed.TransformedCargo;

import java.util.ArrayList;
import java.util.List;

public class TypedCargoController extends CargoController {
    private final CargoType type;
    public Label total;

    public TypedCargoController(CargoType type) {
        super();
        this.type  = type;
    }

    @Override
    protected List<TransformedCargo> performUpdateTable() {
        List<TransformedCargo> transformedCargos = new ArrayList<>();
        repository.all().forEach(cargo -> {
            if(cargo.getType().equals(type))
                transformedCargos.add(new TransformedCargo(cargo));
        });
        total.setText("Всего: " + transformedCargos.stream().count());
        return transformedCargos;
    }
}
