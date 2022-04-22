package aps.financemanagerapi.domain.entry.entity;

import aps.financemanagerapi.core.entity.BaseEntity;
import aps.financemanagerapi.domain.account.entity.Account;
import aps.financemanagerapi.domain.card.entity.Card;
import aps.financemanagerapi.domain.category.entity.Category;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity(name = "TB_ENTRY")
public class Entry extends BaseEntity<Long> {
    @Column(name = "ENTRY_DATE")
    private LocalDate entryDate;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @Enumerated(EnumType.STRING)
    @Column(name = "OPERATION")
    private Operation operation;

    @Enumerated(EnumType.STRING)
    @Column(name = "PAYMENT_TYPE")
    private PaymentType paymentType;

    @Transient
    @ManyToOne
    @JoinColumn(name = "CARD_ID")
    private Card card;

    @Column(name = "VALUE")
    private BigDecimal value;

    @Column(name = "DISCOUNT")
    private BigDecimal discount;

    @Column(name = "OBSERVATION")
    private String observation;
}