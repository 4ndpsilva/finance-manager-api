package aps.financemanagerapi.domain.account.repository.spec;

import aps.financemanagerapi.core.repository.spec.AbstractSpec;
import aps.financemanagerapi.domain.account.entity.Account;
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
public class AccountSpec extends AbstractSpec<Account> {
    private Map<String, Object> params;

    @Override
    public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        super.setParams(params);
        final List<Predicate> predicates = new ArrayList<>();
        predicates.add(super.toPredicate(root, query, builder));

        final Object name = params.get("name");

        if(name != null && !name.toString().isBlank()){
            predicates.add(builder.like(builder.lower(root.get("name")), "%"+name.toString().toLowerCase()+"%"));
        }

/*        if(params.get("categoryId") != null){
            final Long categoryId = Long.valueOf(params.get("categoryId").toString()) ;
            final Category category = new Category();
            category.setId(categoryId);
            Join<Object, Object> join = root.join("category");
            predicates.add(builder.equal(join.get("category"), category));
        }*/

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}