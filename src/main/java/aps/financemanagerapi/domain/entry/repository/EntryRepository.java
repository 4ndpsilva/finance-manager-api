package aps.financemanagerapi.domain.entry.repository;

import aps.financemanagerapi.core.repository.BaseRepository;
import aps.financemanagerapi.domain.entry.entity.Entry;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;

public interface EntryRepository extends BaseRepository<Entry, Long> {
    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH, value = "entry-graph")
    List<Entry> findAll(Specification<Entry> specification);
}