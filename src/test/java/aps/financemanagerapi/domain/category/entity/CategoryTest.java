package aps.financemanagerapi.domain.category.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

public class CategoryTest {
    @Test
    public void shouldInstantiateCategoryObject(){
        final Category category = new Category();
        final UUID id = UUID.randomUUID();
        category.setId(id);
        category.setName("Alimentação");
        category.setDescription("Descrição teste");
        category.setCreatedAt(LocalDateTime.now());
        category.setUpdatedAt(LocalDateTime.now());

        Assertions.assertEquals(id, category.getId());
    }
}