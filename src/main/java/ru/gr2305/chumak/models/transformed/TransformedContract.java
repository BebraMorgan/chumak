package ru.gr2305.chumak.models.transformed;

import lombok.Data;
import ru.gr2305.chumak.models.Contract;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

@Data
public class TransformedContract {
    private int id;
    private String company;

    private Contract contract;
    private String beginDate;
    private String endDate;

    public TransformedContract(Contract contract) {
        this.contract = contract;
        this.id = contract.getId();
        this.company = contract.getCompany().getName();
        this.beginDate = (new SimpleDateFormat("dd.MM.yyyy")).format(contract.getBeginDate());
        this.endDate = (new SimpleDateFormat("dd.MM.yyyy")).format(contract.getEndDate());
    }
}
