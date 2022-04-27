package aps.financemanagerapi.domain.account.entity;

import aps.financemanagerapi.core.entity.BaseEntity;
import aps.financemanagerapi.domain.category.entity.Category;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_ACCOUNT")
@NamedEntityGraph(name = "category-graph", attributeNodes = @NamedAttributeNode(value = "category"))
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