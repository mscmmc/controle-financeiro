package io.github.mscmmc.financialcontrol.service;

import io.github.mscmmc.financialcontrol.model.Category;
import io.github.mscmmc.financialcontrol.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service //< Cria e gerencia um objeto dessa classe
public class CategoryService {
    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo; // Injeta um objeto CategoryRepository no CategoryService
    }

    public Category create(Category category) { //< Regra de negócio + persistência
        repo.findByNameIgnoreCase(category.getName())
                .ifPresent(existing -> {
                    throw new ResponseStatusException(
                            HttpStatus.BAD_REQUEST,
                            "Category name already exists"
                    );
                });
        return repo.save(category);
    }

    public List<Category> listAll(){ return repo.findAll(); }

    public Category get(Long id) { //< Busca pelo ID
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
    }

    public Category update(Long id, Category updated) {
        Category existing = get(id); //< Garantir que a categoria existe
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        return repo.save(existing); //< Salva com o mesmo ID
    }

    public void delete(Long id) { repo.deleteById(id); }
}
