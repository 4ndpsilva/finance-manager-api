package aps.financemanagerapi.domain.category.entity;

import aps.financemanagerapi.core.entity.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TB_CATEGORY")
public class Category extends BaseEntity<Long> {
    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    public Category(final Long id){
        super(id);
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public void setDescription(String description) {
        this.description = description.toUpperCase();
    }
}