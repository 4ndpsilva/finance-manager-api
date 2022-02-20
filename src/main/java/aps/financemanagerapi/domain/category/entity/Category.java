package aps.financemanagerapi.domain.category.entity;

import aps.financemanagerapi.core.entity.BaseEntity;
import aps.financemanagerapi.domain.account.entity.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@Table(name = "TB_CATEGORY")
@Entity
public class Category extends BaseEntity<UUID> {
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "category")
    private Set<Account> accounts;

    public Category(final UUID id){
        super(id);
    }
}