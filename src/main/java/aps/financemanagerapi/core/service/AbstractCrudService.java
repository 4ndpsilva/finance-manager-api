package aps.financemanagerapi.core.service;

import aps.financemanagerapi.core.entity.BaseEntity;
import aps.financemanagerapi.core.repository.BaseRepository;
import aps.financemanagerapi.infrastructure.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public abstract class AbstractCrudService<T extends BaseEntity<ID>, ID extends Serializable> {
    private final BaseRepository<T, ID> repository;
    private final Class<T> entityClass;

    @Transactional
    public T save(final T entity) {
        try{
            validate(entity);
            log.info("Iniciando operacao Save");

            final T entityObj = BeanUtils.instantiateClass(entityClass);
            final T saved = save(entity, entityObj, "id");

            log.info("Operacao Save finalizada");
            return saved;
        }
        catch (Exception ex){
            log.info("Erro no processo de salvar: ", ex);
            throw ex;
        }
    }

    @Transactional
    public T update(final ID id, final T updateEntity) {
        try{
            log.info("Iniciando operacao Update");

            final T entity = findById(id);

            validate(updateEntity);
            final T updated = save(updateEntity, entity, "id");

            log.info("Operacao Update finalizada");
            return updated;
        }
        catch (Exception ex){
            log.info("Erro no processo de salvar: ", ex);
            throw ex;
        }
    }

    private T save(final T oldEntity, final T newEntity, final String... ignoreProps) {
        BeanUtils.copyProperties(oldEntity, newEntity, ignoreProps);
        return repository.save(newEntity);
    }

    @Transactional
    public void delete(final ID id) {
        try{
            log.info("Iniciando operacao Delete");

            final T entity = findById(id);
            repository.deleteById(entity.getId());

            log.info("Operacao Delete finalizada");
        }
        catch (Exception ex){
            log.info("Erro na operacao de exclusao: ", ex);
            throw ex;
        }
    }

    public T findById(final ID id) {
        try{
            final Optional<T> opEntity = repository.findById(id);

            if (opEntity.isPresent()) {
                return opEntity.get();
            }

            throw new ResourceNotFoundException("API-000", id);
        }
        catch (Exception ex){
            log.info("Erro na operacao de consulta por ID: ", ex);
            throw ex;
        }
    }

    public List<T> find(Map<String, Object> params) {
        try{
            return repository.findAll(createFilter(params));
        }
        catch (Exception ex) {
            log.info("Erro na operacao de consulta por filtro: ", ex);
            throw ex;
        }
    }

    public void validate(final T entity){}

    public abstract Specification<T> createFilter(final Map<String, Object> params);
}