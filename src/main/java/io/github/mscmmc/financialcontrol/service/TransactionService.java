package io.github.mscmmc.financialcontrol.service;

import io.github.mscmmc.financialcontrol.model.Category;
import io.github.mscmmc.financialcontrol.model.Transaction;
import io.github.mscmmc.financialcontrol.repository.TransactionRepository;
import io.github.mscmmc.financialcontrol.exception.NotFoundException;
import io.github.mscmmc.financialcontrol.dto.TransactionRequestDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;
    private final CategoryService categoryService;

    public TransactionService(TransactionRepository repository, CategoryService categoryService) {
        this.repository = repository;
        this.categoryService = categoryService;
    }

    public Transaction create(TransactionRequestDTO dto) {
        Category category = categoryService.get(dto.getCategoryId());

        Transaction transaction = new Transaction();

        transaction.setCategory(category);
        transaction.setAmount(dto.getAmount());
        transaction.setDescription(dto.getDescription());
        transaction.setDate(dto.getDate());

        return repository.save(transaction);
    }

    public List<Transaction> findAll() {
        return repository.findAll();
    }

    public Transaction findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Transaction with id " + id + " not found"));
    }

    public void deleteById(Long id) {
        Transaction transaction = findById(id); //< Garante que o ID existe antes de excluir
        repository.delete(transaction);
    }
}
