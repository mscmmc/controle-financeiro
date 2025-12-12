package io.github.mscmmc.financialcontrol.service;

import io.github.mscmmc.financialcontrol.model.Transaction;
import io.github.mscmmc.financialcontrol.repository.TransactionRepository;
import io.github.mscmmc.financialcontrol.exception.NotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Transaction create(Transaction transaction) {
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
