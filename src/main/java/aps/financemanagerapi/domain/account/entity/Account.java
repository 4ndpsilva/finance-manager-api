package aps.financemanagerapi.domain.account.entity;

import aps.financemanagerapi.core.entity.BaseEntity;
import aps.financemanagerapi.domain.category.entity.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@Entity(name = "TB_ACCOUNT")
public class Account extends BaseEntity<Long> {
    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    public Account(final Long id){
        super(id);
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }
}