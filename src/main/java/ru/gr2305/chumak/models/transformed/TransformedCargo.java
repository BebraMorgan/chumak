package ru.gr2305.chumak.models.transformed;

import lombok.Data;
import ru.gr2305.chumak.enums.CargoType;
import ru.gr2305.chumak.models.Cargo;

@Data
public class TransformedCargo {
    private int id;
    private String code;
    private String cargoType;



    public TransformedCargo(Cargo cargo) {
        id = cargo.getId();
        code = cargo.getCode();
        cargoType = cargo.getType().toString();
    }

}
