package aps.financemanagerapi.domain.category.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class CategoryTest {
    @Test
    public void shouldInstantiateCategoryObject(){
        final Category category = new Category();
        final Long id = 1L;
        category.setId(id);
        category.setName("Alimentação");
        category.setDescription("Descrição teste");
        category.setCreatedAt(LocalDateTime.now());
        category.setUpdatedAt(LocalDateTime.now());

        Assertions.assertEquals(id, category.getId());
    }
}