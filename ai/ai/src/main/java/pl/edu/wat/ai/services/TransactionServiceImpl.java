package pl.edu.wat.ai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wat.ai.dto.TransactionDTO;
import pl.edu.wat.ai.jwt.JwtProvider;
import pl.edu.wat.ai.models.Category;
import pl.edu.wat.ai.models.Transaction;
import pl.edu.wat.ai.models.User;
import pl.edu.wat.ai.repositories.CategoryRepository;
import pl.edu.wat.ai.repositories.TransactionRepository;
import pl.edu.wat.ai.repositories.UserRepository;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private User findUserByToken(String token) {
        String usernameFromToken = jwtProvider.getUserNameFromJwtToken(token.substring(7));
        return userRepository.findByUsername(usernameFromToken).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<TransactionDTO> getTransactionByUser(String token) {
        return findUserByToken(token).getTransactions().stream().map(this::transactionMapToDTO).collect(Collectors.toList());
    }

    public TransactionDTO transactionMapToDTO(Transaction transaction){
        return TransactionDTO.build(transaction);
    }

    @Override
    @Transactional
    public TransactionDTO addTransaction(String token, TransactionDTO transactionDTO){
        User user = findUserByToken(token);
        Category category = categoryRepository.getOne(transactionDTO.getIdCategory());
        Transaction transaction = new Transaction();
        transaction.changeAttributes(transactionDTO, user, category);
        Transaction savedTransaction = transactionRepository.save(transaction);
        user.getTransactions().add(transaction);
        userRepository.save(user);
        Transaction cratedTransaction = transactionRepository.findById(savedTransaction.getIdTransaction()).orElseThrow(EntityNotFoundException::new);
        return TransactionDTO.build(cratedTransaction);
    }

    @Override
    public void deleteTransaction(String token, Integer id){
        User user = findUserByToken(token);
        List<Transaction> transactionsToRemove = user.getTransactions().stream().filter(it -> id.equals(it.getIdTransaction())).collect(Collectors.toList());
        user.getTransactions().removeAll(transactionsToRemove);
        userRepository.save(user);
    }
}
