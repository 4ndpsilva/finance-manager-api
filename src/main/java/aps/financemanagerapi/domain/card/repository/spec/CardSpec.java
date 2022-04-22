package aps.financemanagerapi.domain.card.repository.spec;

import aps.financemanagerapi.core.repository.spec.AbstractSpec;
import aps.financemanagerapi.domain.card.entity.Card;
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
public class CardSpec extends AbstractSpec<Card> {
    private Map<String, Object> params;

    @Override
    public Predicate toPredicate(Root<Card> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        super.setParams(params);
        final List<Predicate> predicates = new ArrayList<>();
        predicates.add(super.toPredicate(root, query, builder));

        final Object name = params.get("name");

        if(name != null && !name.toString().isBlank()){
            predicates.add(builder.like(builder.lower(root.get("name")), "%"+name.toString().toLowerCase()+"%"));
        }

        if(params.get("cardType") != null && !params.get("cardType").toString().isBlank()){
            final String cardType = params.get("cardType").toString();
            predicates.add(builder.equal(root.get("cardType"), cardType));
        }

        if(params.get("flag") != null && !params.get("flag").toString().isBlank()){
            final String flag = params.get("flag").toString();
            predicates.add(builder.equal(root.get("flag"), flag));
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}