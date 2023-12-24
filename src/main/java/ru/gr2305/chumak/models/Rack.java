package ru.gr2305.chumak.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "racks")
public class Rack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(
            name = "room",
            referencedColumnName = "id"
    )
    private Room room;

    private String code;

    @OneToMany(mappedBy = "rack")
    private List<Cargo> cargos = new ArrayList<>();
    @Column(name = "max_cargos")
    private int maxCargos;

}
