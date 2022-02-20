package aps.financemanagerapi.domain.category.repository.spec;

import aps.financemanagerapi.core.repository.spec.AbstractSpec;
import aps.financemanagerapi.domain.category.entity.Category;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Setter
@Component
public class CategorySpec extends AbstractSpec<Category> {
    private Map<String, Object> params;

    @Override
    public Predicate toPredicate(Root<Category> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        super.setParams(params);
        final List<Predicate> predicates = new ArrayList<>();
        predicates.add(super.toPredicate(root, query, builder));

        final Object name = params.get("name");
        final Object description = params.get("description");

        if(name != null && !name.toString().isBlank()){
            predicates.add(builder.like(builder.lower(root.get("name")), "%"+name.toString().toLowerCase()+"%"));
        }

        if(description != null && !description.toString().isBlank()){
            predicates.add(builder.like(builder.lower(root.get("description")), "%"+description.toString().toLowerCase()+"%"));
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}