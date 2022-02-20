package aps.financemanagerapi.domain.category.mapper;


import aps.financemanagerapi.core.mapper.GenericMapper;
import aps.financemanagerapi.domain.category.dto.CategoryDTO;
import aps.financemanagerapi.domain.category.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends GenericMapper<Category, CategoryDTO> { }