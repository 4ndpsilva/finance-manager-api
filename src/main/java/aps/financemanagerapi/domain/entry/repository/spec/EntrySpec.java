package aps.financemanagerapi.domain.entry.repository.spec;

import aps.financemanagerapi.core.repository.spec.AbstractSpec;
import aps.financemanagerapi.domain.account.entity.Account;
import aps.financemanagerapi.domain.card.entity.Card;
import aps.financemanagerapi.domain.category.entity.Category;
import aps.financemanagerapi.domain.entry.entity.Entry;
import aps.financemanagerapi.domain.entry.entity.Operation;
import aps.financemanagerapi.domain.entry.entity.PaymentType;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Setter
@Component
public class EntrySpec extends AbstractSpec<Entry> {
    private Map<String, Object> params;

    @Override
    public Predicate toPredicate(Root<Entry> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        super.setParams(params);
        final List<Predicate> predicates = new ArrayList<>();
        predicates.add(super.toPredicate(root, query, builder));

        if(params.get("startDate") != null){
            final LocalDate startDate = LocalDate.parse(params.get("startDate").toString());
            LocalDate endDate = LocalDate.now();

            if(params.get("endDate") != null){
                endDate = LocalDate.parse(params.get("endDate").toString());
            }

            predicates.add(builder.between(root.get("entryDate"), startDate, endDate));
        }

        if(params.get("categoryId") != null) {
            final Long categoryId = Long.valueOf(params.get("categoryId").toString());
            final Category category = new Category(categoryId);
            predicates.add(builder.equal(root.get("category"), category));
        }

        if(params.get("accountId") != null){
            final Long accountId = Long.valueOf(params.get("accountId").toString());
            final Account account = new Account(accountId);
            predicates.add(builder.equal(root.get("account"), account));
        }

        if(params.get("cardId") != null){
            final Long cardId = Long.valueOf(params.get("cardId").toString());
            final Card card = new Card(cardId);
            predicates.add(builder.equal(root.get("card"), card));
        }

        if(params.get("operation") != null && !params.get("operation").toString().isBlank()){
            final Operation operation = Operation.valueOf(params.get("operation").toString());
            predicates.add(builder.equal(root.get("operation"), operation));
        }

        if(params.get("paymentType") != null && !params.get("paymentType").toString().isBlank()){
            final PaymentType payment = PaymentType.valueOf(params.get("paymentType").toString());
            predicates.add(builder.equal(root.get("paymentType"), payment));
        }

        final Object observation = params.get("observation");

        if(observation != null && !observation.toString().isBlank()){
            predicates.add(builder.like(builder.lower(root.get("observation")), "%"+observation.toString().toLowerCase()+"%"));
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}