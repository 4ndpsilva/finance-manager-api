package aps.financemanagerapi.domain.card.entity;

import aps.financemanagerapi.core.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity(name = "TB_CARD")
public class Card extends BaseEntity<Long> {
    @Column(name = "NAME")
    private String name;

    @Column(name = "CARD_TYPE")
    @Enumerated(EnumType.STRING)
    private CardType cardType;

    @Column(name = "FLAG")
    @Enumerated(EnumType.STRING)
    private Flag flag;

    @Column(name = "CLOSING_DAY")
    private Integer closingDay;

    @Column(name = "PAY_DAY")
    private Integer payDay;

    @Column(name = "EXPIRATION_DATE")
    private LocalDate expirationDay;

    public Card(final Long id){
        super(id);
    }
}