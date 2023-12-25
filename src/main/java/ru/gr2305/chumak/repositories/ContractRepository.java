package ru.gr2305.chumak.repositories;

import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.jetbrains.annotations.Nullable;
import ru.gr2305.chumak.models.Contract;

import java.util.Collections;
import java.util.List;

public class ContractRepository extends BaseRepository<Contract> {

    public ContractRepository(Contract model) {
        super(model);
    }
}
