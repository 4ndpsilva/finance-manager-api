package aps.financemanagerapi.core.service;

import aps.financemanagerapi.core.entity.BaseEntity;
import aps.financemanagerapi.core.repository.BaseRepository;
import aps.financemanagerapi.core.repository.spec.AbstractSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.Map;

public class BasicCrudService<T extends BaseEntity<ID>, ID extends Serializable> extends AbstractCrudService<T, ID> {
    private final AbstractSpec<T> spec;

    @Autowired
    public BasicCrudService(final BaseRepository<T, ID> repository, final AbstractSpec<T> spec, final Class<T> clazz) {
        super(repository, clazz);
        this.spec = spec;
    }

    @Override
    public Specification<T> createFilter(final Map<String, Object> params) {
        spec.setParams(params);
        return spec;
    }
}