package com.example.Cordeiro.cordeiroProject.resources;


import com.example.Cordeiro.cordeiroProject.domain.transactions.Transaction;
import com.example.Cordeiro.cordeiroProject.dtos.TransactionDTO;
import com.example.Cordeiro.cordeiroProject.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
public class TransactionResource {

    @Autowired
    TransactionService transactionService;
    @PostMapping
   public ResponseEntity<Transaction> createTransaction (@RequestBody TransactionDTO transaction) throws Exception{
        Transaction newTransaction = transactionService.createTransaction(transaction);
        return  new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }


}
