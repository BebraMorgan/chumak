package ru.gr2305.chumak.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.gr2305.chumak.enums.CargoType;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(
            name = "rack",
            referencedColumnName = "id"
    )
    private Rack rack;

    @ManyToOne
    @JoinColumn(
            name = "company",
            referencedColumnName = "id"
    )
    private Company owner;

    private String code;

    private CargoType type;


}
