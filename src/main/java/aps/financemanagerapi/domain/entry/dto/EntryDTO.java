package aps.financemanagerapi.domain.entry.dto;

import aps.financemanagerapi.domain.entry.entity.Operation;
import aps.financemanagerapi.domain.entry.entity.PaymentType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class EntryDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull
    private LocalDate entryDate;

    @NotNull
    private Long categoryId;

    @NotNull
    private Long accountId;

    @NotNull
    private Operation operation;

    @NotNull
    private PaymentType paymentType;

    private Long cardId;

    @NotNull
    private BigDecimal value;

    private BigDecimal discount;

    private String observation;
}