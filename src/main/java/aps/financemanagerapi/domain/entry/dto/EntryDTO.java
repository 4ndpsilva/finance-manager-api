package aps.financemanagerapi.domain.entry.dto;

import aps.financemanagerapi.domain.entry.entity.Operation;
import aps.financemanagerapi.domain.entry.entity.PaymentType;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record EntryDTO(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        UUID id,

        @NotNull
        LocalDate entryDate,

        @NotNull
        UUID categoryId,

        @NotNull
        UUID accountId,

        @NotNull
        Operation operation,

        @NotNull
        PaymentType paymentType,

        UUID cardId,

        @NotNull
        BigDecimal value,

        BigDecimal discount,

        String observation
){}