package aps.financemanagerapi.domain.card.dto;

import aps.financemanagerapi.domain.card.entity.CardType;
import aps.financemanagerapi.domain.card.entity.Flag;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CardDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private CardType cardType;

    @NotNull
    private Flag flag;

    private Integer closingDay;
    private Integer payDay;

    @NotNull
    private LocalDate expirationDay;
}