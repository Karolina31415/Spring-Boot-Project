package pl.edu.wat.ai.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.wat.ai.dto.TransactionDTO;
import pl.edu.wat.ai.services.TransactionServiceImpl;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TransactionController {
    @Autowired
    TransactionServiceImpl transactionService;

    @GetMapping()
    private ResponseEntity<List<TransactionDTO>> getAllTransactions(@RequestHeader("Authorization") String token) {
        return new ResponseEntity<>(transactionService.getTransactionByUser(token), HttpStatus.OK);
    }
    @PostMapping()
    private ResponseEntity<TransactionDTO> addTransaction(@RequestHeader("Authorization") String token,
                                               @RequestBody TransactionDTO transactionDTO) {
        return new ResponseEntity<>(transactionService.addTransaction(token, transactionDTO), HttpStatus.CREATED);
    }
    /*
    @PostMapping("/many")
    private ResponseEntity<List<TransactionDTO>> addTransactions(@RequestHeader("Authorization") String token,
                                                          @RequestBody List<TransactionDTO> listTransactionDTO) {
        return new ResponseEntity<>(transactionService.addTransactions(token, listTransactionDTO), HttpStatus.CREATED);
    }*/
    @DeleteMapping("/{id}")
    private ResponseEntity deleteTransaction(@RequestHeader("Authorization") String token,
                                         @PathVariable int id) {
        transactionService.deleteTransaction(token, id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
