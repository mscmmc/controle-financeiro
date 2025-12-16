package io.github.mscmmc.financialcontrol.service;

import io.github.mscmmc.financialcontrol.dto.TransactionResponseDTO;
import io.github.mscmmc.financialcontrol.mapper.TransactionMapper;
import io.github.mscmmc.financialcontrol.model.Category;
import io.github.mscmmc.financialcontrol.model.Transaction;
import io.github.mscmmc.financialcontrol.repository.CategoryRepository;
import io.github.mscmmc.financialcontrol.repository.TransactionRepository;
import io.github.mscmmc.financialcontrol.exception.NotFoundException;
import io.github.mscmmc.financialcontrol.dto.TransactionRequestDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;

    public TransactionService(TransactionRepository transactionRepository, CategoryRepository categoryRepository) {
        this.transactionRepository = transactionRepository;
        this.categoryRepository = categoryRepository;
    }

    public TransactionResponseDTO create(TransactionRequestDTO transactionRequestDTO) {
        Transaction transaction = new Transaction();
        transaction.setAmount(transactionRequestDTO.getAmount());
        transaction.setDescription(transactionRequestDTO.getDescription());
        transaction.setDate(transactionRequestDTO.getDate());

        if (transactionRequestDTO.getCategoryId() != null) {
            Category category = categoryRepository.findById(transactionRequestDTO.getCategoryId())
                    .orElseThrow(() -> new NotFoundException("Category not found"));
            transaction.setCategory(category);
        }

        Transaction saved =  transactionRepository.save(transaction);
        return TransactionMapper.toTransactionResponseDTO(saved);
    }

    public List<TransactionResponseDTO> findAll() {
        return transactionRepository.findAll()
                .stream()
                .map(TransactionMapper::toTransactionResponseDTO)
                .toList();
    }

    public TransactionResponseDTO findById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Transaction not found"));

        return TransactionMapper.toTransactionResponseDTO(transaction);
    }

    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }
}
