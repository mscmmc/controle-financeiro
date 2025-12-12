package io.github.mscmmc.financialcontrol.repository;

import io.github.mscmmc.financialcontrol.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Herança de tudo do JpaRepository.
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}

