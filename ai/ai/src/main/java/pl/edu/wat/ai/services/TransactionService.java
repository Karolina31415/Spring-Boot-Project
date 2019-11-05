package pl.edu.wat.ai.services;

import pl.edu.wat.ai.dto.TransactionDTO;
import pl.edu.wat.ai.models.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    TransactionDTO addTransaction(String token, TransactionDTO transactionDTO);
    List<TransactionDTO> getTransactionByUser(String token);
    void deleteTransaction(String token, Integer id);
}
