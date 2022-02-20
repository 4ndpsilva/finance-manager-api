package aps.financemanagerapi.domain.card.dto;

import aps.financemanagerapi.domain.card.entity.CardType;
import aps.financemanagerapi.domain.card.entity.Flag;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

public record CardDTO(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY)
        UUID id,

        @NotBlank
        String name,

        @NotNull
        CardType cardType,

        @NotNull
        Flag flag,

        Integer closingDay,
        Integer payDay,

        @NotNull
        LocalDate expirationDay
){}