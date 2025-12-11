package io.github.mscmmc.financialcontrol.service;

import io.github.mscmmc.financialcontrol.model.Category;
import io.github.mscmmc.financialcontrol.repository.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository repo;

    public CategoryService(CategoryRepository repo) {
        this.repo = repo;
    }

    public Category create(Category category) {
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

    public Category get(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found"));
    }

    public Category update(Long id, Category updated) {
        Category existing = get(id);
        existing.setName(updated.getName());
        existing.setDescription(updated.getDescription());
        return repo.save(existing);
    }

    public void delete(Long id) { repo.deleteById(id); }
}
