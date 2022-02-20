package aps.financemanagerapi.domain.entry.dto;

import aps.financemanagerapi.domain.entry.entity.Operation;
import aps.financemanagerapi.domain.entry.entity.PaymentType;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ImportDTO {
    private LocalDate entryDate;
    private String category;
    private String account;
    private Operation operation;
    private PaymentType paymentType;
    private String card;
    private BigDecimal value;
    private String observation;
}