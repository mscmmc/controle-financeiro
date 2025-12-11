package io.github.mscmmc.financialcontrol.repository;

import io.github.mscmmc.financialcontrol.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

/**
 * Herda a API do Spring Data JPA permitindo operações CRUD.
 * E usa query derivada para buscar por nome.
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
    /**
     * Busca uma categoria pelo nome, ignorando case sensitivity.
     * É implementado automaticamente pelo Spring Data.
     */
    Optional<Category> findByNameIgnoreCase(String name);
}
