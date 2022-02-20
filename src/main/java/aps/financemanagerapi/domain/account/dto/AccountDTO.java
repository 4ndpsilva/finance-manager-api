package aps.financemanagerapi.domain.account.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public record AccountDTO(
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    UUID id,

    @NotBlank
    String name,

    @NotNull
    UUID categoryId
){}