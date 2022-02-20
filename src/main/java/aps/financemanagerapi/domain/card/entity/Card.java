package aps.financemanagerapi.domain.card.entity;

import aps.financemanagerapi.core.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table(name = "TB_CARD")
@Entity
public class Card extends BaseEntity<UUID> {
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

    public Card(final UUID id){
        super(id);
    }
}