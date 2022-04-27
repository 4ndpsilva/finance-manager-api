package aps.financemanagerapi.domain.account.repository;

import aps.financemanagerapi.core.repository.BaseRepository;
import aps.financemanagerapi.domain.account.entity.Account;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;

public interface AccountRepository extends BaseRepository<Account, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "category-graph")
    List<Account> findAll(Specification<Account> specification);
}