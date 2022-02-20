package aps.financemanagerapi.domain.category.repository;

import aps.financemanagerapi.core.repository.BaseRepository;
import aps.financemanagerapi.domain.category.entity.Category;

import java.util.UUID;

public interface CategoryRepository extends BaseRepository<Category, UUID> { }