package aps.financemanagerapi.domain.category.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public record CategoryDTO (
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    UUID id,

    @NotBlank
    String name,

    String description
){}