package aps.financemanagerapi.domain.category.service;

import aps.financemanagerapi.core.service.BasicCrudService;
import aps.financemanagerapi.domain.category.entity.Category;
import aps.financemanagerapi.domain.category.repository.CategoryRepository;
import aps.financemanagerapi.domain.category.repository.spec.CategorySpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CategoryService extends BasicCrudService<Category, UUID> {
    @Autowired
    public CategoryService(final CategoryRepository repository, final CategorySpec spec) {
        super(repository, spec, Category.class);
    }
}