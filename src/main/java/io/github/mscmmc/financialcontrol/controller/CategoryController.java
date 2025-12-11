package io.github.mscmmc.financialcontrol.controller;

import io.github.mscmmc.financialcontrol.model.Category;
import io.github.mscmmc.financialcontrol.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;
import java.net.URI;

/**
 * Controller é a ponte entre o HTTP e a regra de negócio (service).
 * É o controlador REST: recebe requisições HTTP, valida entrada, chama o service
 * e devolve a resposta.
 */

@RestController
@RequestMapping("/api/categories")
@Validated
public class CategoryController {
    private final CategoryService service;

    public CategoryController(CategoryService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Category> create(@Valid @RequestBody Category category) {
        Category created = service.create(category);
        return ResponseEntity.created(URI.create("/api/categories/" + created.getId())).body(created);
    }

    @GetMapping
    public List<Category> list(){ return service.listAll(); }

    @GetMapping("/{id}")
    public Category get(@PathVariable Long id){ return service.get(id); } //< Converte /{id} para Long.

    @PutMapping("/{id}")
    public Category update(@PathVariable Long id, @Valid @RequestBody Category category){
        return service.update(id, category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
