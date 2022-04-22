package aps.financemanagerapi.domain.category.service;

import aps.financemanagerapi.core.service.BasicCrudService;
import aps.financemanagerapi.domain.category.entity.Category;
import aps.financemanagerapi.domain.category.repository.CategoryRepository;
import aps.financemanagerapi.domain.category.repository.spec.CategorySpec;
import aps.financemanagerapi.infrastructure.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends BasicCrudService<Category, Long> {
    private final CategoryRepository repository;

    @Autowired
    public CategoryService(final CategoryRepository repository, final CategorySpec spec) {
        super(repository, spec, Category.class);
        this.repository = repository;
    }

    public void exist(final Category category){
        if(!repository.existsById(category.getId())){
            throw new ResourceNotFoundException("API-012");
        }
    }
}