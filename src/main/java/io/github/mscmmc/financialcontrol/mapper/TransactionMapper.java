package io.github.mscmmc.financialcontrol.mapper;

import io.github.mscmmc.financialcontrol.model.Transaction;
import io.github.mscmmc.financialcontrol.dto.TransactionResponseDTO;

/**
 * Responsabilidade do Mapper é converter um objeto em outro.
 * Não acessa banco nem tem regra de negócio, apenas traduz estruturas de dados.
 */
public class TransactionMapper {

    public static TransactionResponseDTO toTransactionResponseDTO(Transaction transaction) {
        TransactionResponseDTO transactionResponseDTO = new TransactionResponseDTO();

        transactionResponseDTO.setId(transaction.getId());

        if (transaction.getCategory() != null) {
            transactionResponseDTO.setCategoryName(transaction.getCategory().getName());
        }

        transactionResponseDTO.setAmount(transaction.getAmount());
        transactionResponseDTO.setDescription(transaction.getDescription());
        transactionResponseDTO.setDate(transaction.getDate());

        return transactionResponseDTO;
    }
}
